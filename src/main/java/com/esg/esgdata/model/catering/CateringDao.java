package com.esg.esgdata.model.catering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CateringDao {

    @Autowired
    CateringOrderRepository cateringOrderRepository;

    @Autowired
    CateringItemRepository cateringItemRepository;

    public CateringOrder save(CateringOrder cateringOrder) { return cateringOrderRepository.save(cateringOrder);}
    public CateringItem save(CateringItem cateringItem) { return cateringItemRepository.save(cateringItem);}

    public List<CateringOrder> getAllCateringOrders()
    {
        List<CateringOrder> orders = new ArrayList<>();
        Streamable.of(cateringOrderRepository.findAll())
                .forEach(order -> {
                    orders.add(order);
                });
        return orders;
    }

    public List<CateringItem> getAllCateringItems()
    {
        List<CateringItem> items = new ArrayList<>();
        Streamable.of(cateringItemRepository.findAll())
                .forEach(item -> {
                    items.add(item);
                });
        return items;
    }

    public List<CateringOrder> getAllCateringOrdersForDate(LocalDate date)
    {
        List<CateringOrder> orders = new ArrayList<>();
        Streamable.of(cateringOrderRepository.findAll())
                .forEach(order -> {
                    if(order.getDate().equals(date))
                        orders.add(order);
                });
        return orders;
    }

    public void deleteItem(int id)
    {
        cateringItemRepository.deleteById(id);
    }
    public void deleteOrder(int id)
    {
        cateringOrderRepository.deleteById(id);
    }
}
