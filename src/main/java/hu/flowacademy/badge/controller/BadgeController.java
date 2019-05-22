package hu.flowacademy.badge.controller;

import hu.flowacademy.badge.domain.Badge;
import hu.flowacademy.badge.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/badge")
public class BadgeController {

@Autowired
    private BadgeService badgeService;

    @PostMapping("/save")
    public ResponseEntity<Badge> save(@RequestBody Badge badge) {
        return ResponseEntity.ok(badgeService.save(badge));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Badge>> getAll() {
        return ResponseEntity.ok(badgeService.getAllUser());
    }

    @GetMapping("/getby/{id}")
    public ResponseEntity<Badge> getByid(@PathVariable Long id) {
        return ResponseEntity.ok(badgeService.getById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Badge> updateUser(@RequestBody Badge badge) {
        return ResponseEntity.ok(badgeService.update(badge));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        badgeService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/pair/{badgeid}/{username}")
    public ResponseEntity<Badge> pair(@PathVariable Long badgeid,@PathVariable String username ) {
        return ResponseEntity.ok(badgeService.pair(badgeid,username));
    }


}
