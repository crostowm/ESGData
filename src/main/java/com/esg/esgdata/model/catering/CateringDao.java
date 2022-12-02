package com.esg.esgdata.model.catering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

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

    public void deleteItem(int id)
    {
        cateringOrderRepository.deleteById(id);
    }
}
