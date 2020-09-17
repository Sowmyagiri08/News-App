package com.natwest.UserAuthenticationService.service;

import com.natwest.UserAuthenticationService.exception.UserAlreadyExistsException;
import com.natwest.UserAuthenticationService.exception.UserNotFoundException;
import com.natwest.UserAuthenticationService.model.User;
import com.natwest.UserAuthenticationService.respository.UserAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService{



    private UserAuthenticationRepository userAuthenticationRepository;

    @Autowired
    public UserAuthenticationServiceImpl(UserAuthenticationRepository userAuthenticationRepository) {
        this.userAuthenticationRepository = userAuthenticationRepository;
    }

    @Override
    public User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException {
        User foundUser = userAuthenticationRepository.findByUserIdAndUserPassword(userId,password);
        if(foundUser!=null){
            return foundUser;
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    @Override
    public boolean saveUser(User user) throws UserAlreadyExistsException {
        Optional<User> optionalUser = userAuthenticationRepository.findById(user.getUserId());
        if(optionalUser.isPresent()){
            throw new UserAlreadyExistsException("User already exists");
        } else {
            user.setUserAddedDate(new Date());
            userAuthenticationRepository.save(user);
            return true;
        }
    }
}
