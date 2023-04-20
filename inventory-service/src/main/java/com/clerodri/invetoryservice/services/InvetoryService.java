package com.clerodri.invetoryservice.services;

import com.clerodri.invetoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InvetoryService {

    private final InventoryRepository inventoryRepository;
    @Transactional(readOnly = true)
    public  boolean isInStock(String skuCode){
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }
}
