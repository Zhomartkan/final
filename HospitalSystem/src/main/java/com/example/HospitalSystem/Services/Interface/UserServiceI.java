package com.example.HospitalSystem.Services.Interface;

import com.example.HospitalSystem.objects.Users;

import java.util.List;
import java.util.Optional;

public interface UserServiceI {
    void addUser(Users users);
    void deleteUser(Long id);
    void updateUser(Long id, Users users);
    Optional<Users> getUserById(Long id);
    List<Users> getAllUsers();
}
