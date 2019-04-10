package com.propensi.winscore.service;

import com.propensi.winscore.model.ListProdukKey;
import com.propensi.winscore.model.ListProdukModel;
import com.propensi.winscore.model.OrderModel;
import org.hibernate.criterion.Order;

import java.util.List;
import java.util.Optional;

public interface ListProdukService {
    ListProdukModel newListProduk(ListProdukModel listProduk);
    List<ListProdukModel> getListProdukModel(OrderModel order);
}
