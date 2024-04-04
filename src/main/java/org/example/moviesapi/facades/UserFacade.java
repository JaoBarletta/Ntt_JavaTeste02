package org.example.moviesapi.facades;


import org.example.moviesapi.model.Dto.UserDto;
import org.example.moviesapi.model.entity.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserFacade {
    List<UserDto> listUsers();

    UserDto findById(Long id);

    UserDto create(UserModel userModel);

    UserDto update(UserModel userModel);

    Boolean delete(Long id);
}
