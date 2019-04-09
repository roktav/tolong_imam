package com.propensi.winscore.controller;

import java.util.List;

import com.propensi.winscore.model.ProdukModel;
import com.propensi.winscore.service.ProdukService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/produk")
//@PreAuthorize("isAuthenticated()")
public class ProdukController {

    @Autowired
    ProdukService produkService;

    @GetMapping(value = "/list")
    private Object viewAllProduk(){
        BaseResponse<List<ProdukModel>> response = new BaseResponse<List<ProdukModel>>();
        List<ProdukModel> listProduk = produkService.getAllProduk();
        response.setStatus(200);
        response.setMessage("success");
        response.setResult(listProduk);
        System.out.println("Masuk ke produk");
        return response;
    }
    
    @CrossOrigin
    @GetMapping(value = "/list/{kategori}")
    private Object viewAllProduk(@PathVariable("kategori") String kategori){
        BaseResponse<List<ProdukModel>> response = new BaseResponse<List<ProdukModel>>();
        List<ProdukModel> listProduk = produkService.getProdukByKategori(kategori);
        response.setStatus(200);
        response.setMessage("success");
        response.setResult(listProduk);
        System.out.println("Masuk ke produk sort");
        return response;
    }
}

class BaseResponse<T>{
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