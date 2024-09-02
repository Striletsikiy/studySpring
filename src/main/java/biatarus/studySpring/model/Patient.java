package biatarus.studySpring.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Data
//@Entity
@Builder
public class Patient {

//    @Id
//    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
//    @Column(unique = true)
    private String email;
    private String phone;
    @Transient
    private int age;

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
