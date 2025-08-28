package com.nbva.authenticate.application.service;

import com.nbva.authenticate.application.dto.UserDTO;
import com.nbva.authenticate.application.dto.request.CreateUserDTO;

public interface UserService {
    UserDTO createUser(CreateUserDTO createUserDTO);
    UserDTO findByUsername(String username);
}
