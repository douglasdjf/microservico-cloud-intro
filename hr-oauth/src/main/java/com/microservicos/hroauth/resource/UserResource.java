package com.microservicos.hroauth.resource;

import com.microservicos.hroauth.client.dto.UserDTO;
import com.microservicos.hroauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public ResponseEntity<UserDTO> findByEmail(@RequestParam("email") String email){
       return  ResponseEntity.ok(userService.findByEmail(email));
    }

}
