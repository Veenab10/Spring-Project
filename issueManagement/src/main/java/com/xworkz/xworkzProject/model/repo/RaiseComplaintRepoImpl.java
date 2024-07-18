package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.RaiseComplaintDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

@Repository
public class RaiseComplaintRepoImpl implements RaiseComplaintRepo {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public RaiseComplaintRepoImpl()
    {
        System.out.println("Created RaiseComplaintRepoImpl");
    }

    @Override
        public boolean saveRaiseComplaintType(RaiseComplaintDto raiseComplaintDto) {
        System.out.println("Running saveRaiseComplaintType method in RaiseComplaintRepoImpl ");
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction =entityManager.getTransaction();
        try{
            entityTransaction.begin();
            entityManager.persist(raiseComplaintDto);
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
