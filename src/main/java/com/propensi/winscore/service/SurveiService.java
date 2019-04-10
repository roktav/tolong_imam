package com.propensi.winscore.service;

import com.propensi.winscore.model.OrderModel;
import com.propensi.winscore.model.SurveiModel;

import java.util.Optional;

public interface SurveiService {
    SurveiModel addSurvei(SurveiModel survei);
    Optional<SurveiModel> getSurveiByIdOrder(long id_order);
}
