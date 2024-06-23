package br.com.jhonny_azevedo.bootcamp_java_dio.domain.controller;

import java.net.URI;
import java.util.UUID;
import java.util.NoSuchElementException;

import br.com.jhonny_azevedo.bootcamp_java_dio.domain.models.User;
import br.com.jhonny_azevedo.bootcamp_java_dio.domain.sevice.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody User user) {


            User userCreated = userService.create(user);

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
}
