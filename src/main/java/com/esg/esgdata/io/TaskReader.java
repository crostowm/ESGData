package com.esg.esgdata.io;


import com.esg.esgdata.model.task.TaskCategory;
import com.esg.esgdata.model.task.TaskTemplate;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TaskReader {


    public List<TaskTemplate> readTasks(String fileName)
    {
        List<TaskTemplate> taskTemplates = new ArrayList<>();
        try {
            BufferedReader scanner = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
            String taskCode;
            while ((taskCode = scanner.readLine()) != null) {
                TaskCategory category = getCategory(taskCode);
                String shortDesc = scanner.readLine();
                String longLine;
                String longDesc = scanner.readLine();
                while(!(longLine = scanner.readLine()).equals("")) {
                    longDesc += "\n" + longLine;
                }

                taskTemplates.add(new TaskTemplate(taskCode, category, shortDesc, longDesc));
            }
            scanner.close();
        } catch (

                Exception e) {
            e.printStackTrace();
        }
        return taskTemplates;
    }

    private TaskCategory getCategory(String taskCode) {
        String cat = taskCode.split("_")[0];
        switch(cat) {
            case "open":
            case "proj":
                return TaskCategory.Open;
            case "lunch":
                return TaskCategory.ALCU;
            default:
                return null;
        }

    }
}
