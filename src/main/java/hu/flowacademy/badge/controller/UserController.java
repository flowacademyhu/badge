package hu.flowacademy.badge.controller;

import hu.flowacademy.badge.domain.User;
import hu.flowacademy.badge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }
    @GetMapping("/getall")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAllUser());
    }
    @GetMapping("/getby/{id}")
    public ResponseEntity<User> getByid(@PathVariable String id) {
        return ResponseEntity.ok(userService.getByUserName(id));
    }
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.update(user));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
