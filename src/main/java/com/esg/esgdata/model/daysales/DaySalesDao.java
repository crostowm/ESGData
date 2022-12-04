package com.esg.esgdata.model.daysales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DaySalesDao {
    @Autowired
    DaySalesRepository itemRepository;

    public DaySales save(DaySales taskItem) { return itemRepository.save(taskItem);}

    public List<DaySales> getAllDaySales()
    {
        List<DaySales> daySales = new ArrayList<>();
        Streamable.of(itemRepository.findAll())
                .forEach(daySale -> {
                    daySales.add(daySale);
                });
        return daySales;
    }

    public void deleteDaySales(LocalDate date)
    {
        itemRepository.deleteById(date);
    }

    public DaySales getDaySales(LocalDate date) {
        List<DaySales> daySales = new ArrayList<>();
        Streamable.of(itemRepository.findAll())
                .forEach(daySale -> {
                    if(daySale.getDate().equals(date))
                        daySales.add(daySale);
                });
        if(daySales.size() > 0)
            return daySales.get(0);
        return null;
    }
}
