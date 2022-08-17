package com.example.tranvanlamcsw.service;

import com.example.tranvanlamcsw.dto.ProductDto;
import com.example.tranvanlamcsw.entity.ProductEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts(Pageable pageable);
    ProductDto addProduct(ProductDto productDto);
    ProductDto sellProduct(int id);
}
