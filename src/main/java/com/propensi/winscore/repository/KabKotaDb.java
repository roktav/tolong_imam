package com.propensi.winscore.repository;

import com.propensi.winscore.model.KabKotaModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KabKotaDb extends JpaRepository<KabKotaModel, Long> {
    
}