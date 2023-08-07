package net.example.springboot.mapper;

import net.example.springboot.dto.UserDTO;
import net.example.springboot.enteties.User;

public class UserMapper {

    public static UserDTO mapToUserDTo(User user) {
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDTO;
    }

    public static User mapToUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail()
        );
        return user;
    }
}
