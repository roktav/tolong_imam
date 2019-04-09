package com.propensi.winscore.controller;

import java.util.List;

import com.propensi.winscore.model.ProvinsiModel;
import com.propensi.winscore.service.ProvinsiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/provinsi")
public class ProvinsiController {
        
    @Autowired
    private ProvinsiService provinsiService;

    @GetMapping(value = "/list")
    private Object viewAllProvinsi(){
        BaseResponse<List<ProvinsiModel>> response = new BaseResponse<List<ProvinsiModel>>();
        List<ProvinsiModel> listProvinsi = provinsiService.getAllProvinsi();
        response.setStatus(200);
        response.setMessage("success");
        response.setResult(listProvinsi);
        System.out.println("Masuk ke provinsi");
        return response;
    }

    @PostMapping(value = "/post")
    public void insert(@RequestBody ProvinsiModel provinsi){
        ProvinsiModel provinsi2 = new ProvinsiModel();
        provinsi2.setNama(provinsi.getNama());
        System.out.println("PPPPPPPPPPPRRRRROOOVINSI");
        System.out.println(provinsi.getNama());
        provinsiService.insert(provinsi2);
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
