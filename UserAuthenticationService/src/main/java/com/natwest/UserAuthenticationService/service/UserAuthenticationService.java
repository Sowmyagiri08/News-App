package com.natwest.UserAuthenticationService.service;

import com.natwest.UserAuthenticationService.exception.UserAlreadyExistsException;
import com.natwest.UserAuthenticationService.exception.UserNotFoundException;
import com.natwest.UserAuthenticationService.model.User;

public interface UserAuthenticationService {

    public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException;

    boolean saveUser(User user) throws UserAlreadyExistsException;
}
