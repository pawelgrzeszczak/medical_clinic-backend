package com.kodilla.medicalclinic.mapper;

import com.kodilla.medicalclinic.domain.dto.UserDto;
import com.kodilla.medicalclinic.domain.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getFirstname(),
                userDto.getLastname(),
                userDto.getLogin(),
                userDto.getPassword());
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getLogin(),
                user.getPassword());
    }

// zwracanie all Userow
//    public List<UserDto> mapToUserDtoList(final List<User> userList) {
//        return userList.stream()
//                .map(u -> new UserDto(u.getId(), u.getFirstname(), u.getLastname(), u.getLogin(), u.getPassword()))
//                .collect(Collectors.toList());
//    }
}
