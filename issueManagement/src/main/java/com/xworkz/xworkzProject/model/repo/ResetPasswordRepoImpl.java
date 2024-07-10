package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.SignupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class ResetPasswordRepoImpl implements ResetPasswordRepo {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public ResetPasswordRepoImpl()
    {
        System.out.println("Created ResetPasswordRepoImpl");
    }

    @Override
    public SignupDto findByEmailAndPassword(String emailId, String password) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createQuery("select s from SignupDto s where s.emailId = :emailId and s.password = :password");
            query.setParameter("emailId", emailId);
            query.setParameter("password", password);
            return (SignupDto) query.getSingleResult();
        } catch (PersistenceException e) {
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean updatePassword(String emailId, String newPassword) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        boolean updateStatus = false;

        try {
            tx.begin();
            Query query = entityManager.createQuery("UPDATE SignupDto s SET s.password = :password WHERE s.emailId = :emailId");
            query.setParameter("password", newPassword);
            query.setParameter("emailId", emailId);
            int updatedRows = query.executeUpdate();
            tx.commit();
            updateStatus = updatedRows > 0;
        } catch (PersistenceException e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            entityManager.close();
        }

        return updateStatus;
    }
}



