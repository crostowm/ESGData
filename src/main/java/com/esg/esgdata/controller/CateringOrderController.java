package com.esg.esgdata.controller;

import com.esg.esgdata.model.catering.CateringDao;
import com.esg.esgdata.model.catering.CateringItem;
import com.esg.esgdata.model.catering.CateringOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class CateringOrderController {

    @Autowired
    private CateringDao cateringDao;

    @GetMapping("/catering/get-all")
    public List<CateringOrder> getAllCateringOrders() {
        return cateringDao.getAllCateringOrders();
    }

    @GetMapping("/catering/get-all-for-date/{date}")
    public List<CateringOrder> getAllCateringOrdersForDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return cateringDao.getAllCateringOrdersForDate(date);
    }

    @PostMapping("/catering/save")
    public CateringOrder saveCateringOrder(@RequestBody CateringOrder cateringOrder) {
        return cateringDao.save(cateringOrder);
    }

    @PostMapping("/catering-item/delete")
    public void deleteCateringItem(@RequestBody CateringItem cateringItem) {
        cateringDao.deleteItem(cateringItem.getId());
    }

    @PostMapping("/catering-order/delete")
    public void deleteCateringOrder(@RequestBody CateringOrder cateringOrder) {
        cateringDao.deleteOrder(cateringOrder.getId());
    }
}

