package myconnect;

import com.google.gson.Gson;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.io.Serializable;


public class MyConnect {

    private final static String praveenGump = "7~ftG9173DRIVR27rTJsvFpfO9nERzOWFlvb9fhf7MOtykEP1doD63DQXh9hszlyyW";

    public static String getPraveenGump() {
        return praveenGump;
    }

    public static String useBearerToken(String bearerToken) {
        BufferedReader reader = null;
        try {
            URL url = new URL("https://canvas.instructure.com/api/v1/courses");
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
            Gson gson = new Gson();



            System.out.println(gson.toJson(response));

            return response;
        } catch (Exception e) {
            return "";
        }
    }

    public static void main(String args[]){
        useBearerToken(praveenGump);
    }
}

