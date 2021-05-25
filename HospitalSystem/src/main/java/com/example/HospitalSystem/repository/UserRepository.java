package com.example.HospitalSystem.repository;

import com.example.HospitalSystem.objects.Users;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    @NotNull
    List<Users> findAll();
    @NotNull
    Optional<Users> findById(@NotNull Long id);

    Users findByUsername(String s);
}
