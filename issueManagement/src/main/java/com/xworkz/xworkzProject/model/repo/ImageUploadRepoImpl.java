
package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.constant.Status;
import com.xworkz.xworkzProject.dto.ImageUploadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public class ImageUploadRepoImpl implements ImageUploadRepo {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    public ImageUploadRepoImpl()
    {
        System.out.println("Created ImageUploadRepoImpl");
    }

    @Override
    @Transactional
    public void saveProfileImage(ImageUploadDto imageUploadDto) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(imageUploadDto);
            entityManager.getTransaction().commit();
            System.out.println("Saved profile image for user: " + imageUploadDto );
        } catch (Exception e) {
            //log.error("Error saving profile image", e);
            System.out.println("Error saving profile image"+e);
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Optional<ImageUploadDto> findByUserId(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<ImageUploadDto> query = entityManager.createQuery(
                    "SELECT i FROM ImageUploadDto i WHERE i.id = :id", ImageUploadDto.class);
            query.setParameter("id", id);
            return query.getResultList().stream().findFirst();
        } finally {
            entityManager.close();
        }
    }

    @Override
    @Transactional
    public void setAllImagesInactiveForUser(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();

            String query = "UPDATE ImageUploadDto i SET i.status = :status WHERE i.signupDto.id = :userId";
            Query updateQuery = entityManager.createQuery(query);
            updateQuery.setParameter("status", Status.INACTIVE);
            updateQuery.setParameter("userId", id);
            int updatedCount = updateQuery.executeUpdate();

            System.out.println("Number of images set inactive: " + updatedCount);

            entityTransaction.commit();
        } catch (Exception e) {
            System.out.println("Error setting images inactive for user with ID " + id + ": " + e.getMessage());
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
        } finally {
            entityManager.close();
        }
    }
}





