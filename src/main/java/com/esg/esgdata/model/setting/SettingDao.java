package com.esg.esgdata.model.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SettingDao {

    @Autowired
    private SettingRepository repository;

    public Setting save(Setting setting)
    {
        return repository.save(setting);
    }

    public List<Setting> getAllSettings()
    {
        List<Setting> settings = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(setting -> {
                    settings.add(setting);
                });
        return settings;
    }

    public void delete(String name)
    {
        repository.deleteById(name);
    }
}
