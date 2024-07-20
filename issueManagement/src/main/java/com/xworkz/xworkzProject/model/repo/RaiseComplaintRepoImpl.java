package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.ImageUploadDto;
import com.xworkz.xworkzProject.dto.RaiseComplaintDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public class RaiseComplaintRepoImpl implements RaiseComplaintRepo {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public RaiseComplaintRepoImpl() {
        System.out.println("Created RaiseComplaintRepoImpl");
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

    @Override
    public RaiseComplaintDto findByComplaintId(int complaintId) {
        System.out.println("Running findByComplaintId method in RaiseComplaintRepoImpl");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        String query="Select c from RaiseComplaintDto c where c.complaintId=: complaintId";
        Query query1=entityManager.createQuery(query);
        query1.setParameter("complaintId",complaintId);
        RaiseComplaintDto raiseComplaintDto= (RaiseComplaintDto) query1.getSingleResult();
        return raiseComplaintDto;
    }
}



