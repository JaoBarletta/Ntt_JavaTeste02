package org.example.moviesapi.facades.impl;


import org.example.moviesapi.facades.UserFacade;
import org.example.moviesapi.services.Service.UserService;

import org.example.moviesapi.model.Dto.UserDto;
import org.example.moviesapi.model.entity.UserModel;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.*;


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
    public UserDto findById(Long id) {
            UserModel user = userService.findById(id);
            System.out.println(user);
        if (user.getId() == null) { throw new NoSuchElementException("Não foi possivel encontrar o usuário com o id "+id);}
            UserDto dto = new UserDto();
            dto.setName(user.getName());
            dto.setId(user.getId());
            dto.setEmail(user.getEmail());
            dto.setUsername(user.getUsername());


            return dto;


    }

    @Override
    public UserDto create(UserModel userModel) {
        final UserModel user = userService.create(userModel);
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getUsername());


        return dto;

    }

    @Override
    public UserDto update(UserModel userModel) {

        UserModel user = userService.findById(userModel.getId());
        user.setEmail(userModel.getEmail());
        user.setName(userModel.getName());
        user.setUsername(userModel.getUsername());
        user.setPassword(userModel.getPassword());

        UserModel updatedUser = userService.update(user);

        UserDto dto = new UserDto();
        dto.setId(updatedUser.getId());
        dto.setName(updatedUser.getName());
        dto.setEmail(updatedUser.getEmail());
        dto.setUsername(updatedUser.getUsername());


        return dto;
    }

    @Override
    public Boolean delete(Long id) {
        if (Objects.isNull(id)) { throw new RuntimeException("Parametro nao encontrado");}
        userService.delete(id);
        return true;
    }
}
