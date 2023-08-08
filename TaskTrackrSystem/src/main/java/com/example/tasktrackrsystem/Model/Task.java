package com.example.tasktrackrsystem.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Task {
    private String ID;
    private String title;
    private String description;
    private String status;

}




