package com.booleans.taskmanagement.controller;

import com.booleans.taskmanagement.service.TaskService;
import com.booleans.taskmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CrossoverController {
    private UserService userService;
    private TaskService taskService;

    @Autowired
    public CrossoverController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/cross")
    public String getAllUsers(){
        //ArrayList<String> comments = new ArrayList<String>();
        //comments.add("test");
        //comments.add("test2");
        //model.addAttribute("comments", comments);
        return "views/crossover";
    }


}
