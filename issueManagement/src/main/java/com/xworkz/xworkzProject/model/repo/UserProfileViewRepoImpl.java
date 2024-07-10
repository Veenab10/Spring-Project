package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.SignupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

@Repository
public class UserProfileViewRepoImpl implements UserProfileViewRepo {
    @Autowired
    private EntityManagerFactory entityManagerFactory;


    public UserProfileViewRepoImpl()
    {
        System.out.println("Created UserProfileViewRepoImpl");
    }


    @Override
    public SignupDto findByEmailId(String emailId){

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String query = "SELECT e FROM SignupDto e WHERE e.emailId=:emailId";
        Query query1 = entityManager.createQuery(query);
        query1.setParameter("emailId",emailId);

        SignupDto signUpDTO= (SignupDto) query1.getSingleResult();
        System.out.println(signUpDTO);

        return  signUpDTO;

    }
}
