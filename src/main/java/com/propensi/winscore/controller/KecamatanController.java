package com.propensi.winscore.controller;

import java.util.List;

import com.propensi.winscore.model.KecamatanModel;
import com.propensi.winscore.service.KecamatanService;

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
@RequestMapping("/api/kecamatan")
public class KecamatanController {
    
    @Autowired
    private KecamatanService kecamatanService;

    @GetMapping(value = "/list")
    public List<KecamatanModel> kecamatans(){
        return kecamatanService.getAllKecamatan();
    }

    @PostMapping(value = "/post")
    public void insert(@RequestBody KecamatanModel kecamatan){
        kecamatanService.insert(kecamatan);
    }

    @GetMapping(value = "/kabKota/{nama_kabKota}")
    private Object sortKecamatanByKabKota(@PathVariable("nama_kabKota") String nama){
        BaseResponse<List<KecamatanModel>> response = new BaseResponse<List<KecamatanModel>>();
        List<KecamatanModel> listKecamatan = kecamatanService.getKecamatanByKabKota(nama);
        response.setStatus(200);
        response.setMessage("success");
        response.setResult(listKecamatan);
        System.out.println("MASUK KE KECAMATAN");
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