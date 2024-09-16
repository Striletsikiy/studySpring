package biatarus.studySpring.controller;

import biatarus.studySpring.model.Patient;
import biatarus.studySpring.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
@AllArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("all_patients")
    public List<Patient> findAllPatient() {
        return patientService.findAllPatient();
    }

    @PostMapping("save_patient")
    public Patient savePatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @GetMapping("/{email}")
    public Patient findPatientByEmail(@PathVariable("email") String email) {
        return patientService.findPatientByEmail(email);
    }

    @PutMapping("update_patient")
    public Patient updatePatient(@RequestBody Patient patient) {
        return patientService.updatePatient(patient);
    }

    @DeleteMapping("delete_patient/{email}")
    public void deletePatient(@PathVariable String email) {
        patientService.deletePatient(email);
    }

}
