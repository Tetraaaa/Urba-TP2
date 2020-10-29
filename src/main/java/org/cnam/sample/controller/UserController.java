package org.cnam.sample.controller;

import org.cnam.sample.controller.dto.AccountResponse;
import org.cnam.sample.controller.dto.AccountToCreateRequest;
import org.cnam.sample.controller.dto.UserResponse;
import org.cnam.sample.controller.dto.UserToCreateRequest;
import org.cnam.sample.domain.AccountService;
import org.cnam.sample.domain.UserService;
import org.cnam.sample.domain.entity.Account;
import org.cnam.sample.domain.entity.AccountToCreate;
import org.cnam.sample.domain.entity.User;
import org.cnam.sample.domain.entity.UserToCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<UserResponse> getUser(@PathVariable("id") Long id) {
        User userFound = userService.getById(id);
        if(userFound == null) return ResponseEntity.notFound().build();

        UserResponse userResponse = new UserResponse(userFound.id, userFound.firstname, userFound.lastname);

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<UserResponse> createUser(@RequestBody UserToCreateRequest userToCreateRequest) {
        UserToCreate userToCreate = new UserToCreate(userToCreateRequest.firstname, userToCreateRequest.lastname);

        User userCreated = userService.create(userToCreate);

        UserResponse userResponse = new UserResponse(userCreated.id, userCreated.firstname, userCreated.lastname);

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<UserResponse> updateUser(@PathVariable("id") Long id, @PathParam("firstname") String firstname, @PathParam("lastname") String lastname) {
        User userFound = userService.getById(id);
        if(userFound == null) return ResponseEntity.notFound().build();

        User userUpdate = userService.update(userFound, firstname, lastname);

        UserResponse userResponse = new UserResponse(userUpdate.id, userUpdate.firstname, userUpdate.lastname);

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity deleteUser(@PathVariable("id") Long id) {
        User userFound = userService.getById(id);
        if(userFound == null) return ResponseEntity.notFound().build();

        userService.delete(userFound);

        return ResponseEntity.ok().build();
    }
}
