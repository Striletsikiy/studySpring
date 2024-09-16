package biatarus.studySpring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.Period;

@Data
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    private String firstName;
    @NotNull
    @NotBlank
    private String lastName;
    private LocalDate birthDate;
    @Email
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    private String password;
    @Transient
    private int age;
    @Enumerated(EnumType.STRING)
    private Role role;

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @ManyToOne
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;
}
