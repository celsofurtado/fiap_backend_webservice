package br.com.fiap.imc.controller;

import br.com.fiap.imc.model.User;
import br.com.fiap.imc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {

        User user = userService.getById(id);

        if (user != null) {
            return ResponseEntity.ok(user);
        }

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/users/email/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable String email) {

        User user = userService.getByEmail(email);

        if (user != null) {
            System.out.print(user.toString());
            return ResponseEntity.ok(user);
        }

        return ResponseEntity.notFound().build();

    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){

        User newUser = userService.save(user);

        return newUser;

    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Long userId) {

        User actualUser = userService.update(user, userId);

        if (actualUser != null) {
            return ResponseEntity.ok(actualUser);
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long userId){

        userService.delete(userId);

    }

}
