package net.example.springboot.mapper;

import net.example.springboot.dto.UserDTO;
import net.example.springboot.enteties.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {

    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    UserDTO mapToUserDTO(User user);

    User mapToUser(UserDTO userDTO);
}
