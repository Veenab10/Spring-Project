package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.SignupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class ForgetPasswordRepoImpl implements ForgetPasswordRepo {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    public ForgetPasswordRepoImpl()
    {
        System.out.println("Created ForgetPasswordRepoImpl");
    }

    @Override
    public SignupDto findByEmailId(String emailId) {
        System.out.println("Running findByEmailId method in ForgetPasswordRepoImpl...");
        EntityManager entityManager =entityManagerFactory.createEntityManager();

        try {
            Query query =entityManager.createQuery("Select s from SignupDto s where s.emailId=:emailId");
            query.setParameter("emailId",emailId);
            SignupDto signupDto= (SignupDto) query.getSingleResult();
            return signupDto;

        }
        catch (PersistenceException persistenceException)
        {
            persistenceException.getStackTrace();

        }
        finally {
            if(entityManager!=null) {
                entityManager.close();
            }
        }

        return null;
    }

    @Override
    public void updatePassword(String emailId,String newPassword) {
        System.out.println("Running updatePassword method in ForgetPasswordRepoImpl..");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();


        try {
            entityTransaction.begin();
            Query query=entityManager.createQuery("Update SignupDto s SET s.password=:newPassword where s.emailId=:emailId");
            query.setParameter("emailId",emailId);
            query.setParameter("newPassword",newPassword);
            query.executeUpdate(); // Execute update query
            entityTransaction.commit();
        }

        catch (PersistenceException persistenceException)
        {
            persistenceException.getStackTrace();
            entityTransaction.rollback();
        }
        finally {
            if(entityManager!=null) {
                entityManager.close();
            }
        }

    }


}
