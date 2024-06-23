package br.com.jhonny_azevedo.bootcamp_java_dio.controller.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {

    private UUID id;

    private String number;

    private BigDecimal limit;
}
