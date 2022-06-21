package com.microservicos.hruser.domain.service;

import com.microservicos.hruser.domain.entity.User;
import com.microservicos.hruser.domain.repository.UserRepository;
import com.microservicos.hruser.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO findByEmail(String email) throws UserPrincipalNotFoundException {
        Optional<User>  usuario = userRepository.findByEmail(email);
        if(usuario.isPresent())
            return modelMapper.map(usuario.get(),UserDTO.class);

        throw new UserPrincipalNotFoundException("user email:" +email + " invalid");
    }

    public UserDTO findById(Long id) throws UserPrincipalNotFoundException {
        Optional<User>  usuario = userRepository.findById(id);
        if(usuario.isPresent())
            return modelMapper.map(usuario.get(),UserDTO.class);

         throw new UserPrincipalNotFoundException("user id:" +id + " invalid");
    }
}
