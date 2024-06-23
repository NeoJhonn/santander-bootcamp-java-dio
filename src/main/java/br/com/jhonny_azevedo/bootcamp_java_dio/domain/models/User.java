package br.com.jhonny_azevedo.bootcamp_java_dio.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_user")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        private String name;

        @OneToOne(cascade = CascadeType.ALL)// composição
        private Account account;

        @OneToOne(cascade = CascadeType.ALL)// composição
        private Card card;

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        private List<Feature> features;

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        private List<News> news;
}
