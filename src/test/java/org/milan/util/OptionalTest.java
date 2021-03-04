package org.milan.util;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Use cases for {@link java.util.Optional}
 * <p>
 * Refer: {@link @https://www.baeldung.com/java-optional}
 *
 * @author Milan Rathod
 */
class OptionalTest {

    @Test
    void whenCreatesEmptyOptional() {
        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());
    }

    @Test
    void givenNonNull_whenCreatesNonNullable() {
        String name = "optional";
        Optional<String> optional = Optional.of(name);
        assertTrue(optional.isPresent());
    }

    @Test
    void givenNull_whenThrowsErrorOnCreate() {
        String name = null;
        assertThrows(NullPointerException.class, () -> {
            Optional.of(name);
        });
    }

    @Test
    void givenNonNull_whenCreatesNullable() {
        String name = "optional";
        Optional<String> opt = Optional.ofNullable(name);
        assertTrue(opt.isPresent());
    }

    @Test
    void givenNull_whenCreatesNullable() {
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        assertFalse(opt.isPresent());
    }

    @Test
    void givenAnEmptyOptional_thenIsEmptyBehavesAsExpected() {
        Optional<String> opt = Optional.of("optional");
        assertFalse(opt.isEmpty());

        opt = Optional.ofNullable(null);
        assertTrue(opt.isEmpty());
    }

    @Test
    void givenOptional_whenIfPresentWorks() {
        Optional<String> opt = Optional.of("optional");
        opt.ifPresent(name -> System.out.println(name.length()));
    }

    @Test
    void whenOrElseWorks() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("john");
        assertEquals("john", name);
    }

    @Test
    void whenOrElseGetWorks() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseGet(() -> "john");
        assertEquals("john", name);
    }

    @Test
    void whenOrElseGetAndOrElseOverlap() {
        String text = null;

        String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertEquals("Default Value", defaultText);

        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        assertEquals("Default Value", defaultText);
    }

    @Test
    void whenOrElseGetAndOrElseDiffer() {
        String text = "Text present";

        System.out.println("Using orElseGet:");
        String defaultText
                = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertEquals("Text present", defaultText);

        System.out.println("Using orElse:");
        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        assertEquals("Text present", defaultText);
    }

    @Test
    void whenOrElseThrowWorks() {
        String nullName = null;
        assertThrows(IllegalArgumentException.class, () -> {
            Optional.ofNullable(nullName).orElseThrow(
                    IllegalArgumentException::new);
        });
    }

    @Test
    void givenOptional_whenGetsValue() {
        Optional<String> opt = Optional.of("optional");
        String name = opt.get();
        assertEquals("optional", name);
    }

    @Test
    void givenOptionalWithNull_whenGetThrowsException() {
        Optional<String> opt = Optional.ofNullable(null);
        assertThrows(NoSuchElementException.class, opt::get);
    }

    @Test
    void whenOptionalFilterWorks() {
        Integer year = 2016;
        Optional<Integer> yearOptional = Optional.of(year);
        boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
        assertTrue(is2016);
        boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
        assertFalse(is2017);
    }

    @Test
    void givenOptional_whenMapWorks() {
        List<String> companyNames = Arrays.asList(
                "paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOptional = Optional.of(companyNames);

        int size = listOptional
                .map(List::size)
                .orElse(0);
        assertEquals(6, size);
    }

    @Test
    void givenOptional_whenMapWorks2() {
        String name = "optional";
        Optional<String> nameOptional = Optional.of(name);

        int len = nameOptional
                .map(String::length)
                .orElse(0);
        assertEquals(8, len);
    }

    @Test
    void givenOptional_whenFlatMapWorks_thenCorrect2() {
        Person person = new Person("test");

        Optional<Person> personOptional = Optional.of(person);

        // map() implementation does an additional wrapping internally
        Optional<Optional<String>> nameOptionalWrapper = personOptional.map(Person::getName);

        // Additional null-safety is needed
        Optional<String> testName = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);

        String name = testName.orElse("");

        assertEquals("test", name);

        // flatMap() is being used for flat structure
        name = personOptional.flatMap(Person::getName).orElse("");

        assertEquals("test", name);
    }

    @Test
    void givenThreeOptionals_whenChaining_thenFirstNonEmptyIsReturned() {
        Optional<String> found = Stream.of(getEmpty(), getHello(), getBye())
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();

        assertEquals(getHello(), found);
    }

    @Test
    void givenThreeOptionals_whenChaining_thenFirstNonEmptyIsReturnedAndRestNotEvaluated() {
        Optional<String> found =
                Stream.<Supplier<Optional<String>>>of(this::getEmpty, this::getHello, this::getBye)
                        .map(Supplier::get)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .findFirst();

        assertEquals(getHello(), found);
    }

    @Test
    void givenTwoOptionalsReturnedByOneArgMethod_whenChaining_thenFirstNonEmptyIsReturned() {
        Optional<String> found = Stream.<Supplier<Optional<String>>>of(
                () -> createOptional("empty"),
                () -> createOptional("hello")
        )
                .map(Supplier::get)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();

        assertEquals(createOptional("hello"), found);
    }

    @Test
    void givenTwoEmptyOptionals_whenChaining_thenDefaultIsReturned() {
        String found = Stream.<Supplier<Optional<String>>>of(
                () -> createOptional("empty"),
                () -> createOptional("empty")
        )
                .map(Supplier::get)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .orElseGet(() -> "default");

        assertEquals("default", found);
    }

    @Test
    void givenOptional_whenPresent_thenShouldTakeAValueFromIt() {
        Optional<String> value = Optional.of("value");
        Optional<String> defaultValue = Optional.of("default");

        Optional<String> result = value.or(() -> defaultValue);

        assertEquals("value", result.get());
    }

    @Test
    void givenOptional_whenEmpty_thenShouldTakeAValueFromOr() {
        Optional<String> value = Optional.empty();
        Optional<String> defaultValue = Optional.of("default");

        Optional<String> result = value.or(() -> defaultValue);

        assertEquals("default", result.get());
    }

    @Test
    void givenOptional_whenPresent_thenShouldExecuteProperCallback() {
        // given
        Optional<String> value = Optional.of("properValue");
        AtomicInteger successCounter = new AtomicInteger(0);
        AtomicInteger onEmptyOptionalCounter = new AtomicInteger(0);

        // when
        value.ifPresentOrElse(
                v -> successCounter.incrementAndGet(),
                onEmptyOptionalCounter::incrementAndGet);

        // then
        assertEquals(1, successCounter.get());
        assertEquals(0, onEmptyOptionalCounter.get());
    }

    @Test
    void givenOptional_whenNotPresent_thenShouldExecuteProperCallback() {
        // given
        Optional<String> value = Optional.empty();
        AtomicInteger successCounter = new AtomicInteger(0);
        AtomicInteger onEmptyOptionalCounter = new AtomicInteger(0);

        // when
        value.ifPresentOrElse(
                v -> successCounter.incrementAndGet(),
                onEmptyOptionalCounter::incrementAndGet);

        // then
        assertEquals(0, successCounter.get());
        assertEquals(1, onEmptyOptionalCounter.get());
    }

    @Test
    void givenOptionalOfSome_whenToStream_thenShouldTreatItAsOneElementStream() {
        // given
        Optional<String> value = Optional.of("a");

        // when
        List<String> collect = value.stream().map(String::toUpperCase).collect(Collectors.toList());

        // then
        assertTrue(ListUtil.isEqual(Collections.singletonList("A"), collect));
    }

    @Test
    void givenOptionalOfNone_whenToStream_thenShouldTreatItAsZeroElementStream() {
        // given
        Optional<String> value = Optional.empty();

        // when
        List<String> collect = value.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        // then
        assertTrue(collect.isEmpty());
    }

    private String getMyDefault() {
        System.out.println("Getting Default Value");
        return "Default Value";
    }

    private Optional<String> getEmpty() {
        return Optional.empty();
    }

    private Optional<String> getHello() {
        return Optional.of("hello");
    }

    private Optional<String> getBye() {
        return Optional.of("bye");
    }

    private Optional<String> createOptional(String input) {
        if (input == null || "".equals(input) || "empty".equals(input)) {
            return Optional.empty();
        }
        return Optional.of(input);
    }
}

class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    Optional<String> getName() {
        return Optional.ofNullable(name);
    }
}