package com.example.tasktrackrsystem.Response;

import com.example.tasktrackrsystem.Model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
@Data
@AllArgsConstructor
public class ResponsMaker {
  private String massage;
  private ArrayList<Task> tasks;
}
