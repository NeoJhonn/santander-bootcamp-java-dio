package br.com.jhonny_azevedo.bootcamp_java_dio.domain.sevice;
import br.com.jhonny_azevedo.bootcamp_java_dio.domain.models.User;

import java.util.UUID;

public interface IUserService {

    User findById(UUID id);

    User create(User user);
}
