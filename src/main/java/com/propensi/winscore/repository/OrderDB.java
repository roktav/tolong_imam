package com.propensi.winscore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.propensi.winscore.model.OrderModel;

@Repository
public interface OrderDB extends JpaRepository<OrderModel, Long> {
}

