package org.milan.converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.milan.models.User;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test Class for {@link JsonToJavaConverter}
 *
 * @author Milan Rathod
 */
public class JsonToJavaConverterTest {

    private JsonToJavaConverter jsonToJavaConverter;

    @BeforeEach
    public void setup() {
        jsonToJavaConverter = new JsonToJavaConverter();

    }

    @Test
    void convert() {
        String testJson = "{\n" +
                "    \"name\": \"Milan\",\n" +
                "    \"username\": \"mirathod\",\n" +
                "    \"number\": 8989898989, \n" +
                "    \"birthDate\": \"1991-10-05\"}";

        User result = jsonToJavaConverter.convert(testJson);

        assertEquals("Milan", result.getName());
        assertEquals("mirathod", result.getUsername());
        assertEquals(8989898989L, result.getNumber());
    }

    @Test
    void convert1() {
        String filePath = getClass().getClassLoader().getResource("testFile.json").getFile();
        Map<String, Object> result = jsonToJavaConverter.convert(new File(filePath));

        assertEquals("Milan", result.get("name").toString());
        assertEquals("mithapur", result.get("city").toString());
        assertEquals(3, ((ArrayList) result.get("messages")).size());
    }
}