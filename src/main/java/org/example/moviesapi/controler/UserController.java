package org.example.moviesapi.controler;

import org.example.moviesapi.facades.UserFacade;

import org.example.moviesapi.model.Dto.UserDto;
import org.example.moviesapi.model.entity.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserFacade userFacade;


    @GetMapping(value = "/")
    public ResponseEntity<?> findAll()
    {
        List<UserDto> response = userFacade.listUsers();

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<UserModel>> findById(@PathVariable Long id)
    {
        Optional<UserModel> response = userFacade.findById(id);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }



    @PostMapping(value = "/save")
    public ResponseEntity<UserModel> create(@RequestBody UserModel userModel)
    {
        UserModel response = userFacade.create(userModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @PutMapping(value = "/update")
    public ResponseEntity<UserModel> update(@RequestBody UserModel userModel)
    {
        UserModel response = userFacade.update(userModel);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {

        Boolean success = userFacade.delete(id);

        return success ? ResponseEntity.noContent().build() : ResponseEntity.badRequest().build();
    }
}

