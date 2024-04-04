package org.example.moviesapi.controler;


import org.example.moviesapi.facades.UserFacade;

import org.example.moviesapi.model.Dto.UserDto;
import org.example.moviesapi.model.entity.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserFacade userFacade;


    @GetMapping(value = "/")
    public ResponseEntity<?> findAll()
    {
        try{
            List<UserDto> response = userFacade.listUsers();
            return ResponseEntity.ok(response);

        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id)
    {
try {
    UserDto response = userFacade.findById(id);
    return ResponseEntity.ok(response);


}catch (Exception error){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMessage());


}

    }



    @PostMapping(value = "/save")
    public ResponseEntity<?> create(@RequestBody UserModel userModel)
    {
        try
        {
            UserDto response = userFacade.create(userModel);
            return ResponseEntity.ok(response);
        }
        catch (Exception error){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }

    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody UserModel userModel)
    {

        try{
            UserDto response = userFacade.update(userModel);
            return ResponseEntity.ok(response);

        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());

        }



    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteById(@PathVariable Long id) {
        try {

            Boolean success = userFacade.delete(id);
            return true;
        } catch (Exception error) {
            return false;


        }
    }
}

