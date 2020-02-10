package com.isp.core.repository;

import com.isp.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<User,Long> {

    User findByMatricule(String matricule);


    //void updateUser(@Param("entryId")   );

   /* @Modifying(clearAutomatically = true)
    @Query("update User userEntity set userEntity.email =:email , userEntity.gender=:gender , userEntity.dateNaissance =: dateNaissance, userEntity.firstName =:firstName , userEntity.lastName =: lastName where userEntity.id =:id")
    void updateUser(@Param("id")  Long id, @Param("email")  String email,@Param("gender") String gender, @Param("dateNaissance")Date dateNaissance, @Param("firstName")String firstName,@Param("lastName") String lastName);
*/}
