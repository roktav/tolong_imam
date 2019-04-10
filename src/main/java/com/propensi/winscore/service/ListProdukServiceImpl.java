package com.propensi.winscore.service;

import com.propensi.winscore.model.ListProdukKey;
import com.propensi.winscore.model.ListProdukModel;
import com.propensi.winscore.model.OrderModel;
import com.propensi.winscore.repository.ListProdukDb;
import com.propensi.winscore.repository.OrderDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ListProdukServiceImpl implements ListProdukService {
    @Autowired
    private ListProdukDb listProdukDb;

    @Override
    public ListProdukModel newListProduk(ListProdukModel listProduk) {
        return listProdukDb.save(listProduk);
    }

    @Override
    public List<ListProdukModel> getListProdukModel(OrderModel order) {
        return listProdukDb.findAllByListProdukKey_Order(order);
    }
}
