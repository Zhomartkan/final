package com.example.HospitalSystem.Services;

import com.example.HospitalSystem.Services.Interface.DiagnosisServiceI;
import com.example.HospitalSystem.objects.Diagnosis;
import com.example.HospitalSystem.repository.DiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiagnosisService implements DiagnosisServiceI {

    @Autowired
    DiagnosisRepository diagnosisRepository;
    @Override
    public void addDiagnosis(Diagnosis diagnosis) {
        diagnosisRepository.saveAndFlush(diagnosis);
    }

    @Override
    public void deleteDiagnosis(Long id) {
        diagnosisRepository.deleteById(id);
    }

    @Override
    public void updateDiagnosis(Long id, Diagnosis diagnosis) {
        diagnosis.setId(id);
        diagnosisRepository.saveAndFlush(diagnosis);
    }

    @Override
    public Optional<Diagnosis> getDiagnosisById(Long id) {
        return diagnosisRepository.findById(id);
    }

    @Override
    public List<Diagnosis> getAllDiagnosis() {
        return diagnosisRepository.findAll();
    }
}
