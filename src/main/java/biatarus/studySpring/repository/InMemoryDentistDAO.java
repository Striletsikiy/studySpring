package biatarus.studySpring.repository;

import biatarus.studySpring.model.Dentist;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryDentistDAO {

    private final List<Dentist> DENTISTS = new ArrayList<>();

    public List<Dentist> findAllDentist() {
        return DENTISTS;
    }

    public Dentist saveDentist(Dentist dentist) {
        DENTISTS.add(dentist);
        return dentist;
    }

    public Dentist findDentistByEmail(String email) {
        return DENTISTS.stream()
                .filter(element -> element.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public Dentist updateDentist(Dentist dentist) {
        var dentistIndex = IntStream.range(0, DENTISTS.size())
                .filter(index -> DENTISTS.get(index).getEmail().equals(dentist.getEmail()))
                .findFirst()
                .orElse(-1);
        if (dentistIndex > -1) {
            DENTISTS.set(dentistIndex, dentist);
            return dentist;
        }
        return null;
    }

    public void deleteDentist(String email) {
        var dentist = findDentistByEmail(email);
        if (dentist != null) {
            DENTISTS.remove(dentist);
        }

    }

    public Dentist findDentistById(Long id) {
        return DENTISTS.stream()
                .filter(dentist -> dentist.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
