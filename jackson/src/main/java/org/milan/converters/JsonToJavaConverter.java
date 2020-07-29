package org.milan.converters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.milan.models.User;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Json Object to Java Object Converter
 *
 * @author Milan Rathod
 */
public class JsonToJavaConverter {

    public User convert(String json) {
        User user = null;
        try {
            user = new ObjectMapper().readValue(json, User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    public Map<String, Object> convert(File file) {
        Map<String, Object> values = null;
        try {
            values = new ObjectMapper().readValue(file, new TypeReference<Map<String, Object>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        return values;
    }
}
