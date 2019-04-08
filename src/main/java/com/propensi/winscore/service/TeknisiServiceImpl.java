package com.propensi.winscore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.propensi.winscore.model.TeknisiModel;
import com.propensi.winscore.repository.TeknisiDb;

@Service
@Transactional
public class TeknisiServiceImpl implements TeknisiService{
	@Autowired
	private TeknisiDb teknisiDb;

	@Override
	public List<TeknisiModel> getAllTeknisi() {
		// TODO Auto-generated method stub
		return teknisiDb.findAll();
	}

	@Override
	public TeknisiModel getTeknisiById(long id_teknisi) {
		// TODO Auto-generated method stub
		return teknisiDb.getOne(id_teknisi);
	}
	
	@Override
	public TeknisiModel updateTeknisi(TeknisiModel newTeknisi) {
		// TODO Auto-generated method stub
		TeknisiModel updateTeknisi = teknisiDb.getOne(newTeknisi.getId_teknisi());
		System.out.println(newTeknisi.getId_teknisi() + "8888");
		//updateTeknisi.setNo_telp(teknisi.getNo_telp());
		//updateTeknisi.setAlamat(teknisi.getAlamat());
		
		//gimana caranya ambil getShift dari id yang udah didapet
		
		System.out.println(updateTeknisi.getAlamat() + "5++");
		updateTeknisi.setShift(newTeknisi.getShift());
		updateTeknisi.setAlamat(newTeknisi.getAlamat());
		updateTeknisi.setNo_telp(newTeknisi.getNo_telp());
		System.out.println(updateTeknisi.getAlamat() + "6+++");
		return teknisiDb.save(updateTeknisi);
	}
	
}
