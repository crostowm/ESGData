package com.esg.esgdata.model.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskDao {

    @Autowired
    TaskItemRepository itemRepository;

    @Autowired
    TaskTemplateRepository templateRepository;

    public TaskItem save(TaskItem taskItem) { return itemRepository.save(taskItem);}
    public TaskTemplate save(TaskTemplate taskTemplate) { return templateRepository.save(taskTemplate);}

    public List<TaskItem> getAllTaskItems()
    {
        List<TaskItem> tasks = new ArrayList<>();
        Streamable.of(itemRepository.findAll())
                .forEach(task -> {
                    tasks.add(task);
                });
        return tasks;
    }

    public List<TaskTemplate> getAllTaskTemplates()
    {
        List<TaskTemplate> tasks = new ArrayList<>();
        Streamable.of(templateRepository.findAll())
                .forEach(task -> {
                    tasks.add(task);
                });
        return tasks;
    }
    public TaskTemplate getTaskTemplate(String code) {
        List<TaskTemplate> tasks = new ArrayList<>();
        Streamable.of(templateRepository.findAll())
                .forEach(task -> {
                    if(task.getTaskCode().equals(code))
                        tasks.add(task);
                });
        if(tasks.size() > 0)
            return tasks.get(0);
        return null;
    }

    public void deleteItem(TaskId id)
    {
        itemRepository.deleteById(id);
    }
    public void deleteTemplate(String taskCode)
    {
        templateRepository.deleteById(taskCode);
    }

    public TaskItem getTaskItem(TaskId taskId) {
        List<TaskItem> tasks = new ArrayList<>();
        Streamable.of(itemRepository.findAll())
                .forEach(task -> {
                    if(task.getTaskCode().equals(taskId.getTaskCode())  && task.getDate().equals(taskId.getDate()))
                        tasks.add(task);
                });
        if(tasks.size() > 0)
            return tasks.get(0);
        return null;
    }

    public List<TaskItem> getAllTaskItemsForDate(LocalDate date) {
            List<TaskItem> tasks = new ArrayList<>();
            Streamable.of(itemRepository.findAll())
                    .forEach(task -> {
                        if (task.getDate().equals(date))
                            tasks.add(task);
                    });
            return tasks;
    }

}
