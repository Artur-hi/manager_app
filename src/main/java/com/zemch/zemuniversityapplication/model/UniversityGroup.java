package com.zemch.zemuniversityapplication.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UniversityGroup {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    LocalDate createdAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universityGroup")
    Set<Student> students;
}
