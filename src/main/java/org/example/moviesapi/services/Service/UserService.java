package org.example.moviesapi.services.Service;

import org.example.moviesapi.model.entity.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface UserService {

    List<UserModel> listUsers();

    Optional<UserModel> findById(Long id);

    UserModel create(UserModel userModel);

    UserModel update(UserModel userModel);

    boolean delete(Long id);
}
