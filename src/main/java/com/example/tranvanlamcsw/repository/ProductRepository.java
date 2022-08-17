package com.example.tranvanlamcsw.repository;

import com.example.tranvanlamcsw.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}
