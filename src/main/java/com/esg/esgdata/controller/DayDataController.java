package com.esg.esgdata.controller;

import com.esg.esgdata.model.daydata.DayData;
import com.esg.esgdata.model.daydata.DayDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

public class DayDataController {
/*
    @Autowired
    private DayDataDao dayDataDao;

    @GetMapping("/day-data/get-all")
    public List<DayData> getAllDayData() {
        return dayDataDao.getAllDayData();
    }

    @GetMapping("/day-data/get/{date}")
    public DayData getDayData(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        System.out.println(date.toString());
        return dayDataDao.getDayDataById(date);
    }

    @PostMapping("/day-data/save")
    public DayData saveDayData(@RequestBody DayData dayData) {
        return dayDataDao.save(dayData);
    }*/
}
