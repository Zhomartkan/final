package com.example.HospitalSystem.controller;

import com.example.HospitalSystem.Services.DiagnosisService;
import com.example.HospitalSystem.objects.Diagnosis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diagnosis")
public class DiagnosisController {
    @Autowired
    DiagnosisService diagnosisService;

    @GetMapping("/list")
    public List<Diagnosis> getAllDiagnosis() {
        return diagnosisService.getAllDiagnosis();
    }

    @GetMapping("/{id}")
    public Diagnosis getDiagnosisById(@PathVariable("id") Long id) {
        return diagnosisService.getDiagnosisById(id).get();
    }

    @PostMapping("")
    public void addDiagnosis(@RequestBody Diagnosis diagnosis) {
        diagnosisService.addDiagnosis(diagnosis);
    }

    @PutMapping("/{id}")
    public void updateDiagnosis(@PathVariable Long id,
                           @RequestBody Diagnosis diagnosis) {
        diagnosisService.updateDiagnosis(id, diagnosis);
    }

    @DeleteMapping("/{id}")
    public void deleteDiagnosis(@PathVariable("id") Long id) {
        diagnosisService.deleteDiagnosis(id);
    }

}
