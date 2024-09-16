package biatarus.studySpring.repository;

import biatarus.studySpring.model.Admin;
import biatarus.studySpring.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    void deleteByEmail(String email);
    Admin findAdminByEmail(String email);
}
