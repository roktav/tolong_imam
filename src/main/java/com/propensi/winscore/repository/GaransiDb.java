package com.propensi.winscore.repository;

import com.propensi.winscore.model.GaransiModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GaransiDb extends JpaRepository<GaransiModel, Long> {
}
