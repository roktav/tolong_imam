package com.propensi.winscore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	//ubah
	@GetMapping(value="/ubah/{id_teknisi}")
	private Object updateTeknisi(@PathVariable(value="id_teknisi") long id_teknisi, TeknisiModel teknisi) {
		BaseResponse<TeknisiModel> response = new BaseResponse<TeknisiModel>();
		TeknisiModel daftarteknisi = teknisiService.getTeknisiById(id_teknisi);
		response.setStatus(200);
		response.setMessage("success");
		response.setResult(daftarteknisi);
		return response;
	}
	
	//ubah
	@PostMapping(value="/ubah/{id_teknisi}")
	private Object updateTeknisiSubmit(@PathVariable(value="id_teknisi") long id_teknisi, TeknisiModel teknisi) {
		BaseResponse<TeknisiModel> response = new BaseResponse<TeknisiModel>();
		teknisi.setId_teknisi(id_teknisi);
		teknisiService.updateTeknisi(teknisi);
		response.setStatus(200);
		response.setMessage("success");
		response.setResult(teknisi);
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
