package org.milan.converters;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.milan.models.User;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/**
 * Test Class for {@link JsonToJavaConverter}
 *
 * @author Milan Rathod
 */
public class JsonToJavaConverterTest {

    private JsonToJavaConverter jsonToJavaConverter;

    @Before
    public void setup() {
        jsonToJavaConverter = new JsonToJavaConverter();

    }

    @Test
    public void convert() {
        String testJson = "{\n" +
                "    \"name\": \"Milan\",\n" +
                "    \"username\": \"mirathod\",\n" +
                "    \"number\": 8989898989, \n" +
                "    \"birthDate\": \"1991-10-05\"}";

        User result = jsonToJavaConverter.convert(testJson);

        Assert.assertEquals("Milan", result.getName());
        Assert.assertEquals("mirathod", result.getUsername());
        Assert.assertEquals(8989898989L, result.getNumber());
    }

    @Test
    public void convert1() {
        String filePath = getClass().getClassLoader().getResource("testFile.json").getFile();
        Map<String, Object> result = jsonToJavaConverter.convert(new File(filePath));

        Assert.assertEquals("Milan", result.get("name").toString());
        Assert.assertEquals("mithapur", result.get("city").toString());
        Assert.assertEquals(3, ((ArrayList) result.get("messages")).size());
    }
}