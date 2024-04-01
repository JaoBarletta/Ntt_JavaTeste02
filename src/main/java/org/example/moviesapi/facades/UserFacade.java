package org.example.moviesapi.facades;

import org.example.moviesapi.model.Dto.UserDto;
import org.example.moviesapi.model.entity.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserFacade {
    List<UserDto> listUsers();

    Optional<UserModel> findById(Long id);

    UserModel create(UserModel userModel);

    UserModel update(UserModel userModel);

    Boolean delete(Long id);
}
