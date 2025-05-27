package org.example;


import org.example.entity.Account;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
        EntityManager em = emf.createEntityManager();

//        Account account2 = new Account(6000, "Lui", "3");
//        Account account3 = new Account(4000, "Celle la", "2");
//        Account account4 = new Account(1000, "L'autre", "28");


//        em.getTransaction().begin();
//        em.persist(account2);
//        em.persist(account3);
//        em.persist(account4);
//        em.getTransaction().commit();

        Account accountfind = em.find(Account.class,2);
        if(accountfind != null){
            System.out.println(accountfind);
        }else {
            System.out.println("No account find");
        }


        try{
            Account accountfindByRef = em.getReference(Account.class,4);
            System.out.println(accountfindByRef);

        }catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }

        TypedQuery<Account> query = em.createQuery("Select a from Account a where a.balance > 500", Account.class);

        List<Account> accounts = query.getResultList();

//        accounts.forEach(System.out::println);

        for (Account account : accounts){
            System.out.println(account);
        }

        // update

        try{
            Account accountToUpdate = em.getReference(Account.class, 2);
            em.getTransaction().begin();
            accountToUpdate.setBalance(450);
            em.getTransaction().commit();
        }catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }
        System.out.println(em.find(Account.class,2));


// delete

        Account accountToDelete = em.find(Account.class, 3);
        if(accountToDelete != null){
            em.getTransaction().begin();
            em.remove(accountToDelete);
            em.getTransaction().commit();
        }

        System.out.println(Account.class);
    }




}

