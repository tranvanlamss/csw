package com.example.tranvanlamcsw.service;

import com.example.tranvanlamcsw.dto.ProductDto;
import com.example.tranvanlamcsw.entity.ProductEntity;
import com.example.tranvanlamcsw.mapper.ProductMapper;
import com.example.tranvanlamcsw.repository.ProductRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;
    @Override
    public List<ProductDto> getAllProducts(Pageable pageable) {
        List<ProductEntity> list = productRepository.findAll(pageable).getContent();
        List<ProductDto> listProduct = productMapper.convertListDTO(list);
        return listProduct;
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        ProductEntity productEntityConvert = productMapper.convertToEntity(productDto);
        ProductEntity productEntity = productRepository.save(productEntityConvert);
        ProductDto dto = productMapper.convertToDto(productEntity);
        return dto;
    }

    @Override
    public ProductDto sellProduct(int id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        ProductDto productDto = productMapper.convertToDto(productEntity);
        return productDto;
    }
}
