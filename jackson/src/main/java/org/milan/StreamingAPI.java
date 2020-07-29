package org.milan;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.File;
import java.io.IOException;

/**
 * JsonGenerator Example
 *
 * @author Milan Rathod
 */
public class StreamingAPI {

    private static final String FILE_PATH = "C:" + File.separator + "test" + File.separator + "testFile.json";

    public static void main(String[] args) {
        StreamingAPI streamingAPI = new StreamingAPI();

        streamingAPI.createJson(FILE_PATH);

        streamingAPI.parseJson(FILE_PATH);
    }

    /**
     * Using JsonGenerator to write contents into Json
     */
    public void createJson(String filePath) {
        JsonFactory jsonFactory = new JsonFactory();

        try (JsonGenerator jsonGenerator = jsonFactory.createGenerator(new File(filePath), JsonEncoding.UTF8)) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("name", "milan");
            jsonGenerator.writeNumberField("age", 25);
            jsonGenerator.writeFieldName("Messages");
            jsonGenerator.writeStartArray();
            jsonGenerator.writeString("msg 1");
            jsonGenerator.writeString("msg 2");
            jsonGenerator.writeString("msg 3");
            jsonGenerator.writeEndArray();
            jsonGenerator.writeEndObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Using JsonParser to read contents from Json
     */
    public void parseJson(String filePath) {
        JsonFactory jsonFactory = new JsonFactory();

        try (JsonParser jsonParser = jsonFactory.createParser(new File(filePath))) {
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = jsonParser.getCurrentName();
                if ("name".equals(fieldName)) {
                    jsonParser.nextToken();
                    System.out.println(jsonParser.getText());
                }
                if ("age".equals(fieldName)) {
                    jsonParser.nextToken();
                    System.out.println(jsonParser.getIntValue()); // display 29
                }
                if ("Messages".equals(fieldName)) {
                    jsonParser.nextToken();
                    while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                        System.out.println(jsonParser.getText());
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
