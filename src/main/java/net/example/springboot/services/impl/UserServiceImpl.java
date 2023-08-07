package net.example.springboot.services.impl;

import lombok.AllArgsConstructor;
import net.example.springboot.dto.UserDTO;
import net.example.springboot.enteties.User;
import net.example.springboot.exceptions.EmailAlreadyExistException;
import net.example.springboot.exceptions.ResourceNotFoundException;
import net.example.springboot.mapper.AutoUserMapper;
import net.example.springboot.repositories.UserRepository;
import net.example.springboot.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findByEmail(userDTO.getEmail());
        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistException("Email Already Exists");
        }



        User user = AutoUserMapper.MAPPER.mapToUser(userDTO);
        User savedUser = userRepository.save(user);
        return AutoUserMapper.MAPPER.mapToUserDTO(savedUser);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User optionalUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","id",userId));
        return AutoUserMapper.MAPPER.mapToUserDTO(optionalUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(AutoUserMapper.MAPPER::mapToUserDTO).toList();
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        User existingUser = userRepository.findById(user.getId()).orElseThrow(() -> new ResourceNotFoundException("User","id", user.getId()));
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return AutoUserMapper.MAPPER.mapToUserDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","id", userId));
        userRepository.deleteById(userId);
    }
}
