package com.propensi.winscore.service;

import java.util.List;

import com.propensi.winscore.model.TeknisiModel;

public interface TeknisiService {

	List<TeknisiModel> getAllTeknisi();
	TeknisiModel getTeknisiById(long id_teknisi);
	TeknisiModel updateTeknisi(TeknisiModel teknisi);

}
