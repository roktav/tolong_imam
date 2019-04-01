package com.propensi.winscore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.propensi.winscore.model.TeknisiModel;


@Repository
public interface TeknisiDb extends JpaRepository<TeknisiModel, Long> {

	//TeknisiModel getTeknisiById(long id);

}
