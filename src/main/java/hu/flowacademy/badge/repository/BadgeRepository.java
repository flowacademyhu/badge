package hu.flowacademy.badge.repository;

import hu.flowacademy.badge.domain.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BadgeRepository extends JpaRepository<Badge,Long> {

    @Query("FROM Badge badge WHERE badge.name = ?1")
    public Optional<Badge> getByname(String name);
}
