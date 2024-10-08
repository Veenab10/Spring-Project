package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.DepartmentDto;
import com.xworkz.xworkzProject.dto.RaiseComplaintDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

//import static com.xworkz.xworkzProject.controller.SignInController.log;

@Repository
public class RaiseComplaintRepoImpl implements RaiseComplaintRepo {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public RaiseComplaintRepoImpl() {
        System.out.println("Created RaiseComplaintRepoImpl");
    }


    @Override
    public List<DepartmentDto> getAllDepartments() {
        System.out.println("Running getAllDepartments method in admin repo implementation...");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String query = "SELECT d FROM DepartmentDto d";
            Query query1 = entityManager.createQuery(query);
            List<DepartmentDto> resultList = query1.getResultList();
            System.out.println("ResultList size: " + resultList.size());
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return Collections.emptyList();
    }

    @Override
    public DepartmentDto searchByDepartmentName(String departmentName) {
        System.out.println("Running searchByDepartmentType method in AdminRepoImpl... ");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        try {
            String query = "Select d from  DepartmentDto d where d.departmentName=:departmentName";
            Query result = entityManager.createQuery(query);
            result.setParameter("departmentName", departmentName);
            DepartmentDto departmentDto = (DepartmentDto) result.getSingleResult();
            return departmentDto;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            entityManager.close();
        }

        return null;
    }

    @Override
    public boolean saveRaiseComplaintType(RaiseComplaintDto raiseComplaintDto) {
        System.out.println("Running saveRaiseComplaintType method in RaiseComplaintRepoImpl ");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(raiseComplaintDto);
            entityTransaction.commit();
        } catch (PersistenceException persistenceException) {

            persistenceException.getStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }
        return true;
    }

    @Override
    public Optional<RaiseComplaintDto> findByUserId(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<RaiseComplaintDto> query = entityManager.createQuery(
                    "SELECT i FROM RaiseComplaintDto i WHERE i.id = :id", RaiseComplaintDto.class);
            query.setParameter("id", id);
            return query.getResultList().stream().findFirst();
        } finally {
            entityManager.close();
        }
    }

    //to view RaiseComplaint data
    @Override
    public List<RaiseComplaintDto> findByRaiseComplaint(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            // Correct JPQL query with proper ordering
            TypedQuery<RaiseComplaintDto> query = entityManager.createQuery(
                    "SELECT r FROM RaiseComplaintDto r WHERE r.userId.id = :userId ORDER BY r.complaintId DESC",
                    RaiseComplaintDto.class);
            query.setParameter("userId", id);

            // Execute the query and get the results
            List<RaiseComplaintDto> results = query.getResultList();

            // Optionally log the results size
            // log.info("Found {} complaints for user ID {}", results.size(), id);

            return results;
        } finally {
            // Ensure the EntityManager is closed
            entityManager.close();
        }
    }

    //edit

    @Override
    public Optional<RaiseComplaintDto> findByComplaintId(Long complaintId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<RaiseComplaintDto> query = entityManager.createQuery(
                    "SELECT r FROM RaiseComplaintDto r WHERE r.complaintId = :complaintId", RaiseComplaintDto.class);
            query.setParameter("complaintId", complaintId);
            return query.getResultList().stream().findFirst();
        } finally {
            entityManager.close();
        }
    }

    //update

    @Override
    public RaiseComplaintDto updateRaiseComplaintUserDetails(RaiseComplaintDto raiseComplaintDto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try
        {
            entityTransaction.begin();
            entityManager.merge(raiseComplaintDto);
            entityTransaction.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            entityTransaction.rollback();
        }
        finally {
            entityManager.close();
            //log.info("updateRaiseComplaintUserDetails connection closed");
        }

        return raiseComplaintDto;
    }




}



