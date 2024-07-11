package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.ProfileImageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

@Repository
public class ProfileImageRepoImpl implements ProfileImageRepo {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public ProfileImageRepoImpl()
    {
        System.out.println("Created ProfileImageRepoImpl");
    }


    @Override
    public boolean save(ProfileImageDto profileImageDto) {
        System.out.println("Running  save method in ProfileImageRepoImpl");
        EntityManager entityManager =this.entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction =entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(profileImageDto);
            entityTransaction.commit();
        }
        catch (PersistenceException persistenceException)
        {
            persistenceException.getStackTrace();
            entityTransaction.rollback();
        }
        finally {
            entityManager.close();
        }
        return true;
    }
}
