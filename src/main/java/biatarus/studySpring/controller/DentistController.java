package biatarus.studySpring.controller;

import biatarus.studySpring.model.Dentist;
import biatarus.studySpring.service.DentistService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dentist")
@AllArgsConstructor
public class DentistController {

    private final DentistService dentistService;

    @GetMapping("/all_dentists")
    public List<Dentist> getAllDentists() {
        return dentistService.findAllDentists();
    }

    @GetMapping("/{email}")
    public Dentist getDentistByEmail(@PathVariable String email) {
        return dentistService.findDentistByEmail(email);
    }

    @PostMapping("/save_dentist")
    public Dentist saveDentist(@RequestBody Dentist dentist) {
        return dentistService.saveDentist(dentist);
    }

    @PutMapping("update_dentist")
    public Dentist updatePatient(@RequestBody Dentist dentist) {
        return dentistService.updateDentist(dentist);
    }

    @DeleteMapping("/delete_dentist/{email}")
    public void deleteDentist(@PathVariable String email) {
        dentistService.deleteDentist(email);
    }
}

