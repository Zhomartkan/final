package com.example.HospitalSystem.Services.Interface;

import com.example.HospitalSystem.objects.Diagnosis;

import java.util.List;
import java.util.Optional;

public interface DiagnosisServiceI {
    void addDiagnosis(Diagnosis diagnosis);
    void deleteDiagnosis(Long id);
    void updateDiagnosis(Long id, Diagnosis diagnosis);
    Optional<Diagnosis> getDiagnosisById(Long id);
    List<Diagnosis> getAllDiagnosis();
}
