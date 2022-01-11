package com.github.pedroluiznogueira.vehiclecatalogapi.repository;

import com.github.pedroluiznogueira.vehiclecatalogapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmail(String username);

    Optional<User> findById(Integer id);

    User findUserByName(String name);
}