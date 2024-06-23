package br.com.jhonny_azevedo.bootcamp_java_dio.sevice.impl;

import br.com.jhonny_azevedo.bootcamp_java_dio.domain.models.User;
import br.com.jhonny_azevedo.bootcamp_java_dio.domain.repository.UserRepository;
import br.com.jhonny_azevedo.bootcamp_java_dio.sevice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new IllegalArgumentException("Já existe um usuário com esse número de conta.");
        }

        if (userRepository.existsByCardNumber(user.getCard().getNumber())) {
            throw new IllegalArgumentException("Já existe um usuário com esse número de cartão.");
        }

        return userRepository.save(user);
    }

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado."));
    }

    @Override
    public User update(User user) {
        // verificar se o usuário existe
        userRepository.findById(user.getId()).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado."));

        return userRepository.save(user);
    }

    @Override
    public void delete(UUID id) {
        User userToDelete = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Usuário não encontrado."));

        userRepository.delete(userToDelete);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
