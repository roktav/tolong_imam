package com.propensi.winscore.controller;

import com.propensi.winscore.model.ProdukModel;
import com.propensi.winscore.service.ProdukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
//@PreAuthorize("isAuthenticated()")
public class ProdukController {

    @Autowired
    @Qualifier("ProdukServiceImpl")
    private ProdukService produkService;

    public void setProdukService(ProdukService produkService) {
        this.produkService = produkService;
    }

    @GetMapping(value="/list-produk")
     public BaseResponses<List<ProdukModel>> retrieveAllProduk() {
        BaseResponses<List<ProdukModel>> response = new BaseResponses<List<ProdukModel>>();
        List<ProdukModel> listProduk = produkService.findAll();
        System.out.println(listProduk);
        response.setStatus(200);
        response.setMessage("success");
        response.setResult(listProduk);
        return response;
    }

    @GetMapping(value="/list-produk/detail-produk/{id_produk}")
    public BaseResponses<ProdukModel> retrieveDetailProduk(@PathVariable(value="id_produk") long id_produk) {
        BaseResponses<ProdukModel> response = new BaseResponses<ProdukModel>();
        ProdukModel detailProduk = produkService.getProdukById(id_produk);
        response.setStatus(200);
        response.setMessage("success");
        response.setResult(detailProduk);
        return response;
    }
    @GetMapping(value="/ubah-detail-produk")
    private Object updateProduk(@PathVariable(value="id_produk") long id_produk, ProdukModel produk) {
        BaseResponses<ProdukModel> response = new BaseResponses<ProdukModel>();
        ProdukModel listProduk = produkService.getProdukById(id_produk);
        response.setStatus(200);
        response.setMessage("success");
        response.setResult(listProduk);
        return response;
    }


    /*@PostMapping("/add")
    public String addProduk(@ModelAttribute ProdukModel produk, RedirectAttributes redirectAttributes) {
        return "pages/AddProduk.html";
    }*/


}

class BaseResponses<T> {
    private int status;
    private String message;
    private T result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
