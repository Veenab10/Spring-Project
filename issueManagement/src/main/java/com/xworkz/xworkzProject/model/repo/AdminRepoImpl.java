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
    public List<RaiseComplaintDto> searchByUserComplaintTypeAndCity(String complaintType,String city) {
        System.out.println("Running searchByUserComplaintTypeAndCity method in AdminRepoImpl..");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String query = "SELECT r FROM RaiseComplaintDto r where r.city=:city And r.complaintType=:complaintTypes";
            Query query1= entityManager.createQuery(query);
            query1.setParameter("complaintTypes",complaintType);
            query1.setParameter("city",city);
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
    public List<RaiseComplaintDto> searchByUserComplaintTypeOrCity(String complaintType, String city) {
        System.out.println("Running searchByUserComplaintTypeOrCity method in AdminRepoImpl..");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String query = "SELECT r FROM RaiseComplaintDto r where r.city=:city OR r.complaintType=:complaintTypes";
            Query query1= entityManager.createQuery(query);
            query1.setParameter("complaintTypes",complaintType);
            query1.setParameter("city",city);
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


