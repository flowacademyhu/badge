package hu.flowacademy.badge.service;

import hu.flowacademy.badge.domain.Badge;
import hu.flowacademy.badge.domain.User;
import hu.flowacademy.badge.exception.ValidationException;
import hu.flowacademy.badge.repository.BadgeRepository;
import hu.flowacademy.badge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BadgeService {

    @Autowired
    private BadgeRepository badgeRepository;

    @Autowired
    private UserRepository userRepository;

    public Badge save(Badge badge) {
        if (!badgeRepository.getByname(badge.getName()).isEmpty()) {
            throw new ValidationException("this badge name alredy exists");
        }
        return badgeRepository.save(badge);
    }
    public Badge update(Badge badge) {
        if (badgeRepository.getByname(badge.getName()).isEmpty()) {
            return save(badge);
        }
        return badgeRepository.save(badge);
    }

    public List<Badge> getAllUser() {
        return badgeRepository.findAll();
    }

    public Badge getById(Long id) {
        return badgeRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        if (badgeRepository.findById(id).isEmpty()) {
            throw new NoSuchElementException("Badge not found");
        }
        badgeRepository.deleteById(id);
    }
    public Badge pair(Long badgeid,String username) {
        User user= userRepository.findById(username).orElse(null);
        Badge badge = badgeRepository.findById(badgeid).orElse(null);
        if (user == null || badge == null) {
            throw new ValidationException("user id or/and badge id is invalid");
        }
        if (user.isUserContainsUser(badge) && badge.isBadgeContainsUser(user)) {
            throw new ValidationException("this pair is alredy exist");
        }
        user.addBadgeToUser(badge);
        badge.setUserToBadge(user);
        badgeRepository.save(badge);
        userRepository.save(user);
        return badge;
    }


}
