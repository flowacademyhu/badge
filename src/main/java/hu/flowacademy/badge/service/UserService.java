package hu.flowacademy.badge.service;

import hu.flowacademy.badge.domain.User;
import hu.flowacademy.badge.exception.ValidationException;
import hu.flowacademy.badge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        if (user.getUsername() == null) {
            throw new ValidationException("username is empty");
        } else if (userRepository.findById(user.getUsername()).isEmpty()) {
            return userRepository.save(user);
        } else {
            throw new ValidationException("username alredy exists");
        }
    }

    public User update(User user) {
        if (userRepository.findById(user.getUsername()).isEmpty()) {
           return save(user);
        }
        return userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getByUserName(String username) {
        return userRepository.findById(username).orElse(null);
    }

    public void deleteById(String username) {
        if (userRepository.findById(username).isEmpty()) {
            throw new NoSuchElementException("Not found");
        }
        userRepository.deleteById(username);
    }
}
