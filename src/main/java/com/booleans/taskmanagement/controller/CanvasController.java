
package com.booleans.taskmanagement.controller;

import com.google.api.client.json.Json;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import myconnect.MyConnect;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CanvasController {


    @GetMapping("/myconnect")
    public String showCanvasData(Model model) {




        JsonArray jArray = MyConnect.useBearerToken("2573~jiT8XF7CGDmRznvjPJtW2VMYapYeaJBaA5XY0xXc2laDTR4Wc54Jit6RSzdOmyjT");

        JsonArray newJArray = new JsonArray();

        for (JsonElement element : jArray)
        {
            if(element.isJsonObject())
            {

                JsonObject jsonObject = new JsonObject();

                JsonObject object = element.getAsJsonObject();

                jsonObject.add("title",object.get("title"));

                JsonObject assignments = new JsonObject();
                assignments.add("due_at", object.getAsJsonObject("assignment").get("due_at"));
                assignments.add("points_possible", object.getAsJsonObject("assignment").get("points_possible"));
                assignments.add("allowed_attempts", object.getAsJsonObject("assignment").get("allowed_attempts"));

                jsonObject.add("assignments",assignments);

                jsonObject.add("assignment",object.get("assignment"));

                model.addAttribute("canvasData",jsonObject);
                break;
            }
        }


    return "views/myconnect";
    }


}
