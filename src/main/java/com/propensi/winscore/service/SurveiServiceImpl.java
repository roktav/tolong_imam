package com.propensi.winscore.service;

import com.propensi.winscore.model.OrderModel;
import com.propensi.winscore.model.SurveiModel;
import com.propensi.winscore.repository.SurveiDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class SurveiServiceImpl implements SurveiService {
    @Autowired
    SurveiDb surveiDb;

    @Override
    public SurveiModel addSurvei(SurveiModel survei) {
        return surveiDb.save(survei);
    }

    @Override
    public Optional<SurveiModel> getSurveiByIdOrder(long id_order) {
        return surveiDb.findById(id_order);
    }
}
