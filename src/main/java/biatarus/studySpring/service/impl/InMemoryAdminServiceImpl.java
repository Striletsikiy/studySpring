package biatarus.studySpring.service.impl;

import biatarus.studySpring.model.Admin;
import biatarus.studySpring.repository.AdminRepository;
import biatarus.studySpring.repository.InMemoryAdminDAO;
import biatarus.studySpring.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryAdminServiceImpl implements AdminService {

    private final InMemoryAdminDAO inMemoryAdminDAO;

    @Override
    public List<Admin> findAllAdmins() {
        return inMemoryAdminDAO.findAllAdmin();
    }

    @Override
    public Admin findAdminByEmail(String email) {
        return inMemoryAdminDAO.findAdminByEmail(email);
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        return inMemoryAdminDAO.saveAdmin(admin);
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return inMemoryAdminDAO.updateAdmin(admin);
    }

    @Override
    public void deleteAdmin(String email) {
        inMemoryAdminDAO.deleteAdmin(email);
    }
}
