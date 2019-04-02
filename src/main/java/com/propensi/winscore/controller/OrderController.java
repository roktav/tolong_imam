package com.propensi.winscore.controller;

import com.propensi.winscore.model.OrderModel;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
import com.propensi.winscore.service.OrderService;

@RestController
public class OrderController {

    @Autowired
    OrderService OrderService;

//    public OrderModel viewOrder(){
//
//    }

    public String tambahOrder(Model model){
        System.out.println("passed");
        return "tambahOrder";
    }
}
