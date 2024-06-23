package br.com.jhonny_azevedo.bootcamp_java_dio.controller.dtos;

import br.com.jhonny_azevedo.bootcamp_java_dio.domain.models.Account;
import br.com.jhonny_azevedo.bootcamp_java_dio.domain.models.Card;
import br.com.jhonny_azevedo.bootcamp_java_dio.domain.models.Feature;
import br.com.jhonny_azevedo.bootcamp_java_dio.domain.models.News;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private UUID id;

    private String name;

    private Account account;

    private Card card;

    private List<Feature> features;

    private List<News> news;
}

