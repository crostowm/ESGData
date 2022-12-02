package com.esg.esgdata.controller;

import com.esg.esgdata.model.task.TaskDao;
import com.esg.esgdata.model.task.TaskId;
import com.esg.esgdata.model.task.TaskItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TaskItemController {

    @Autowired
    private TaskDao taskItemDao;

    @GetMapping("/task-item/get-all")
    public List<TaskItem> getAllTaskItems() {
        return taskItemDao.getAllTaskItems();
    }

    @GetMapping("/task-item/get-all-for-date/{date}")
    public List<TaskItem> getAllTaskItemsForDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return taskItemDao.getAllTaskItemsForDate(date);
    }

    @GetMapping("/task-item/get-by-code/{date}/{code}")
    public TaskItem getTaskItemByCode(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @PathVariable String code) {return taskItemDao.getTaskItem(new TaskId(code, date));}

    @PostMapping("/task-item/save")
    public TaskItem saveTaskItems(@RequestBody TaskItem taskItem) {
        return taskItemDao.save(taskItem);
    }
}
