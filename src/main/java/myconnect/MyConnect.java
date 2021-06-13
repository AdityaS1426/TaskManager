/*
package myconnect;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyConnect {
    private String url_string;
    private Object currentGrade;
    private Object assignment1;
    private Object assignment2;
    private Object assignment3;
    private Object assignment1link;
    private Object assignment2link;
    private Object assignment3link;
    private Object assignment1desc;
    private Object assignment2desc;
    private Object assignment3desc;



    public static Map<String, Object> jsonToMap (String str) {
        Map<String, Object> map = new Gson().fromJson (
                str, new TypeToken<HashMap<String, Object>>() {}.getType()
        );
        return map;
    }

    public MyConnect(String a) {
        String API_KEY = a;
        url_string = "https://poway.instructure.com/api/v1/users/self/upcoming_events?access_token=" + API_KEY;

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");
        Date result1;
        Date result2;
        Date result3;

        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(url_string);
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result .append(line);
            }
            rd.close();

            JSONArray jsonArray = new JSONArray(result.toString());
            Map<String, Object> respMap1 = jsonToMap(jsonArray.getJSONObject(0).toString());
            Map<String, Object> respMap2 = jsonToMap(jsonArray.getJSONObject(1).toString());
            Map<String, Object> respMap3 = jsonToMap(jsonArray.getJSONObject(2).toString());

            assignment1 = respMap1.get("title");
            assignment2 = respMap2.get("title");
            assignment3 = respMap3.get("title");

            assignment1link = respMap1.get("html_url");
            assignment2link = respMap2.get("html_url");
            assignment3link = respMap3.get("html_url");

            assignment1desc = respMap1.get("points_possible");
            assignment2desc = respMap2.get("points_possible");
            assignment3desc = respMap3.get("points_possible");


        } catch (IOException | JSONException e) {
            System.out.println(e.getMessage());
        }
    }

    public Object return1() {
        return assignment1;
    }

    public Object return2() {
        return assignment2;
    }

    public Object return3() {
        return assignment3;
    }

    public Object return1link() {
        return assignment1link;
    }

    public Object return2link() {
        return assignment2link;
    }

    public Object return3link() {
        return assignment3link;
    }

    public Object return1desc() { return assignment1desc; }

    public Object return2desc() { return assignment2desc; }

    public Object return3desc() { return assignment3desc; }


}
*/