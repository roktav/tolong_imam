package com.propensi.winscore.repository;

import com.propensi.winscore.model.ProdukModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdukDb extends JpaRepository <ProdukModel, Long> {

}