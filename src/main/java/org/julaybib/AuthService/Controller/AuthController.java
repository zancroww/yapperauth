package org.julaybib.AuthService.Controller;


import org.julaybib.AuthService.Models.Users;
import org.julaybib.AuthService.Models.UserLoginRecord;
import org.julaybib.AuthService.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsersService service;


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public void register(@RequestBody Users user) {
        user = service.register(user);
    }

    @PostMapping("/login")
    public UserLoginRecord login(@RequestBody Users user) {

        return new UserLoginRecord(user.getUsername(), service.verify(user));
    }
}