package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.SignupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class SignInRepoImpl  implements SignInRepo{

    @Autowired
    public EntityManagerFactory entityManagerFactory;

    public SignInRepoImpl()
    {
        System.out.println("Created SignInRepoImpl");
    }

    @Override
    public SignupDto finByEmailId(String email) {
        System.out.println("Running findByEmailId method... ");
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        try {
            Query query =entityManager.createQuery("Select s from SignupDto s where s.emailId=:emailId");
            query.setParameter("emailId",email);
            SignupDto signupDto= (SignupDto) query.getSingleResult();
            return signupDto;
        }
        catch (PersistenceException persistenceException)
        {
            persistenceException.getStackTrace();
        }
        finally {
            entityManager.close();
        }
        return null;
    }
    //This findByEmailIDANdPassword is used for checking wheather id and pwd are exists in database or not
    @Override
    public SignupDto findByEmailIdAndPassword(String emailId, String password) {
        System.out.println("Running findByEmailIdAndPassword method... ");
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        try {
            Query query =entityManager.createQuery("Select s from SignupDto s where s.emailId=:emailId and s.password=:password");
            query.setParameter("emailId",emailId);
            query.setParameter("password",password);
            SignupDto signupDto= (SignupDto) query.getSingleResult();
            return signupDto;
        }
        catch (PersistenceException persistenceException)
        {
            persistenceException.getStackTrace();
        }
        finally {
            entityManager.close();
        }
        return null;
    }
}
