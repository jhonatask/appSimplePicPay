package br.com.jproject.mapper.user;


import br.com.jproject.dto.user.UserDTO;
import br.com.jproject.entity.user.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jakarta")
public interface UserMapperDTO {

    UserDTO userDtoToUser(User entity);
    User userToUserDto(UserDTO entity);
}
