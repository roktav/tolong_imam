package com.propensi.winscore.service;

import com.propensi.winscore.model.GaransiModel;

public interface GaransiService {
    GaransiModel addNewGaransi(GaransiModel garansi);
    GaransiModel getGaransiById(Long id_garansi);
}
