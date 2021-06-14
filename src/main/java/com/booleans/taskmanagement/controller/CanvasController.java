package com.booleans.taskmanagement.controller;

import myconnect.MyConnect;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CanvasController {

    @GetMapping("/myconnect")
    public String showCanvasData(Model model) {
        model.addAttribute("canvasData",MyConnect.useBearerToken(MyConnect.getPraveenGump()));
        return "views/myconnect";
    }


}
