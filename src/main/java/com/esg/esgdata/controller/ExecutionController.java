package com.esg.esgdata.controller;

import com.esg.esgdata.model.execution.ExecutionChart;
import com.esg.esgdata.model.execution.ExecutionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ExecutionController {

    @Autowired
    private ExecutionDao executionDao;

    @GetMapping("/execution-chart/get-all")
    public List<ExecutionChart> getExecutionCharts() {
        return executionDao.getAllExecutionChart();
    }

    @GetMapping("/execution-chart/get/{date}/{lunchOrDinner}")
    public ExecutionChart getExecutionChart(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, @PathVariable String lunchOrDinner) {
        return executionDao.getExecutionChart(date, lunchOrDinner);
    }

    @PostMapping("/execution-chart/save")
    public ExecutionChart saveExecutionChart(@RequestBody ExecutionChart executionChart) {
        System.out.println("Saving Execution Chart: " + executionChart.toString());
        return executionDao.save(executionChart);
    }
}
