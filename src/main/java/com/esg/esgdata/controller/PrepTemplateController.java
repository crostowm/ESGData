package com.esg.esgdata.controller;

import com.esg.esgdata.model.prep.Prep;
import com.esg.esgdata.model.prep.PrepDao;
import com.esg.esgdata.model.prep.PrepTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PrepTemplateController {

    @Autowired
    private PrepDao prepTemplateDao;

    @GetMapping("/prep-template/get-all")
    public List<PrepTemplate> getAllPrepTemplates() {
        return prepTemplateDao.getAllPrepTemplates();
    }

    @PostMapping("/prep-template/save")
    public PrepTemplate savePrepTemplates(@RequestBody PrepTemplate prepTemplate) {
        return prepTemplateDao.save(prepTemplate);
    }
}
