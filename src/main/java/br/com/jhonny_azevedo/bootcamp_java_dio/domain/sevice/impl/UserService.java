package br.com.jhonny_azevedo.bootcamp_java_dio.domain.sevice.impl;

import br.com.jhonny_azevedo.bootcamp_java_dio.domain.models.User;
import br.com.jhonny_azevedo.bootcamp_java_dio.domain.repositories.UserRepository;
import br.com.jhonny_azevedo.bootcamp_java_dio.domain.sevice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado."));
    }

    @Override
    public User create(User user) {
        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new IllegalArgumentException("Já existe um usuário com esse número de conta.");
        }
        return userRepository.save(user);
    }
}
