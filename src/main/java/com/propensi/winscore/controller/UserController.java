package com.propensi.winscore.controller;

import java.util.List;

import com.propensi.winscore.model.UserModel;
import com.propensi.winscore.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/user")
public class UserController{

    @Autowired
    private UserService userService;

    @GetMapping(value="/list")
    private Object viewAllUser(){
        BaseResponse<List<UserModel>> response = new BaseResponse<List<UserModel>>();
        List<UserModel> listUser = userService.getAllUser();
        response.setStatus(200);
        response.setMessage("success");
        response.setResult(listUser);
        System.out.println(response.getResult());
        System.out.println("Masuk list user");
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