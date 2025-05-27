package org.example.Exo1JPA;

import org.example.Exo1JPA.Model.Animal;
import org.example.Exo1JPA.Model.Diet;
import org.example.entity.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_exo1");
        EntityManager em = emf.createEntityManager();

        Animal animal1 = new Animal("Bidule", 4, Diet.CARNIVORE, 15/10/10);
        Animal animal2 = new Animal("Truc", 5, Diet.HERBIVORE, 10/12/25);
        Animal animal3 = new Animal("Machin", 8, Diet.OMNIVORE, 10 /12/ 14);
        Animal animal4 = new Animal("Chouette", 15, Diet.CARNIVORE, 19/ 5 /24);

        em.getTransaction().begin();
        em.persist(animal1);
        em.persist(animal2);
        em.persist(animal3);
        em.persist(animal4);
        em.getTransaction().commit();

        System.out.println("Enter the id of the animal you are looking for: ");
        int idSearch = scanner.nextInt();

        Animal animalFind = em.find(Animal.class, idSearch);
        if(animalFind != null){
            System.out.println(animalFind);
        }else {
            System.out.println("Animal not found");
        }


        // Animals with the name that start with letter B
        TypedQuery<Animal> query1 = em.createQuery("Select a from Animal a where a.name LIKE 'B'% ", Animal.class);
        System.out.println(query1);

        // by Diet
        TypedQuery<Animal> query2 = em.createQuery("Select a from Animal a where a.diet = 'CARNIVORE'", Animal.class);
        System.out.println(query2);



    }



}
