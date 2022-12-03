package com.esg.esgdata.controller;

import com.esg.esgdata.model.prep.Prep;
import com.esg.esgdata.model.prep.PrepDao;
import com.esg.esgdata.model.prep.PrepItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class PrepItemController {

    @Autowired
    private PrepDao prepItemDao;

    @GetMapping("/prep-item/get-all")
    public List<PrepItem> getAllPrepItems() {
        return prepItemDao.getAllPrepItems();
    }

    @GetMapping("/prep-item/get-all-for-date/{date}")
    public List<PrepItem> getAllPrepItemsForDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return prepItemDao.getAllPrepItemsForDate(date);
    }

    @PostMapping("/prep-item/save")
    public PrepItem savePrepItems(@RequestBody PrepItem prepItem) {
        System.out.println("Saving prep: " + prepItem.toString());
        return prepItemDao.save(prepItem);
    }
}
