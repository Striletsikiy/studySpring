package biatarus.studySpring.repository;

import biatarus.studySpring.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Long> {
    void deleteByEmail(String email);
    Dentist findDentistByEmail(String email);
}
