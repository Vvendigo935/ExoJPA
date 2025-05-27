package org.example.Exo1JPA;

import org.example.Exo1JPA.Model.Animal;
import org.example.Exo1JPA.Model.Diet;

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

//        Animal animal1 = new Animal("Bidule", 4, Diet.CARNIVORE, 15/10/10);
//        Animal animal2 = new Animal("Truc", 5, Diet.HERBIVORE, 10/12/25);
//        Animal animal3 = new Animal("Machin", 8, Diet.OMNIVORE, 10 /12/ 14);
//        Animal animal4 = new Animal("Chouette", 15, Diet.CARNIVORE, 19/ 5 /24);
//
//        em.getTransaction().begin();
//        em.persist(animal1);
//        em.persist(animal2);
//        em.persist(animal3);
//        em.persist(animal4);
//        em.getTransaction().commit();

        System.out.println("Enter the id of the animal you are looking for: ");
        int idSearch = scanner.nextInt();

        Animal animalFindById = em.find(Animal.class, idSearch);
        if(animalFindById != null){
            System.out.println(animalFindById);
        }else {
            System.out.println("Animal not found");
        }


        // Animals with the name that start with letter B

        System.out.println("Animals with the name that start with letter B : ");
        TypedQuery<Animal> query1 = em.createQuery("SELECT a FROM Animal a WHERE name LIKE 'B%' ", Animal.class);
        List<Animal> animals = query1.getResultList();
        animals.forEach(System.out::println);

        // by Diet
        searchByDiet();
    }

    private static void searchByDiet(){
        Scanner scanner = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_exo1");
        EntityManager em = emf.createEntityManager();
        System.out.println("Press 1. to show all the Carnivores, 2 for the Herbivores or 3 for the Omnivores");
        byte choice = scanner.nextByte();
        switch (choice){
            case 1:
                TypedQuery<Animal> query2 = em.createQuery("Select a from Animal a where diet = 0 ", Animal.class);
                List<Animal> animals2 = query2.getResultList();
                animals2.forEach(System.out::println);
                break;
                case 2:
                    TypedQuery<Animal> query3 = em.createQuery("Select a from Animal a where diet = 1 ", Animal.class);
                    List<Animal> animals3 = query3.getResultList();
                    animals3.forEach(System.out::println);
                    break;
                    case 3:
                        TypedQuery<Animal> query4 = em.createQuery("Select a from Animal a where diet = 2 ", Animal.class);
                        List<Animal> animals4 = query4.getResultList();
                        animals4.forEach(System.out::println);
                        break;
                        default:
                            System.out.println("Invalid choice");
        }
    }


}
