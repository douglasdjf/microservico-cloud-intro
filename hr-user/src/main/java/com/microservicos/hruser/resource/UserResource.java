package com.microservicos.hruser.resource;

import com.microservicos.hruser.domain.service.UserService;
import com.microservicos.hruser.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService usuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") Long id) throws UserPrincipalNotFoundException {
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<UserDTO> search(@RequestParam String email) throws UserPrincipalNotFoundException {
        return ResponseEntity.ok(usuarioService.findByEmail(email));
    }
}
