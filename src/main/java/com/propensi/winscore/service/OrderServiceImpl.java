package com.propensi.winscore.service;

import com.propensi.winscore.model.OrderModel;
import com.propensi.winscore.repository.OrderDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDb orderDb;

    @Override
    public OrderModel addOrder(OrderModel order){
        orderDb.save(order);
        return order;
    }

    @Override
    public Optional<OrderModel> getOrderById(long id) {
        return orderDb.findById(id);
    }

    @Override
    public List<OrderModel> findAll() {
        return orderDb.findAll();
    }
}
