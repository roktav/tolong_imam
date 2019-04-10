package com.propensi.winscore.repository;

import com.propensi.winscore.model.ListProdukKey;
import com.propensi.winscore.model.ListProdukModel;
import com.propensi.winscore.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ListProdukDb extends JpaRepository<ListProdukModel, Long> {
    List<ListProdukModel> findAllByListProdukKey_Order(OrderModel order);
}
