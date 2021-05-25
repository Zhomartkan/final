package com.example.HospitalSystem.repository;

import com.example.HospitalSystem.objects.Diagnosis;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {
    @NotNull
    List<Diagnosis> findAll();
    @NotNull
    Optional<Diagnosis> findById(@NotNull Long id);
}
