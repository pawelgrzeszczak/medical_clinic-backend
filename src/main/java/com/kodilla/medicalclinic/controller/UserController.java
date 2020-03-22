package com.kodilla.medicalclinic.controller;

import com.kodilla.medicalclinic.domain.dto.UserDto;
import com.kodilla.medicalclinic.mapper.UserMapper;
import com.kodilla.medicalclinic.service.DbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1")
public class UserController {
    @Autowired
    private DbUserService dbUserService;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(method = RequestMethod.POST, value = "/user", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        dbUserService.saveUser(userMapper.mapToUser(userDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user")
//    @RequestMapping(method = RequestMethod.GET, value = "/user{userId}")
    public UserDto getUser(@RequestParam Long userId) throws UserNotFoundException {
//    public UserDto getUser(@PathVariable Long userId) throws UserNotFoundException {
        return userMapper.mapToUserDto(dbUserService.getUser(userId).orElseThrow(UserNotFoundException::new));
//        return new UserDto(1L, "Jan", "Kowalski", "jkowalski", "jkowalski", new ArrayList<>());
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/user")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(dbUserService.saveUser(userMapper.mapToUser(userDto)));
//        return new UserDto(1L, "Jan2", "Kowalski2", "jkowalski2", "jkowalski2", new ArrayList<>());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/user{userId}")
    public void deleteUser(@PathVariable Long userId) {
        dbUserService.deleteUser(userId);
    }
}