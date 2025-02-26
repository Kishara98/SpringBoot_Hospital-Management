package com.hospital.HospitalManagementApplication.controller;

import com.hospital.HospitalManagementApplication.model.Patient;
import com.hospital.HospitalManagementApplication.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital/patients")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{patient_id}")
    public Patient getPatientById(@PathVariable Long patient_id) {
        return patientService.getPatientById(patient_id);
    }

    @PostMapping("/")
    public Patient savePatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @PutMapping("/{patient_id}")
    public Patient updatePatient(@PathVariable Long patient_id, @RequestBody Patient patient) {
        patient.setPatientId(patient_id);
        return patientService.savePatient(patient);
    }

    @DeleteMapping("/{patient_id}")
    public void deletePatient(@PathVariable Long patient_id) {
        patientService.deletePatient(patient_id);
    }
}
