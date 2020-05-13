package org.milan.misc;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem: https://stackoverflow.com/questions/48448432/fragment-of-missing-code-in-the-solution-movie-titles-complete-a-challenge-more/48656211
 *
 * @author Milan Rathod
 */
public class HttpGet {

    public static void main(String[] args) {
        new HttpGet().get();
    }

    public void get() {
        List<String> output = new ArrayList<>();

        String substr = "spiderman";

        int startPage = 1;

        int totalPages = Integer.MAX_VALUE;

        while (startPage <= totalPages) {
            try {
                URL url = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr + "&page=" + startPage);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("GET");

                InputStream inputStream = httpURLConnection.getInputStream();

                Gson gson = new Gson();

                JsonObject jsonObject = gson.fromJson(new InputStreamReader(inputStream), JsonObject.class);

                JsonArray data = jsonObject.getAsJsonArray("data");

                for (int i = 0; i < data.size(); i++) {
                    String title = data.get(i).getAsJsonObject().get("Title").getAsString();
                    output.add(title);
                }

                totalPages = jsonObject.get("total_pages").getAsInt();

                startPage++;

            } catch (Exception e) {
                System.out.println("Exception Thrown");
            }

        }

        Collections.sort(output);

        System.out.println(output);
    }
}
