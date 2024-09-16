package biatarus.studySpring.service;

import biatarus.studySpring.model.Admin;
import biatarus.studySpring.model.Dentist;
import biatarus.studySpring.model.Patient;
import biatarus.studySpring.repository.AdminRepository;
import biatarus.studySpring.repository.DentistRepository;
import biatarus.studySpring.repository.PatientRepository;
import biatarus.studySpring.security.CustomUserDetails;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Data
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;
    private final DentistRepository dentistRepository;
    private final PatientRepository patientRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin admin = adminRepository.findAdminByEmail(email);
        if (admin != null) {
            return new CustomUserDetails(admin.getEmail(), admin.getPassword(), "ROLE_ADMIN");
        }

        Dentist dentist = dentistRepository.findDentistByEmail(email);
        if (dentist != null) {
            return new CustomUserDetails(dentist.getEmail(), dentist.getPassword(), "ROLE_DENTIST");
        }

        Patient patient = patientRepository.findPatientByEmail(email);
        if (patient != null) {
            return new CustomUserDetails(patient.getEmail(), patient.getPassword(), "ROLE_PATIENT");
        }

        throw new UsernameNotFoundException("User not found with email: " + email);
    }

}
