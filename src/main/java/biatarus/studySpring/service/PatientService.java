package biatarus.studySpring.service;

import biatarus.studySpring.model.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> findAllPatient();

    Patient savePatient(Patient patient);
    Patient findPatientByEmail(String email);
    Patient updatePatient(Patient patient);
    void deletePatient(String email);
}
