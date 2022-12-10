package com.esg.esgdata.controller;

import com.esg.esgdata.model.task.TaskDao;
import com.esg.esgdata.model.task.TaskTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskTemplateController {

    @Autowired
    private TaskDao taskTemplateDao;

    @GetMapping("/task-template/get-all")
    public List<TaskTemplate> getAllTaskTemplates() {
        return taskTemplateDao.getAllTaskTemplates();
    }

    @GetMapping("/task-template/get-by-code/{code}")
    public TaskTemplate getTaskTemplateByCode(@PathVariable String code) {return taskTemplateDao.getTaskTemplate(code);}

    @PostMapping("/task-template/save")
    public TaskTemplate saveTaskTemplates(@RequestBody TaskTemplate taskTemplate) {
        return taskTemplateDao.save(taskTemplate);
    }
}
