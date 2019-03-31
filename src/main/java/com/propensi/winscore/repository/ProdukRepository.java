package com.propensi.winscore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.propensi.winscore.model.ProdukModel;

@Repository
public interface ProdukRepository extends JpaRepository<ProdukModel, Long> {

}
