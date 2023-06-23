package ru.skypro.hw2.course4.hw2course4.security;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AuthUser, Long> {

    AuthUser findByUserName(String userName);
}
