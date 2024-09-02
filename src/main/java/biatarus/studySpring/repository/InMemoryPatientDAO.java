package biatarus.studySpring.repository;

import biatarus.studySpring.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryPatientDAO {

    private final List<Patient> PATIENTS = new ArrayList<>();

    public List<Patient> findAllPatient() {
        return PATIENTS;
    }

    public Patient savePatient(Patient patient) {
        PATIENTS.add(patient);
        return patient;
    }

    public Patient findPatientByEmail(String email) {
        return PATIENTS.stream()
                .filter(element -> element.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public Patient updatePatient(Patient patient) {
        var patientIndex = IntStream.range(0, PATIENTS.size())
                .filter(index -> PATIENTS.get(index).getEmail().equals(patient.getEmail()))
                .findFirst()
                .orElse(-1);
        if (patientIndex > -1) {
            PATIENTS.set(patientIndex, patient);
            return patient;
        }
        return null;
    }

    public void deletePatient(String email) {
        var patient = findPatientByEmail(email);
        if (patient != null) {
            PATIENTS.remove(patient);
        }

    }
}
