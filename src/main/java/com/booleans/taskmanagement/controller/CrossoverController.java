package com.booleans.taskmanagement.controller;

import com.booleans.taskmanagement.model.User;
import com.booleans.taskmanagement.service.TaskService;
import com.booleans.taskmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.booleans.taskmanagement.model.Task;
import com.booleans.taskmanagement.model.TaskInfo;
import com.booleans.taskmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.booleans.taskmanagement.service.UserService;
import com.booleans.taskmanagement.model.User;
import com.booleans.taskmanagement.service.TaskService;


import java.util.ArrayList;
import java.util.List;
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
    public String getAllUsers(Model model){
        ArrayList<String> comments = new ArrayList<String>();
        comments.add("test");
        comments.add("test2");
        model.addAttribute("comments", comments);
        return "views/crossover";
    }


}
