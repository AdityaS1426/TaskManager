package myconnect;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.*;
import java.io.Serializable;


public class MyConnect {
    public static JsonArray useBearerToken(String bearerToken) {
        BufferedReader reader = null;
        try {
            URL url = new URL("https://poway.instructure.com/api/v1/users/self/upcoming_events?access_token=");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", "Bearer " + bearerToken);
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = null;
            StringWriter out = new StringWriter(connection.getContentLength() > 0 ? connection.getContentLength() : 1000000);
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }
            String response = out.toString();

            JsonParser parser = new JsonParser();
            JsonArray jArray = parser.parse(response).getAsJsonArray();

            return jArray;




        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new JsonArray();
    }

    public static void main(String args[]){
        useBearerToken("7~ftG9173DRIVR27rTJsvFpfO9nERzOWFlvb9fhf7MOtykEP1doD63DQXh9hszlyyW");
    }
}



