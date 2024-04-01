package org.example.moviesapi.facades.impl;


import org.example.moviesapi.facades.UserFacade;
import org.example.moviesapi.services.Service.UserService;

import org.example.moviesapi.model.Dto.UserDto;
import org.example.moviesapi.model.entity.UserModel;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class UserFacadeImpl implements UserFacade {

    @Autowired
    UserService userService;




    @Override
    public List<UserDto> listUsers() {
        final List<UserModel> userModels = userService.listUsers();
        final List<UserDto> userDtos = new ArrayList<>();


        for (UserModel user : userModels){
            UserDto dto = new UserDto();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            dto.setUsername(user.getUsername());

            userDtos.add(dto);
        }


        return userDtos;
    }

    @Override
    public Optional<UserModel> findById(Long id) {
        if (Objects.isNull(id)) { throw new RuntimeException("Parametro nao encontrado");}
        return userService.findById(id);
    }

    @Override
    public UserModel create(UserModel userModel) {
        if (Objects.isNull(userModel)){throw new RuntimeException("Por Favor insira um parametro válido ");}
        return userService.create(userModel);
     }

    @Override
    public UserModel update(UserModel userModel) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
