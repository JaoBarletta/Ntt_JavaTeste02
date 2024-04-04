package org.example.moviesapi.services.ServicesImpl;

import org.example.moviesapi.services.Service.UserService;
import org.example.moviesapi.handlers.ParametroInvalidoException;
import org.example.moviesapi.handlers.RecursoNaoEncontradoExecption;
import org.example.moviesapi.model.entity.UserModel;
import org.example.moviesapi.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
     UserRepository userRepository;

    @Override
    public List<UserModel> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserModel findById(Long id) {
        return userRepository.findById(id).get();
    }


    @Override
    public UserModel create(UserModel userModel) {

        userModel.setId(null);

        UserModel existUser = userRepository.findByUsername(userModel.getUsername());

        if (existUser != null)
        {
            throw new ParametroInvalidoException("Usuario ja existe");
        }


        return userRepository.save(userModel);
    }

    @Override
    public UserModel update(UserModel userModel) {


        return userRepository.save(userModel);
    }

    @Override
    public boolean delete(Long id) {

        findById(id);

        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new RecursoNaoEncontradoExecption("Id informado não encontrado!");
        }

    }
}
