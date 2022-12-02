package com.esg.esgdata.controller;

import com.esg.esgdata.model.cash.CashItem;
import com.esg.esgdata.model.cash.CashItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class CashItemController {

    @Autowired
    private CashItemDao cashItemDao;

    @GetMapping("/cash-item/get-all")
    public List<CashItem> getAllCashItems() {
        return cashItemDao.getAllCashItems();
    }

    @GetMapping("/cash-item/get-all-for-date/{date}")
    public List<CashItem> getAllCashItemsForDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return cashItemDao.getAllCashItemsForDate(date);
    }

    @PostMapping("/cash-item/save")
    public CashItem saveCashItem(@RequestBody CashItem cashItem) {
        return cashItemDao.save(cashItem);
    }
}
