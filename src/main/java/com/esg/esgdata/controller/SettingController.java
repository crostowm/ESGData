package com.esg.esgdata.controller;

import com.esg.esgdata.model.setting.Setting;
import com.esg.esgdata.model.setting.SettingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SettingController {

    @Autowired
    private SettingDao settingDao;

    @GetMapping("/setting/get-all")
    public List<Setting> getAllSettings() {
        return settingDao.getAllSettings();
    }

    @PostMapping("/setting/save")
    public Setting saveSetting(@RequestBody Setting setting) {
        return settingDao.save(setting);
    }
}
