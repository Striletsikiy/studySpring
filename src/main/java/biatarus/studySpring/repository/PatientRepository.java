package biatarus.studySpring.repository;

import biatarus.studySpring.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository <Patient, Long> {
    void deleteByEmail(String email);
    Patient findPatientByEmail(String email);
}
