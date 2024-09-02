package biatarus.studySpring.service.impl;

import biatarus.studySpring.model.Patient;
import biatarus.studySpring.repository.InMemoryPatientDAO;
import biatarus.studySpring.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryPatientServiceImpl implements PatientService {
    private final InMemoryPatientDAO inMemoryPatientDAO;

    @Override
    public List<Patient> findAllPatient() {
        return inMemoryPatientDAO.findAllPatient();
    }

    @Override
    public Patient savePatient(Patient patient) {
        return inMemoryPatientDAO.savePatient(patient);
    }

    @Override
    public Patient findPatientByEmail(String email) {
        return inMemoryPatientDAO.findPatientByEmail(email);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return inMemoryPatientDAO.updatePatient(patient);
    }

    @Override
    public void deletePatient(String email) {
        inMemoryPatientDAO.deletePatient(email);
    }
}
