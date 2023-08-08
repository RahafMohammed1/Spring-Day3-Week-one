package com.example.tasktrackrsystem.TrackerControler;

import com.example.tasktrackrsystem.Model.Task;
import com.example.tasktrackrsystem.Response.ResponsMaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/")
public class Controller {
    //arrayList as a database
    public ArrayList<Task> tasks = new ArrayList<>();

    //Create a new taks (title , description , status)
    @PostMapping("/add")
    public String addTask(@RequestBody Task task) {
        tasks.add(task);
        return "your Task are added.....";

    }

    //Display all tasks
    @GetMapping("/display")
    public ResponsMaker displayAll() {
        return new ResponsMaker("your Tasks are: ", tasks);
    }

    //Update a task
    @PutMapping("/update/{index}")
    public String updateTask(@PathVariable int index, @RequestBody Task task) {
        tasks.set(index, task);
        return "your Task is updated";
    }

    //Delete a task
    @DeleteMapping("/delete/{index}")
    public String deleteTask(@PathVariable int index) {
        tasks.remove(index);
        return "Task is deleted";
    }

    //Change the task status as done or not done by Id
    @PutMapping("/change/{id}")
    public String changeTaskstatus(@PathVariable String id) {
       for (Task task : tasks)
       {
           if (task.getID().equalsIgnoreCase(id)) {
               if(task.getStatus().trim().equalsIgnoreCase("Done"))
               {
                   task.setStatus("Not Done");
               }
               else if(task.getStatus().trim().equalsIgnoreCase("Not Done")){

                   task.setStatus("Done");

               }
               break;
           }
       }
       return "your Task Statuse is updated";
    }
    //Search for a task by given title
    @GetMapping("/search/{title}")
    public String searchTask(@PathVariable String title) {

        for (Task task : tasks) {
            if (task.getTitle().trim().equalsIgnoreCase(title)) {
                return "The Task is found";
            }

        }
        return "The Task is not found";
    }




    }
