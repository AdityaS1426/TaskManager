
package com.booleans.taskmanagement.controller;

import com.google.gson.*;
import myconnect.MyConnect;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CanvasController {


    public String makeAndDisplayCanvasRequestWithToken(String token, Model model) {

        Gson gson = new Gson();

        JsonArray jsonArray;

        if (token.equals("default")) {
            jsonArray = MyConnect.useBearerToken("2573~ItrAt05i2htYJJpaHBCBdMuKpgJ1CpmgCndfkVPIK8IDeAT6lyWhxRihHZG8z9UG");
        } else {
            jsonArray = MyConnect.useBearerToken(token);
        }




        JsonArray newJArray = new JsonArray();

        for (JsonElement element : jsonArray)
        {
            if(element.isJsonObject())
            {
                //object to be returned
                JsonObject newObject = new JsonObject();

                //input converted to object
                JsonObject object = element.getAsJsonObject();

                newObject.add("title",object.get("title"));

                JsonObject assignment = new JsonObject();
                assignment.add("name",object.get("title"));
                assignment.add("due_at", object.getAsJsonObject("assignment").get("due_at"));
                assignment.add("points_possible", object.getAsJsonObject("assignment").get("points_possible"));
                assignment.add("allowed_attempts", object.getAsJsonObject("assignment").get("allowed_attempts"));

                newJArray.add(assignment);





            }
        }
        model.addAttribute("canvasData",gson.toJson(newJArray));

        System.out.println(gson.toJson(newJArray));
        return "views/myconnect";

    }

    @RequestMapping(value="/myconnect",method={RequestMethod.POST})
    public String showCanvasData(@RequestParam(name="totID",required = false) String token, Model model) {

        System.out.println(token);

        return makeAndDisplayCanvasRequestWithToken(token,model);



        //makeAndDisplayCanvasRequestWithToken("default",model);


    }





   @RequestMapping(value="/myconnect", method = {RequestMethod.GET})
    public String showSampleCanvasData(Model model) {

        System.out.println("GetMapping invoked");
       return makeAndDisplayCanvasRequestWithToken("default",model);

    }


}
