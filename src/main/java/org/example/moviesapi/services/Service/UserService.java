package org.example.moviesapi.services.Service;

import org.example.moviesapi.model.entity.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface UserService {

    List<UserModel> listUsers();

    UserModel findById(Long id);

    UserModel create(UserModel userModel);

    UserModel update(UserModel userModel);

    boolean delete(Long id);
}
