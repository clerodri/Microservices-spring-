package com.clerodri.invetoryservice.repository;

import com.clerodri.invetoryservice.model.Invetory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository  extends JpaRepository<Invetory, Long> {

    Optional<Invetory> findBySkuCode(String skuCode);
}
