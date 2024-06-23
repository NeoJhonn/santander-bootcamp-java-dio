package br.com.jhonny_azevedo.bootcamp_java_dio.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true)
    private String number;

    @Column(name = "card_limit", scale = 13, precision = 2)// 11 inteiros e 2 decimais de precisão
    private BigDecimal limit;
}
