package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.SignupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Repository
public class AccountLockRepoImpl implements AccountLockRepo {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public AccountLockRepoImpl() {
        System.out.println("Created AccountLockRepoImpl");
    }

    @Override
    public SignupDto findByEmailId(String emailId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT s FROM SignupDto s WHERE s.emailId = :emailId");
            query.setParameter("emailId", emailId);
            return (SignupDto) query.getSingleResult();
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null; // Handle exception gracefully, maybe throw a custom exception
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean update(SignupDto signupDto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(signupDto);
            transaction.commit();
            return true;
        } catch (PersistenceException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false; // Handle exception gracefully, maybe throw a custom exception
        } finally {
            entityManager.close();
        }
    }
}
