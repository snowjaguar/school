package com.anna.home.school.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
@Setter
@Getter
public class Group {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "number")
    private String number;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    List<Student> students;
}
