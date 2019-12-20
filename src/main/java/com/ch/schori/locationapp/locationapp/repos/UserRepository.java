package com.ch.schori.locationapp.locationapp.repos;

import com.ch.schori.locationapp.locationapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT a FROM User a WHERE a.username = :username")
    User getUserByUsername(@Param("username") String username);
}
