package com.propensi.winscore.repository;



import com.propensi.winscore.model.KecamatanModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KecamatanDb extends JpaRepository<KecamatanModel, Long> {
    
}