package com.booleans.taskmanagement.controller;

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
    public ResponseEntity<ArrayList<TaskInfo>> getAllTasks(){
        String oName;
        ArrayList<TaskInfo> tasks = new ArrayList<TaskInfo>();
        for (int i = 0; i < taskService.findAll().size(); i++){
            Task t = taskService.findAll().get(i);
            if(t.getOwner().getName() != null){
                oName = t.getOwner().getName();
            } else{
                oName = "null";
            }

            tasks.add(taskService.createTaskInfo(new TaskInfo(i+1, t.getName(), t.getDescription(), t.getDate(), t.isCompleted(), t.getCreatorName(), oName)));
        }
        return new ResponseEntity<ArrayList<TaskInfo>>(tasks, HttpStatus.OK);

    }
}
