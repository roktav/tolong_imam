package com.propensi.winscore.controller;

import com.propensi.winscore.model.OrderModel;
import com.propensi.winscore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderModel> viewAllOrder() {
        List<OrderModel> achieve = orderService.findAll();
        return achieve;
    }

    @PostMapping(value = "/post")
    public void insert(@RequestBody Map<String, Object> getOrder) throws ParseException {
        BaseResponse<OrderModel> response = new BaseResponse<OrderModel>();
        OrderModel order = new OrderModel();
        order.setJenis_bangunan((String) getOrder.get("jenis_bangunan"));
        order.setKategori_produk((String) getOrder.get("kategori_produk"));
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
        java.util.Date date = sdf1.parse((String) getOrder.get("tgl_order"));
        Date tgl_order = new Date(date.getTime());
        order.setTgl_order(tgl_order);
        System.out.println("BERHASIL MASUK POST PADDDDDD");
        orderService.insert(order);
    }

}
