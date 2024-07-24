package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.AdminDto;
import com.xworkz.xworkzProject.dto.RaiseComplaintDto;
import com.xworkz.xworkzProject.dto.SignupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Repository
public class AdminRepoImpl implements  AdminRepo {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public AdminRepoImpl() {
        System.out.println("Created AdminRepoImpl");
    }


    @Override
    public AdminDto findByAdminEmailIdAndPassword(String adminEmailId, String adminPassword) {
        System.out.println("Running findByAdminEmailIdAndPassword method in AdminRepoImpl ");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();//Select s from SignupDto s where s.emailId=:emailId and s.password=:password
            String query = "Select a from AdminDto a where a.adminEmailId=:adminEmailId and a.adminPassword=:adminPassword";
            Query query1 = entityManager.createQuery(query);
            query1.setParameter("adminEmailId", adminEmailId);
            query1.setParameter("adminPassword", adminPassword);
            AdminDto adminDto1 = (AdminDto) query1.getSingleResult();
            entityTransaction.commit();
            System.out.println("Dta found in repo" + adminDto1);
            return adminDto1;

        } catch (PersistenceException persistenceException) {
            persistenceException.getStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public List<SignupDto> findByUSerId() {
        System.out.println("findById method in AdminRepoImpl...");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            String query = "SELECT d FROM SignupDto d";
            Query query1= entityManager.createQuery(query);
            List<SignupDto> data = query1.getResultList();
            System.out.println("Data size:" + data.size()); // Print the number of records fetched

            return data;
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        finally {
            entityManager.close();
        }

        return Collections.emptyList();
    }

    @Override
    public List<RaiseComplaintDto> findByUSerComplaintId() {
        System.out.println("findById method in AdminRepoImpl...");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String query = "SELECT r FROM RaiseComplaintDto r JOIN FETCH r.userId";
            Query query1= entityManager.createQuery(query);
            List<RaiseComplaintDto> data = query1.getResultList();
            System.out.println("Data size:" + data.size()); // Print the number of records fetched
            return data;
        }
        catch (Exception e)
        {
            e.printStackTrace();

       }
        finally {
           entityManager.close();
        }


        return Collections.emptyList();
    }

    @Override
    public List<RaiseComplaintDto> findByUserComplaintType(String complaintType) {
        System.out.println("Running findByUserComplaintType method in AdminRepoImpl... ");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String query = "SELECT r FROM RaiseComplaintDto r where r.complaintType=:complaintType";
            Query query1= entityManager.createQuery(query);
            query1.setParameter("complaintType",complaintType);
            List<RaiseComplaintDto> data = query1.getResultList();
            System.out.println("Data size:" + data.size()); // Print the number of records fetched
            return data;
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
        finally {
            entityManager.close();
        }
        return Collections.emptyList();
    }
}


//    @Override
//    public List<SignupDto> findByUSerId(SignupDto signupDto) {
//        System.out.println("Running findByUSerId  method in AdminRepoImpl...");
//        EntityManager entityManager=entityManagerFactory.createEntityManager();
//        try {
//            String query="Select s from SignupDto s";
//            Query query1=entityManager.createQuery(query);
//            List<SignupDto> signupDto1=query1.getResultList();
//            System.out.println("data:"+signupDto1);
//            return signupDto1;
//
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//
//        }
//        finally {
//            entityManager.close();
//        }
//        return Collections.emptyList();
//    }
//}
