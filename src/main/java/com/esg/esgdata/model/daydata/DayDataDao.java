package com.esg.esgdata.model.daydata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DayDataDao {
    /*@Autowired
    private DayDataRepository repository;

    public DayData save(DayData dayData) {
        return repository.save(dayData);
    }

    public List<DayData> getAllDayData() {
        List<DayData> dayData = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(dayDatum -> {
                    dayData.add(dayDatum);
                });
        //System.out.println("Prep Size: " + dayData.get(0).getAllPrepItem().size());
        return dayData;
    }

    public void delete(LocalDate date) {
        repository.deleteById(date);
    }

    *//*public DayData getDayDataById(LocalDate date) {
        List<DayData> dayData = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(dayDatum -> {
                    if(dayDatum.getDate().equals(date))
                        dayData.add(dayDatum);
                });
        System.out.println("Prep Size: " + dayData.get(0).getAllPrepItem().size());
        if(dayData.size() > 0)
            return dayData.get(0);
        return null;
    }*/
}
