package pl.filipzeglen.springsecuritywithdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.filipzeglen.springsecuritywithdb.model.account.User;
import pl.filipzeglen.springsecuritywithdb.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public Iterable<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping
    public Optional<User> getUserById(@RequestParam Long index) {
        return userService.findById(index);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam Long index) {
        userService.deleteById(index);
    }
}
