package net.chimaek.day0716_restapi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    public List<User> getAllUsers() {
        return null;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return null;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return null;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User updateUser) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {

    }
}
