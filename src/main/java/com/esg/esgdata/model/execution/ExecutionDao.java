package com.esg.esgdata.model.execution;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExecutionDao {

    @Autowired
    ExecutionChartRepository repository;

    public ExecutionChart save(ExecutionChart executionChart) { return repository.save(executionChart);}

    public List<ExecutionChart> getAllExecutionChart()
    {
        List<ExecutionChart> executionCharts = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(executionChart -> {
                    executionCharts.add(executionChart);
                });
        return executionCharts;
    }

    public void deleteExecutionChart(LocalDate date, String lunchOrDinner)
    {
        repository.deleteById(new ExecutionId(date, lunchOrDinner));
    }

    public ExecutionChart getExecutionChart(LocalDate date, String lunchOrDinner) {
        List<ExecutionChart> daySales = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(daySale -> {
                    if(daySale.getDate().equals(date) && daySale.getLunchOrDinner().equals(lunchOrDinner))
                        daySales.add(daySale);
                });
        if(daySales.size() > 0)
            return daySales.get(0);
        return null;
    }
}
