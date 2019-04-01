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
	
}
