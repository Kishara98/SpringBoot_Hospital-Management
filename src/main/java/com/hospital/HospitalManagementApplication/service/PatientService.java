package com.hospital.HospitalManagementApplication.service;

import com.hospital.HospitalManagementApplication.model.Patient;
import com.hospital.HospitalManagementApplication.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    public Patient getPatientById(Long patient_id) {
        return patientRepository.findById(patient_id).orElse(null);
    }
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }
    public void deletePatient(Long patient_id) {
        patientRepository.deleteById(patient_id);
    }

}
