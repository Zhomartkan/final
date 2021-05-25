package com.example.HospitalSystem.Services;
import com.example.HospitalSystem.Services.Interface.UserServiceI;
import com.example.HospitalSystem.repository.UserRepository;
import com.example.HospitalSystem.objects.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class UserService implements UserServiceI, UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void addUser(Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        userRepository.saveAndFlush(users);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(Long id, Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        users.setId(id);
        userRepository.saveAndFlush(users);
    }

    @Override
    public Optional<Users> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users users = userRepository.findByUsername(s);
        if (users == null) {
            throw new UsernameNotFoundException("User " + s + " not found.");
        }
        return users;
    }
}
