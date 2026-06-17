package com.example.homerodoh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CervezaDTO {

    private String nombre;
    private Double precio;
    private String nombreMarca;
}