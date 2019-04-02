package com.propensi.winscore.service;

import com.propensi.winscore.model.OrderModel;
import com.propensi.winscore.repository.OrderDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDB orderDb;

    @Override
    public void addOrder(OrderModel order) {
        orderDb.save(order);

    }
    
}