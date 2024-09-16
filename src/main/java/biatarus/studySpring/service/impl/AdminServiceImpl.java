package biatarus.studySpring.service.impl;

import biatarus.studySpring.model.Admin;
import biatarus.studySpring.repository.AdminRepository;
import biatarus.studySpring.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Override
    public List<Admin> findAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin findAdminByEmail(String email) {
        return adminRepository.findAdminByEmail(email);
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public void deleteAdmin(String email) {
        adminRepository.deleteByEmail(email);
    }
}
