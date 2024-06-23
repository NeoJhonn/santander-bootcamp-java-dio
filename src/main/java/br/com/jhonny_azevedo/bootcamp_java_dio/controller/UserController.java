package br.com.jhonny_azevedo.bootcamp_java_dio.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.NoSuchElementException;

import br.com.jhonny_azevedo.bootcamp_java_dio.controller.dtos.UserDTO;
import br.com.jhonny_azevedo.bootcamp_java_dio.domain.models.User;
import br.com.jhonny_azevedo.bootcamp_java_dio.sevice.impl.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static java.util.Optional.ofNullable;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody UserDTO userDTO) {
        User userToCreate = mapper.map(userDTO, User.class);

        // Verificar se o objeto não esta nulo
        ofNullable(userToCreate).orElseThrow(() -> new NullPointerException("Usuário não pode ser nulo."));
        ofNullable(userToCreate.getAccount()).orElseThrow(() -> new NullPointerException("Conta do usuário não pode ser nula."));
        ofNullable(userToCreate.getCard()).orElseThrow(() -> new NullPointerException("Dados do cartão do usuário não pode ser nulo."));

        User userCreated = userService.create(userToCreate);

        // você pode incluir junto o local de criação no ResponseEntity
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(userCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(userCreated);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable UUID id) {

        try {
            return ResponseEntity.ok(userService.findById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/list-users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOList = userService.findAll().stream().map(user -> mapper.map(user, UserDTO.class)).toList();

        return ResponseEntity.ok(userDTOList);
    }

    @PutMapping("/update-user")
    public ResponseEntity<Object> updateUser(@RequestBody UserDTO userDTO) {
        User userToUpdate = mapper.map(userDTO, User.class);

        try {
            return ResponseEntity.ok(userService.update(userToUpdate));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable UUID id) {
        try {
            userService.delete(id);
            return ResponseEntity.ok(id);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
