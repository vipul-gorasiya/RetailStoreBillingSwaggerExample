package com.vipul.retailstore.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vipul.retailstore.server.entity.BillItem;

@Repository
public interface BillItemRepository extends JpaRepository<BillItem, Long> {

}
