package com.esg.esgdata.model.cash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CashItemDao {

    @Autowired
    private CashItemRepository repository;

    public CashItem save(CashItem cashItem) {
        return repository.save(cashItem);
    }

    public List<CashItem> getAllCashItems() {
        List<CashItem> cashItems = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(cashItem -> {
                    cashItems.add(cashItem);
                });
        return cashItems;
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<CashItem> getAllCashItemsForDate(LocalDate date) {
        List<CashItem> cashItems = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(cashItem -> {
                    if (cashItem.getDate().equals(date))
                        cashItems.add(cashItem);
                });
        return cashItems;
    }
}
