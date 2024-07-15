package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.SignupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class EditUserProfileRepoImpl implements EditUserProfileRepo {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public EditUserProfileRepoImpl()
    {
        System.out.println("Created EditUserProfileRepoImpl");
    }

    @Override
    public SignupDto findByEmailId(String emailId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            String query = "SELECT s FROM SignupDto s WHERE s.emailId = :emailId";
            TypedQuery<SignupDto> typedQuery = entityManager.createQuery(query, SignupDto.class);
            typedQuery.setParameter("emailId", emailId);

            // Use getResultList() instead of getSingleResult()
            List<SignupDto> results = typedQuery.getResultList();

            if (results.isEmpty()) {
                return null; // Or throw an exception as per your application's logic
            } else {
                return results.get(0); // Return the first (and only) result
            }

        } catch (NoResultException e) {
            // Handle the case where no entity is found
            e.printStackTrace();
            transaction.rollback();
            return null; // Or throw an exception
        } catch (PersistenceException e) {
            e.printStackTrace();
            transaction.rollback();
            return null; // Or throw an exception
        } finally {
            entityManager.close();
        }
    }


//    @Override
//    public SignupDto findByEmailId(String emailId) {
//        System.out.println("running findById method in EditUserProfileRepoImpl.. ");
//        EntityManager entityManager=entityManagerFactory.createEntityManager();
//        EntityTransaction transaction=entityManager.getTransaction();
//        transaction.begin();
//
//        try{
//            String query="select s  from SignupDto s  where s.emailId=:emailId";
//            Query query1=entityManager.createQuery(query);
//            query1.setParameter("emailId",emailId);
//            SignupDto  singleResult= (SignupDto) query1.getSingleResult();
//            transaction.commit();
//            return singleResult;
//        }
//
//        catch (PersistenceException persistenceException)
//        {
//            persistenceException.printStackTrace();
//            transaction.rollback();
//        }
//        finally {
//            entityManager.close();
//        }
//        return EditUserProfileRepo.super.findByEmailId(emailId);
//    }

    @Override
    public SignupDto updateSignupDtoByEmailId(SignupDto updatedUserDetails) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {
            // Retrieve the existing user
            SignupDto existingUser = findByEmailId(updatedUserDetails.getEmailId());
            if (existingUser != null) {
                // Update the user details
                existingUser.setFirstName(updatedUserDetails.getFirstName());
                existingUser.setLastName(updatedUserDetails.getLastName());
                existingUser.setContactNumber(updatedUserDetails.getContactNumber());
                existingUser.setAlternativeContactNumber(updatedUserDetails.getAlternativeContactNumber());
                existingUser.setAddress(updatedUserDetails.getAddress());
                existingUser.setImageName(updatedUserDetails.getImageName());
                existingUser.setUpdatedBy(updatedUserDetails.getUpdatedBy());
                existingUser.setUpdatedOn(updatedUserDetails.getUpdatedOn());
                //existingUser.setAgree(updatedUserDetails.getAgree());

                // Persist the changes
                entityManager.merge(existingUser);
                entityTransaction.commit();
                return existingUser;
            } else {
                return null; // User not found
            }
        } catch (PersistenceException persistenceException) {
            persistenceException.printStackTrace();
            entityTransaction.rollback();
            return null;
        } finally {
            entityManager.close();
        }
    }

}






