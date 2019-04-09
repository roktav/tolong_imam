package com.propensi.winscore.controller;

import com.propensi.winscore.model.OrderModel;
import com.propensi.winscore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderModel> viewAllOrder(){
        List<OrderModel> achieve = orderService.findAll();
        return achieve;
    }
}
