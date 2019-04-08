package com.propensi.winscore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.propensi.winscore.model.TeknisiModel;
import com.propensi.winscore.model.JadwalTeknisiModel;
import com.propensi.winscore.service.JadwalService;
import com.propensi.winscore.service.TeknisiService;

@RestController
@CrossOrigin
@RequestMapping(value="/api")
public class JadwalController {
	@Autowired 
	private TeknisiService teknisiService;
	
	@Autowired
	private JadwalService jadwalService;
	
	
	

}


class BaseResponseJadwal<T>{
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
