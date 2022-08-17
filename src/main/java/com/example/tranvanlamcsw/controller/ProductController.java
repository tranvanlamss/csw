package com.example.tranvanlamcsw.controller;

import com.example.tranvanlamcsw.database.BaseResponse;
import com.example.tranvanlamcsw.dto.ProductDto;
import com.example.tranvanlamcsw.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/get-list")
    public ResponseEntity getList(@RequestParam(value = "page", required = false, defaultValue = "0") String page,
                                  @RequestParam(value = "limit", required = false, defaultValue = "5") String limit){
        BaseResponse res = new BaseResponse();
        res.data = productService.getAllProducts(PageRequest.of(Integer.valueOf(page), Integer.valueOf(limit)));
        return ResponseEntity.ok(res);
    }

    @PostMapping("/create")
    public ResponseEntity createProduct(@RequestBody @Valid ProductDto productDto){
        BaseResponse res = new BaseResponse();
        res.data = productService.addProduct(productDto);
        return ResponseEntity.ok(res);
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateProduct(@Valid @PathVariable("id") int id, @RequestBody ProductDto productDto){
        BaseResponse res = new BaseResponse();
        ProductDto productDto1 = productService.sellProduct(id);
        productDto1.setName(productDto.getName());
        productDto1.setPrice(productDto.getPrice());
        productDto1.setQuantity(productDto.getQuantity() -1);
        res.data =  productService.addProduct(productDto1);
        return ResponseEntity.ok(res);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
