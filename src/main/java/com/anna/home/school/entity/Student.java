package com.anna.home.school.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "surname")
    private String surname;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

}
