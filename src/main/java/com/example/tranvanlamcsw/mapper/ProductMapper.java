package com.example.tranvanlamcsw.mapper;

import com.example.tranvanlamcsw.dto.ProductDto;
import com.example.tranvanlamcsw.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring",nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ProductMapper {
    ProductEntity convertToEntity(ProductDto productDto);
    ProductDto convertToDto(ProductEntity productEntity);
    List<ProductDto> convertListDTO(List<ProductEntity> listEntity);
   List<ProductEntity> convertListEntity(List<ProductDto> listDto);
}
