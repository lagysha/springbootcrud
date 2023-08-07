package net.example.springboot.services;

import net.example.springboot.dto.UserDTO;
import net.example.springboot.enteties.User;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO user);
    UserDTO getUserById(Long userId);
    List<UserDTO> getAllUsers();

    UserDTO updateUser(UserDTO user);

    void deleteUser(Long UserId);
}
