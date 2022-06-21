package com.microservicos.hroauth.service;

import com.microservicos.hroauth.client.UserClient;
import com.microservicos.hroauth.client.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserClient userClient;


    public UserDTO findByEmail(String email){
      UserDTO userDTO=  userClient.search(email).getBody();
      if(userDTO == null) {
          log.info("Email not found:"+ email);
          throw new IllegalArgumentException("Email not found");
      }
        log.info("Email found:"+ email);
      return userDTO;
    }

}
