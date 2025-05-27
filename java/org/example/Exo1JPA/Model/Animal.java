package org.example.Exo1JPA.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private Diet diet;
    private int entryDate;

    public Animal(String name, int age, Diet diet, int entryDate) {
        this.name = name;
        this.age = age;
        this.diet = diet;
        this.entryDate = entryDate;
    }
}
