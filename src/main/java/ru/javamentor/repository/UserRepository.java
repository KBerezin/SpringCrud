package ru.javamentor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javamentor.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}