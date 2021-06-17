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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
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
        //String oName;
        ArrayList<TaskInfo> tasks = new ArrayList<TaskInfo>();
        for (int i = 0; i < taskService.findAll().size(); i++){
            Task t = taskService.findAll().get(i);
//            if(t.getOwner().getName() != null){
//                oName = t.getOwner().getName();
//            } else{
//                oName = "null";
//            }

            try{tasks.add(taskService.createTaskInfo(new TaskInfo(i+1, t.getName(), t.getDescription(), t.getDate(), t.isCompleted(), t.getCreatorName(), t.getOwner().getName())));} catch (Exception e) {
                tasks.add(taskService.createTaskInfo(new TaskInfo(i+1, t.getName(), t.getDescription(), t.getDate(), t.isCompleted(), t.getCreatorName(), "None")));
            }
        }
        return new ResponseEntity<ArrayList<TaskInfo>>(tasks, HttpStatus.OK);

    }
    @RequestMapping(value ="/addtask", method = RequestMethod.POST)
    public ResponseEntity<Object> addTask(@RequestParam(value = "name") String name,
                                          @RequestParam(value = "desc") String desc,
                                          @RequestParam(value = "date") LocalDate date,
                                          @RequestParam(value = "creator") String creator){
        //String oName;
        taskService.createTask(new Task(name, desc, date, false, creator));
        return new ResponseEntity<Object>("done", HttpStatus.OK);

    }
}
