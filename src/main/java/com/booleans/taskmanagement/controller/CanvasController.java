
package com.booleans.taskmanagement.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import myconnect.MyConnect;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CanvasController {


    public String makeAndDisplayCanvasRequestWithToken(String token, Model model) {


        if (token.equals("default")) {
            token = "2573~jiT8XF7CGDmRznvjPJtW2VMYapYeaJBaA5XY0xXc2laDTR4Wc54Jit6RSzdOmyjT";
        }

        JsonArray jArray = MyConnect.useBearerToken(token);


        JsonArray newJArray = new JsonArray();

        for (JsonElement element : jArray)
        {
            if(element.isJsonObject())
            {
                //object to be returned
                JsonObject newObject = new JsonObject();

                //input converted to object
                JsonObject object = element.getAsJsonObject();

                newObject.add("title",object.get("title"));

                JsonObject assignments = new JsonObject();
                assignments.add("due_at", object.getAsJsonObject("assignment").get("due_at"));
                assignments.add("points_possible", object.getAsJsonObject("assignment").get("points_possible"));
                assignments.add("allowed_attempts", object.getAsJsonObject("assignment").get("allowed_attempts"));

                newObject.add("assignments",assignments);


                model.addAttribute("canvasData",newObject);
                break;
            }
        }
        return "views/myconnect";

    }

    @RequestMapping(value="/myconnect",method={RequestMethod.POST})
    public String showCanvasData(@RequestParam(name="totID",required = false) String token, Model model) {

        System.out.println(token);
        model.addAttribute("canvasData", token);
        return "views/myconnect";

        //makeAndDisplayCanvasRequestWithToken("default",model);


    }





   @RequestMapping(value="/myconnect", method = {RequestMethod.GET})
    public String showSampleCanvasData(Model model) {

        System.out.println("GetMapping invoked");
       return makeAndDisplayCanvasRequestWithToken("default",model);

    }


}
