package com.kirana.kirana_backend.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProductDTO {

    private Long id;

    @NotBlank(message = "Name of the product cannot be empty")
    @Size(message = "Name of the product should be between 3 and 50 characters", min = 3, max = 50)
    private String name;

    private String description;

    @NotNull(message = "Price cannot be empty")
    @Positive(message = "Price should be positive")
    private Double price;

    private CategoryDTO productCategory;

}
