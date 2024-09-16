package biatarus.studySpring.service.impl;

import biatarus.studySpring.model.Dentist;
import biatarus.studySpring.repository.DentistRepository;
import biatarus.studySpring.service.DentistService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@AllArgsConstructor
public class DentistServiceImpl implements DentistService {

    private final DentistRepository dentistRepository;

    @Override
    public List<Dentist> findAllDentists() {
        return dentistRepository.findAll();
    }

    @Override
    public Dentist findDentistByEmail(String email) {
        return dentistRepository.findDentistByEmail(email);
    }

    @Override
    public Dentist saveDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public Dentist updateDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public void deleteDentist(String email) {
        dentistRepository.deleteByEmail(email);
    }
}

