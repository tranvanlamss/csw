package com.example.tranvanlamcsw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private int id;
    @NotBlank(message = "Please input name product!")
    private String name;
    @Min(1000)
    @Max(10000)
    private int price;
    @Min(1)
    @Max(20)
    private int quantity;
    private Date created_at;
    private Date updated_at;
}
