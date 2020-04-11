package ru.javamentor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javamentor.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByRole (String role);
}