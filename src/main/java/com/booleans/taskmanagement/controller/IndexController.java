package com.booleans.taskmanagement.controller;

import com.booleans.taskmanagement.model.Task;
import com.booleans.taskmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.booleans.taskmanagement.service.UserService;
import com.booleans.taskmanagement.model.User;

import java.util.List;

@Controller
public class IndexController {

    private UserService userService;

    @Autowired
    public IndexController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/")
    String showIndex() {
        return "index";
    }

    @RequestMapping("/allusers")
    public ResponseEntity<List<User>> users(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);

    }
}
