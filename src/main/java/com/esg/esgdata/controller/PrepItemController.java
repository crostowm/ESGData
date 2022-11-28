package com.esg.esgdata.controller;

import com.esg.esgdata.model.prep.Prep;
import com.esg.esgdata.model.prep.PrepDao;
import com.esg.esgdata.model.prep.PrepItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrepItemController {

    @Autowired
    private PrepDao prepItemDao;

    @GetMapping("/prep-item/get-all")
    public List<PrepItem> getAllPrepItems() {
        return prepItemDao.getAllPrepItems();
    }

    @PostMapping("/prep-item/save")
    public PrepItem savePrepItems(@RequestBody PrepItem prepItem) {
        return prepItemDao.save(prepItem);
    }
}
