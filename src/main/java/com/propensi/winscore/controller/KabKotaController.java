package com.propensi.winscore.controller;

import java.util.List;

import com.propensi.winscore.model.KabKotaModel;
import com.propensi.winscore.service.KabKotaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin    
@RequestMapping("/api/KabKota")
public class KabKotaController {

    @Autowired
    private KabKotaService kabKotaService;

    @GetMapping(value="/list")
    private Object viewAllKabKota(){
        BaseResponse<List<KabKotaModel>> response = new BaseResponse<List<KabKotaModel>>();
        List<KabKotaModel> listKabKota = kabKotaService.getAllKabKota();
        response.setStatus(200);
        response.setMessage("success");
        response.setResult(listKabKota);
        System.out.println(response.getResult());
        System.out.println("Masuk ke kabupaten kota");
        return response;
    }

    @PostMapping(value="/post")
    public void insert(@RequestBody KabKotaModel kabKota){
        kabKotaService.insert(kabKota);
    }

    @GetMapping(value="/provinsi/{nama_provinsi}")
    private Object viewAllKabKota(@PathVariable("nama_provinsi") String nama){
        BaseResponse<List<KabKotaModel>> response = new BaseResponse<List<KabKotaModel>>();
        List<KabKotaModel> listKabKota = kabKotaService.getKabKotaByProvinsi(nama);
        response.setStatus(200);
        response.setMessage("success");
        response.setResult(listKabKota);
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