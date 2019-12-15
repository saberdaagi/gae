package com.teck.up.gae.repo;


import com.teck.up.gae.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(" select u from User u " +
            " where u.username = ?1")
    Optional<User> findUserWithName(String username);

    @Query("select  u from User u where u.matricule =?1")
    Optional<User> findUserWithMatricule(String matricule );

    @Modifying
    @Query("update User u set u.email = ?1, u.username = ?2 ,u.prenom = ?3 ,u.date_nai = ?4 where u.matricule = ?5")
    User setUserInfoByMatricule(String email, String username, String prenom , Date date_nai , String matricule);
}
