package org.example.springboot.repository;

import org.example.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

  //  Optional<User> findByEmail(String email);
   // User findByEmailAndPassword(String email, String password);

 //  Optional<User> findByEmailAndPassword(String email, String password);

//    @Query("SELECT u FROM users u WHERE u.email = :email AND u.password = :password")
//    Optional<User> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);


    Optional<User> findByuserName(String username);
}
