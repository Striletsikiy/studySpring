package biatarus.studySpring.service;

import biatarus.studySpring.model.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> findAllAdmins();
    Admin findAdminByEmail(String email);
    Admin saveAdmin(Admin admin);
    Admin updateAdmin(Admin admin);
    void deleteAdmin(String email);
}
