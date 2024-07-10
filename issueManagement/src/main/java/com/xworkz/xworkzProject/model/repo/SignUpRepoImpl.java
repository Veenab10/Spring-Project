package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.SignupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Optional;

@Repository
public class SignUpRepoImpl implements SignUpRepo {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public SignUpRepoImpl()
    {
        System.out.println("Created SignUpRepoImpl");
    }

    @Override
    public boolean save( SignupDto signupDto) {
        System.out.println("Running save method in SignUpRepoImpl...");
        EntityManager manager = this.entityManagerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(signupDto);
            transaction.commit();
        } catch (PersistenceException persistenceException) {
            persistenceException.printStackTrace();
            transaction.rollback();
        } finally {
            manager.close();
        }
        return true;
    }

    //Counting Email Id and Contact Number which Exists in the database(AJAX)
    @Override
    public long countByEmail(String email) {
        System.out.println("Running countByEmail in Repo");
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createQuery("Select s from SignupDto s where s.email=:email");
            query.setParameter("email", email);
            return (long) query.getSingleResult();
        } catch (PersistenceException e) {
            e.printStackTrace();
            return 0;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public long countByPhone(Long phone) {
        System.out.println("Running countByPhone in Repo");
        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createQuery("Select s from SignupDto s where s.phone=:phone");
            query.setParameter("phone", phone);
            return (long) query.getSingleResult();
        } catch (PersistenceException e) {
            e.printStackTrace();
            return 0;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public SignupDto findByEmail(String emailId) {
        EntityManager entityManager= this.entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT s FROM SignupDto s WHERE s.emailId=:email");
            query.setParameter("email", emailId);
            SignupDto result = (SignupDto) query.getSingleResult();
            return result;
        } catch (PersistenceException persistenceException) {
            persistenceException.getStackTrace();

        }
        finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public SignupDto findByPhone(Long contactNumber) {
        EntityManager entityManager= this.entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT s FROM SignupDto s WHERE s.contactNumber=:phone");
            query.setParameter("phone", contactNumber);
            SignupDto result = (SignupDto) query.getSingleResult();
            return result;
        } catch (PersistenceException persistenceException) {
            persistenceException.getStackTrace();
        }
        finally {
            entityManager.close();
        }
        return null;
    }

//    @Override
//    public Optional<SignupDto> findById(int id) {
//        EntityManager entityManager= this.entityManagerFactory.createEntityManager();
//        try {
//            SignupDto signUpDto = entityManager.find(SignupDto.class, id);
//            return Optional.ofNullable(signUpDto);
//        } catch (NoResultException e) {
//            return Optional.empty();
//        }
//    }

}
