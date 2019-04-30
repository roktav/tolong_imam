package com.propensi.winscore.controller;

import com.propensi.winscore.model.*;
import com.propensi.winscore.rest.BaseResponse;
import com.propensi.winscore.service.ListProdukService;
import com.propensi.winscore.service.OrderService;
//import com.propensi.winscore.service.PembeliService;
import com.propensi.winscore.service.SurveiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @Autowired
    private ListProdukService listProdukService;

    @Autowired
    private SurveiService surveiService;

/*    @Autowired
    private PembeliService pembeliService;*/


    @GetMapping
    public BaseResponse<List<OrderModel>> viewAllOrder(){
        BaseResponse<List<OrderModel>> response = new BaseResponse<List<OrderModel>>();
        List<OrderModel> achieve = orderService.findAll();
        if (achieve.isEmpty()) {
            response.setStatus(404);
            response.setMessage("Not Found");
        } else {
            response.setStatus(200);
            response.setMessage("Success");
            response.setResult(achieve);
        }
        return response;
    }

    @GetMapping(value = "/detail/{id_order}")
    public BaseResponse<OrderModel> viewOrder(@PathVariable long id_order) throws IOException {
        BaseResponse<OrderModel> response = new BaseResponse<OrderModel>();
        OrderModel achieve = orderService.getOrderById(id_order).get();
        if (achieve == null) {
            response.setStatus(404);
            response.setMessage("Not Found");
        } else {
            response.setResult(achieve);
            response.setMessage("Success");
            response.setStatus(200);
        }
        return response;
    }

    @GetMapping(value = "/detailList/{id_order}")
    public BaseResponse<List<ListProdukModel>> viewListProduk(@PathVariable long id_order) throws IOException {
        BaseResponse<List<ListProdukModel>> response = new BaseResponse<List<ListProdukModel>>();
        OrderModel order = orderService.getOrderById(id_order).get();
        List<ListProdukModel> achieve = listProdukService.getListProdukModel(order);
        if (achieve != null) {
            response.setResult(achieve);
            response.setMessage("Success");
            response.setStatus(200);
        } else {
            response.setStatus(404);
            response.setMessage("Not Found");
        }
        return response;
    }

    @PostMapping(value = "/detail/update/{id_order}")
    public BaseResponse<OrderModel> updateOrder(@PathVariable long id_order){
        BaseResponse<OrderModel> response = new BaseResponse<OrderModel>();
        OrderModel achieve = orderService.getOrderById(id_order).get();
        if (achieve != null){
            achieve.setStatus_order("Menunggu Konfirmasi Manajer Teknisi");
            orderService.addOrder(achieve);
        }
        response.setStatus(200);
        response.setMessage("Success");
        return response;
    }

    @PostMapping(value = "/detail/tambah-survei/{id_order}")
    public BaseResponse<SurveiModel> tambahSurvei(@PathVariable long id_order,@RequestBody Map<String, Object> survei) throws ParseException {
        BaseResponse<SurveiModel> response = new BaseResponse<SurveiModel>();
        OrderModel getOrder =orderService.getOrderById(id_order).get();
        SurveiModel newSurvei = new SurveiModel();
        newSurvei.setId_order(getOrder);
        newSurvei.setAlamat_survei((String) survei.get("alamat_survei"));

        System.out.println((String) survei.get("tanggal_survei"));
        String tanggal = (String) survei.get("tanggal_survei");

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = sdf1.parse(tanggal);
        Date sqlDate = new Date(date.getTime());

        DateFormat formatter = new SimpleDateFormat("HH:mm");
        java.sql.Time timeValue = new java.sql.Time(formatter.parse((String) survei.get("waktu_survei")).getTime());


        newSurvei.setTanggal_survei(sqlDate);
        newSurvei.setWaktu_survei(timeValue);
        newSurvei.setKeterangan((String) survei.get("keterangan"));
        newSurvei.setId_teknisi(null);
        surveiService.addSurvei(newSurvei);
        response.setMessage("success");
        response.setStatus(200);
        response.setResult(newSurvei);
        return response;
    }

    @GetMapping(value = "/detail/lihat-survei/{id_order}")
    public BaseResponse<SurveiModel> viewSurvei(@PathVariable long id_order){
        BaseResponse<SurveiModel> response = new BaseResponse<SurveiModel>();
        Optional<SurveiModel> survei = surveiService.getSurveiByIdOrder(id_order);
        if(survei.isPresent()){
            SurveiModel surveiM = survei.get();
            System.out.println(surveiM.getTanggal_survei());
            response.setMessage("success");
            response.setStatus(200);
            response.setResult(surveiM);
        } else{
            response.setStatus(404);
            response.setMessage("Not Found");
        }
        return response;
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
        order.setStatus_order("Ordered");
        System.out.println("BERHASIL MASUK POST PADDDDDD");
        orderService.insert(order);
    }

}
