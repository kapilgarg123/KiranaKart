package com.kirana.kirana_backend.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CategoryDTO {
    @NotBlank(message = "Name of the category cannot be empty")
    private String categoryName;

}
