package com.kodilla.medicalclinic.service;

import com.kodilla.medicalclinic.domain.entity.User;
import com.kodilla.medicalclinic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DbUserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

//    public User getUserById(final Long id) {
//        return userRepository.findById(id).orElse(null);
//    }

    public Optional<User> getUser(final Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public void deleteUser(final Long id) {
        userRepository.deleteById(id);
    }
}
