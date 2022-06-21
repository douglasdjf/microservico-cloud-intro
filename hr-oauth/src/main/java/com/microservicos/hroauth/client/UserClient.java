package com.microservicos.hroauth.client;

import com.microservicos.hroauth.client.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@FeignClient(name = "${hr-user.name}", path = "/users")
public interface UserClient {

    @GetMapping("/search")
    ResponseEntity<UserDTO> search(@RequestParam("email") String email) ;
}
