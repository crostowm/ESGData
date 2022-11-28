package com.esg.esgdata.model.prep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrepDao {

    @Autowired
    PrepItemRepository itemRepository;

    @Autowired
    PrepTemplateRepository templateRepository;

    public PrepItem save(PrepItem prepItem) { return itemRepository.save(prepItem);}
    public PrepTemplate save(PrepTemplate prepTemplate) { return templateRepository.save(prepTemplate);}

    public List<PrepItem> getAllPrepItems()
    {
        List<PrepItem> preps = new ArrayList<>();
        Streamable.of(itemRepository.findAll())
                .forEach(prep -> {
                    preps.add(prep);
                });
        return preps;
    }

    public List<PrepTemplate> getAllPrepTemplates()
    {
        List<PrepTemplate> preps = new ArrayList<>();
        Streamable.of(templateRepository.findAll())
                .forEach(prep -> {
                    preps.add(prep);
                });
        return preps;
    }

    public void delete(String name)
    {
        itemRepository.deleteById(name);
    }
}
