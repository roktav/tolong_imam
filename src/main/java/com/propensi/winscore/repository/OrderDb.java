package com.propensi.winscore.repository;

import com.propensi.winscore.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDb extends JpaRepository<OrderModel, Long> {
    
}
