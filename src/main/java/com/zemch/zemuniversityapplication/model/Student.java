package com.zemch.zemuniversityapplication.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    String surname;

    LocalDate createdAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id", foreignKey = @ForeignKey(name = "student_fk_group"))
    UniversityGroup universityGroup;
}
