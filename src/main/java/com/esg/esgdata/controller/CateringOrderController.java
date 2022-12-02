package com.esg.esgdata.controller;

import com.esg.esgdata.model.catering.CateringDao;
import com.esg.esgdata.model.catering.CateringOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CateringOrderController {

        @Autowired
        private CateringDao cateringDao;

        @GetMapping("/catering-order/get-all")
        public List<CateringOrder> getAllCateringOrders() {
            return cateringDao.getAllCateringOrders();
        }

        @PostMapping("/catering-order/save")
        public CateringOrder saveCateringOrder(@RequestBody CateringOrder cateringOrder) {
            return cateringDao.save(cateringOrder);
        }
    }

