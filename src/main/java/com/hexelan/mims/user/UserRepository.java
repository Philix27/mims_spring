package com.hexelan.mims.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Override
    Optional<User> findById(Integer integer);

    Optional<User> findByEmail(String email);
}
