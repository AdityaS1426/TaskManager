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
import com.booleans.taskmanagement.service.TaskService;

import java.util.List;

@Controller
public class APIController {

    private UserService userService;
    private TaskService taskService;

    @Autowired
    public APIController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }



    @RequestMapping("/allusers")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);

    }

    @RequestMapping(value ="/alltasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        return new ResponseEntity<>(taskService.findAll(), HttpStatus.OK);

    }
}
