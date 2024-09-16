package biatarus.studySpring.service.impl;

import biatarus.studySpring.model.Dentist;
import biatarus.studySpring.repository.InMemoryDentistDAO;
import biatarus.studySpring.service.DentistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryDentistServiceImpl implements DentistService {

    private final InMemoryDentistDAO dentistDAO;

    @Override
    public List<Dentist> findAllDentists() {
        return dentistDAO.findAllDentist();
    }

    @Override
    public Dentist findDentistByEmail(String email) {
        return dentistDAO.findDentistByEmail(email);
    }

    @Override
    public Dentist saveDentist(Dentist dentist) {
        return dentistDAO.saveDentist(dentist);
    }

    @Override
    public Dentist updateDentist(Dentist dentist) {
        return dentistDAO.updateDentist(dentist);
    }

    @Override
    public void deleteDentist(String email) {
        dentistDAO.deleteDentist(email);
    }
}
