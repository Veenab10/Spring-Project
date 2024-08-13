package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.DepartmentAdminDto;
import com.xworkz.xworkzProject.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

@Repository
public class EmployeeRepoImpl implements  EmployeeRepo {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public EmployeeRepoImpl()
    {
        System.out.println("Created EmployeeRepoImpl");
    }

    @Override
    public boolean saveEmployeeDtails(EmployeeDto employeeDto) {
        System.out.println("Running saveDepartmentAdmin in EmployeeRepoImpl...");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.persist(employeeDto); // Use persist for new entities
            entityTransaction.commit();
            return true;
        } catch (PersistenceException e) {
            entityTransaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }
}
