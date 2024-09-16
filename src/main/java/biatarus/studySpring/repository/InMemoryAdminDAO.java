package biatarus.studySpring.repository;

import biatarus.studySpring.model.Admin;
import biatarus.studySpring.model.Dentist;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryAdminDAO {

    private final List<Admin> ADMIN = new ArrayList<>();

    public List<Admin> findAllAdmin() {
        return ADMIN;
    }

    public Admin saveAdmin(Admin admin) {
        ADMIN.add(admin);
        return admin;
    }

    public Admin findAdminByEmail(String email) {
        return ADMIN.stream()
                .filter(element -> element.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public Admin updateAdmin(Admin admin) {
        var adminIndex = IntStream.range(0, ADMIN.size())
                .filter(index -> ADMIN.get(index).getEmail().equals(admin.getEmail()))
                .findFirst()
                .orElse(-1);
        if (adminIndex > -1) {
            ADMIN.set(adminIndex, admin);
            return admin;
        }
        return null;
    }

    public void deleteAdmin(String email) {
        var admin = findAdminByEmail(email);
        if (admin != null) {
            ADMIN.remove(admin);
        }

    }
}
