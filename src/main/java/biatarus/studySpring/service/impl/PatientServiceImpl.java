package biatarus.studySpring.service.impl;

import biatarus.studySpring.model.Patient;
import biatarus.studySpring.repository.PatientRepository;
import biatarus.studySpring.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public List<Patient> findAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient findPatientByEmail(String email) {
        return patientRepository.findPatientByEmail(email);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(String email) {
        patientRepository.deleteByEmail(email);
    }
}
