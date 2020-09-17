package com.natwest.UserAuthenticationService.respository;

import com.natwest.UserAuthenticationService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthenticationRepository extends JpaRepository<User, String> {

    User findByUserIdAndUserPassword(String userId, String userPassword);

}
