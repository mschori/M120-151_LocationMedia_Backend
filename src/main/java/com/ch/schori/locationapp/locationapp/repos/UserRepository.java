package com.ch.schori.locationapp.locationapp.repos;

import com.ch.schori.locationapp.locationapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT a FROM User a WHERE a.username = :username")
    User getUserByUsername(@Param("username") String username);

//    @Query("SELECT u.id, u.username FROM User u LEFT JOIN Location l on u.id=l.fk_user")
//    List<User> getUsersWithLocationCount();
}
