package com.clerodri.productservice.repository;

import com.clerodri.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface ProductRepository  extends MongoRepository<Product, String> {

}
