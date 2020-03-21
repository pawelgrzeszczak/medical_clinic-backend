package com.kodilla.medicalclinic.domain.dto;

import com.kodilla.medicalclinic.domain.entity.Visit;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class UserDto {
    private long id;
    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private List<Visit> visits = new ArrayList<>();

    public UserDto(long id, String firstname, String lastname, String login, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
    }
}
