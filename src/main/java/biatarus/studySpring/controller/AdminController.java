package biatarus.studySpring.controller;

import biatarus.studySpring.model.Admin;
import biatarus.studySpring.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@AllArgsConstructor
public class AdminController {

    private AdminService adminService;

    @GetMapping("/all_admins")
    public List<Admin> getAllAdmins() {
        return adminService.findAllAdmins();
    }

    @GetMapping("/{email}")
    public Admin getAdminByEmail(@PathVariable String email) {
        return adminService.findAdminByEmail(email);
    }

    @PostMapping("/save_admin")
    public Admin saveAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }

    @PutMapping("/update_admin")
    public Admin updateAdmin(@RequestBody Admin admin) {
        return adminService.updateAdmin(admin);
    }

    @DeleteMapping("/delete_admin/{email}")
    public void deleteAdmin(@PathVariable String email) {
        adminService.deleteAdmin(email);
    }
}
