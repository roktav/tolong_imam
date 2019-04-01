package com.propensi.winscore.service;

import com.propensi.winscore.model.OrderModel;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    OrderModel addOrder(OrderModel order);
    Optional<OrderModel> getOrderById(long id);
    List<OrderModel> findAll();
}
