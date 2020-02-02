package com.teckup.core.repository;

import com.teckup.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface EtudiantRepository extends JpaRepository<User,Long> {

    User findByMatricule(String matricule);


    //void updateUser(@Param("entryId")   );

   /* @Modifying(clearAutomatically = true)
    @Query("update User userEntity set userEntity.email =:email , userEntity.gender=:gender , userEntity.dateNaissance =: dateNaissance, userEntity.firstName =:firstName , userEntity.lastName =: lastName where userEntity.id =:id")
    void updateUser(@Param("id")  Long id, @Param("email")  String email,@Param("gender") String gender, @Param("dateNaissance")Date dateNaissance, @Param("firstName")String firstName,@Param("lastName") String lastName);
*/}
