package org.milan;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Tree Model For Jackson Json Example
 *
 * @author Milan Rathod
 */
public class JsonTree {

    private static final String FILE_PATH = "C:" + File.separator + "test" + File.separator + "jsonTree.json";

    private ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        JsonTree jsonTree = new JsonTree();

        jsonTree.write(FILE_PATH);

        jsonTree.read(FILE_PATH);
    }

    public void read(String filePath) {
        try {
            JsonNode jsonNode = objectMapper.readTree(new FileReader(FILE_PATH));
            if (jsonNode != null) {
                System.out.println(jsonNode.path("id").asLong());

                System.out.println(jsonNode.path("name").asText());

                JsonNode gamesNode = jsonNode.path("games");

                if (gamesNode.isArray()) {
                    for (JsonNode node : gamesNode) {
                        System.out.println(node.path("name").asText());
                        System.out.println(node.path("price").asDouble());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void write(String filePath) {
        try {
            JsonNode root = objectMapper.readTree(new File(filePath));

            System.out.println("Before Update");
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root));

            ((ObjectNode) root).put("id", 100L);

            ((ObjectNode) root).put("name", "milan");

            ObjectNode positionNode = objectMapper.createObjectNode();
            positionNode.put("name", "Developer");
            positionNode.put("years", 10);
            ((ObjectNode) root).set("position", positionNode);

            ArrayNode gamesNode = objectMapper.createArrayNode();

            ObjectNode game1 = objectMapper.createObjectNode();
            game1.put("name", "Fall Out 4");
            game1.put("price", 49.9);

            ObjectNode game2 = objectMapper.createObjectNode();
            game2.put("name", "Dark Soul 3");
            game2.put("price", 59.9);

            gamesNode.add(game1);
            gamesNode.add(game2);
            ((ObjectNode) root).set("games", gamesNode);

            System.out.println("After Update");
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root));

            objectMapper.writeValue(new File(filePath), root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
