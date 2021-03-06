package com.microservicos.hruser.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO implements Serializable {

    private Long id;
    private String name;
    private String email;
    private String password;
    private Set<RoleDTO> roles;
}
