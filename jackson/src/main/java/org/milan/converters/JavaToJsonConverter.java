package org.milan.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.milan.Views;
import org.milan.models.Staff;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Convert JavaToJsonConverter to String Object
 *
 * @author Milan Rathod
 */
public class JavaToJsonConverter {

    private ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        JavaToJsonConverter javaToJsonConverter = new JavaToJsonConverter();

        Staff staff = getStaff();

        javaToJsonConverter.convertWithoutPrettyPrinter(staff);

        javaToJsonConverter.convertWithPrettyPrinter(staff);

        javaToJsonConverter.convertWithViews(staff, "Normal");

        javaToJsonConverter.convertWithViews(staff, "Manager");
    }

    public String convertWithoutPrettyPrinter(Staff staff) {

        String value = null;

        try {
            value = objectMapper.writeValueAsString(staff);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return value;
    }

    public String convertWithPrettyPrinter(Staff staff) {

        String value = null;

        try {
            value = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return value;
    }

    public String convertWithViews(Staff staff, String view) {

        String value = null;

        try {

            if ("Manager".equals(view)) {
                value = objectMapper.writerWithView(Views.Manager.class).writeValueAsString(staff);
            } else {
                value = objectMapper.writerWithView(Views.Normal.class).writeValueAsString(staff);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    private static Staff getStaff() {
        Staff staff = new Staff();
        staff.setName("Milan");
        staff.setAge(25);
        staff.setPosition("Developer");
        staff.setSalary(new BigDecimal(25000));
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("J2EE");
        skills.add("Spring");
        staff.setSkills(skills);
        return staff;
    }
}
