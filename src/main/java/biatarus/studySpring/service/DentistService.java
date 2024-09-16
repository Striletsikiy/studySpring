package biatarus.studySpring.service;

import biatarus.studySpring.model.Dentist;

import java.util.List;

public interface DentistService {

    List<Dentist> findAllDentists();
    Dentist findDentistByEmail(String email);
    Dentist saveDentist(Dentist dentist);
    Dentist updateDentist(Dentist dentist);
    void deleteDentist(String email);
}
