package com.propensi.winscore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.propensi.winscore.service.TeknisiService;
import com.propensi.winscore.model.TeknisiModel;

@RestController
@CrossOrigin
@RequestMapping(value="/api")
public class TeknisiController {
	@Autowired
	private TeknisiService teknisiService;
	
	//@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(value="/teknisi")
	private Object viewallTeknisi() {
		BaseResponse<List<TeknisiModel>> response = new BaseResponse<List<TeknisiModel>>();
		List<TeknisiModel> daftarteknisi = teknisiService.getAllTeknisi();
		response.setStatus(200);
		response.setMessage("success");
		response.setResult(daftarteknisi);
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
