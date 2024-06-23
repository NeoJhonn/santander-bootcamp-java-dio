package br.com.jhonny_azevedo.bootcamp_java_dio.sevice;
import br.com.jhonny_azevedo.bootcamp_java_dio.domain.models.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {

    User create(User user);

    User findById(UUID id);

    User update(User user);

    void delete(UUID id);

    List<User> findAll();
}
