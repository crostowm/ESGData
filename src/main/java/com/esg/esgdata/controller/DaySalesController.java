package com.esg.esgdata.controller;

import com.esg.esgdata.model.daysales.DaySales;
import com.esg.esgdata.model.daysales.DaySalesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class DaySalesController {

    @Autowired
    private DaySalesDao daySalesDao;

    @GetMapping("/day-sales/get-all")
    public List<DaySales> getDaySales() {
        return daySalesDao.getAllDaySales();
    }

    @GetMapping("/day-sales/get/{date}")
    public DaySales getDaySalesForDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return daySalesDao.getDaySales(date);
    }

    @PostMapping("/day-sales/save")
    public DaySales saveDaySales(@RequestBody DaySales daySales) {
        System.out.println("Saving Day Sales: " + daySales.toString());
        return daySalesDao.save(daySales);
    }
}
