package br.com.jhonny_azevedo.bootcamp_java_dio.domain.repository;

import br.com.jhonny_azevedo.bootcamp_java_dio.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByAccountNumber(String accountNumber);

    boolean existsByCardNumber(String cardNumber);
}
