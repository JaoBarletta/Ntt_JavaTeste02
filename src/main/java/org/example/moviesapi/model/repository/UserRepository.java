package org.example.moviesapi.model.repository;

import org.example.moviesapi.model.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {


    UserModel findByName (String name);

    UserModel findByEmail (String email);

    UserModel findByEmailAndName(String email, String name);

    @Query("from UserModel u where u.name = :name") //JPQL
    UserModel busquePorNome (String name);

    @Query("from UserModel u where u.email = :email") //JPQL
    UserModel busquePorEmail (@Param("email") String email);

//    @Query("SELECT u FROM UserModel u JOIN FETCH u.roles where u.username = :username")
//    UserModel findByUsernameFetchRoles(@Param("username") String username);

    UserModel findByUsername(String username);

}
