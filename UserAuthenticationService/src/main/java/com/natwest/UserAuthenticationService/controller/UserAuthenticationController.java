package com.natwest.UserAuthenticationService.controller;


import com.natwest.UserAuthenticationService.exception.UserAlreadyExistsException;
import com.natwest.UserAuthenticationService.exception.UserNotFoundException;
import com.natwest.UserAuthenticationService.model.User;
import com.natwest.UserAuthenticationService.service.UserAuthenticationService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/auth")
public class UserAuthenticationController {

    private UserAuthenticationService userAuthenticationService;
    private ResponseEntity responseEntity;
    private Map<String, String> map = new HashMap<>();

    @Autowired
    public UserAuthenticationController(UserAuthenticationService userAuthenticationService) {
        this.userAuthenticationService = userAuthenticationService;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello from User Authentication Service";
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User user) {
        try {
            userAuthenticationService.saveUser(user);
            responseEntity = new ResponseEntity("User registered successfully", HttpStatus.CREATED);
        } catch (UserAlreadyExistsException e) {
            responseEntity = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        } catch (Exception e) {
            responseEntity = new ResponseEntity("Some Internal Error Try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }


    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody User user) {
        try {
            String jwtToken = getToken(user.getUserId(), user.getUserPassword());
            map.put("message", "User successfully logged in");
            map.put("token", jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message", e.getMessage());
            map.put("token", null);
            return new ResponseEntity(map, HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity(map, HttpStatus.OK);
    }

    public String getToken(String username, String password) throws Exception {
        String jwtToken = "";
        if (username == null || password == null) {
            throw new Exception("Please send valid username or password");
        }
        try {
            User user = userAuthenticationService.findByUserIdAndPassword(username, password);
            jwtToken = Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, "secretkey")
                    .compact();
        } catch (UserNotFoundException e) {
            throw new Exception("Invalid credentials");
        }
        return jwtToken;
    }

}
