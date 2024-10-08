package com.xworkz.xworkzProject.model.repo;

import com.xworkz.xworkzProject.dto.*;
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
            Query query1 = entityManager.createQuery(query);
            List<SignupDto> data = query1.getResultList();
            System.out.println("Data size:" + data.size()); // Print the number of records fetched

            return data;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            entityManager.close();
        }

        return Collections.emptyList();
    }

    @Override
    public List<RaiseComplaintDto> findByUSerComplaintId() {
        System.out.println("findById method in AdminRepoImpl...");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String query = "SELECT r FROM RaiseComplaintDto r JOIN FETCH r.userId ORDER BY r.complaintId DESC";
            Query query1 = entityManager.createQuery(query);
            List<RaiseComplaintDto> data = query1.getResultList();
            System.out.println("Data size:" + data.size()); // Print the number of records fetched
            return data;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            entityManager.close();
        }

        return Collections.emptyList();
    }

    @Override
    public List<RaiseComplaintDto> searchByUserComplaintTypeAndCity(String complaintType, String city) {
        System.out.println("Running searchByUserComplaintTypeAndCity method in AdminRepoImpl..");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String query = "SELECT r FROM RaiseComplaintDto r WHERE r.city = :city AND r.complaintType = :complaintType ORDER BY r.complaintId DESC";
            Query query1 = entityManager.createQuery(query);
            query1.setParameter("complaintTypes", complaintType);
            query1.setParameter("city", city);
            List<RaiseComplaintDto> data = query1.getResultList();
            System.out.println("Data size:" + data.size()); // Print the number of records fetched
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
            Query query1 = entityManager.createQuery(query);
            query1.setParameter("complaintTypes", complaintType);
            query1.setParameter("city", city);
            List<RaiseComplaintDto> data = query1.getResultList();
            System.out.println("Data size:" + data.size()); // Print the number of records fetched
            return data;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            entityManager.close();
        }
        return Collections.emptyList();
    }

    @Override
    public boolean saveDepartment(DepartmentDto departmentDto) {
        System.out.println("Running saveDepartment method AdminRepoImpl.. ");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(departmentDto);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return true;
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
    public void allocateDepartment(Long complaintId, Long departmentId, String status) {
        System.out.println("Running allocateDepartment method in AdminRepoImpl...");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();

            // Find the complaint
            RaiseComplaintDto complaint = entityManager.find(RaiseComplaintDto.class, complaintId);
            if (complaint == null) {
                throw new RuntimeException("Complaint not found for ID: " + complaintId);
            }
            System.out.println("Found complaint: " + complaint);

            // Find the department
            DepartmentDto department = entityManager.find(DepartmentDto.class, departmentId);
            if (department == null) {
                throw new RuntimeException("Department not found for ID: " + departmentId);
            }
            System.out.println("Found department: " + department);

            // Set the department for the complaint
            complaint.setDepartment(department);
            complaint.setStatus(status);

            // Merge the updated complaint
            complaint = entityManager.merge(complaint);
            System.out.println("Updated complaint after merge: " + complaint);

            entityTransaction.commit();
            System.out.println("Department allocated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
        } finally {
            entityManager.close();
        }
    }


    //here im saving departments admin data
    @Override
    public boolean saveDepartmentAdmin(DepartmentAdminDto departmentAdminDto) {
        System.out.println("Running saveDepartmentAdmin in AdminRepoImpl...");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.persist(departmentAdminDto); // Use persist for new entities
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

//    @Override
//    public void viewDepartmentList(Long departmentId, Long departmentAdminId) {
//        System.out.println("Running viewDepartmentList method in AdminServiceImpl...");
//
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//
//        try {
//            entityTransaction.begin();
//
//            // Find the DepartmentAdmin entity
//            DepartmentAdminDto departmentAdmin = entityManager.find(DepartmentAdminDto.class, departmentAdminId);
//            if (departmentAdmin == null) {
//                throw new RuntimeException("DepartmentAdmin not found for ID: " + departmentAdminId);
//            }
//            System.out.println("Found DepartmentAdmin: " + departmentAdminId);
//
//            // Find the Department entity
//            DepartmentDto department = entityManager.find(DepartmentDto.class, departmentId);
//            if (department == null) {
//                throw new RuntimeException("Department not found for ID: " + departmentId);
//            }
//            System.out.println("Found Department: " + department);
//
//            // Set the department for the DepartmentAdmin
//            departmentAdmin.setDepartment(department);
//
//            // Merge the updated DepartmentAdmin
//            entityManager.merge(departmentAdmin);
//            System.out.println("Updated DepartmentAdmin after merge: " + departmentAdmin);
//
//            entityTransaction.commit();
//            System.out.println("Department allocated successfully.");
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (entityTransaction.isActive()) {
//                entityTransaction.rollback();
//            }
//        } finally {
//            entityManager.close();
//        }
//    }

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
    public DepartmentAdminDto findByEmailId(String email) {
        System.out.println("Running findByEmailId method... ");
        EntityManager entityManager =entityManagerFactory.createEntityManager();
        try {
            Query query =entityManager.createQuery("Select s from DepartmentAdminDto s where s.departmentAdminEmailId=:email");
            query.setParameter("email",email);
            DepartmentAdminDto departmentAdminDto= (DepartmentAdminDto) query.getSingleResult();
            return departmentAdminDto;
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
    public DepartmentAdminDto findByEmailPasswordAndDepartmentType(String emailId, String password,String departmentType) {
        System.out.println("Running findByEmailIdAndPassword method... ");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT s FROM DepartmentAdminDto s WHERE s.departmentAdminEmailId = :emailId AND s.departmentAdminPassword = :password And s.departmentType=:departmentType");
            query.setParameter("emailId", emailId);
            query.setParameter("password", password);
            query.setParameter("departmentType",departmentType);
            DepartmentAdminDto departmentAdminDto = (DepartmentAdminDto) query.getSingleResult();
            return departmentAdminDto;
        } catch (NoResultException e) {
            System.out.println("No result found for email: " + emailId + " with the given password" + "given departmentType:"+departmentType);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }


    @Override
    public boolean updateDepartmentAdminDetails(DepartmentAdminDto departmentAdminDto) {
        System.out.println("Running updateDepartmentAdminPassword method AdminRepoImpl...");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(departmentAdminDto);
            transaction.commit();
            return true;
        }
        catch (PersistenceException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        finally {
            entityManager.close();
        }
    }

    //to view particulart department complaints by department admin

    @Override
    public List<RaiseComplaintDto> findByUSerComplaintType(String complaintType) {
        System.out.println("findById method in AdminRepoImpl...");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String query = "SELECT r FROM RaiseComplaintDto r where r.complaintType=:complaintType";
            Query query1 = entityManager.createQuery(query);
            query1.setParameter("complaintType",complaintType);
            List<RaiseComplaintDto> data = query1.getResultList();
            System.out.println("Data size:" + data.size()); // Print the number of records fetched
            return data;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            entityManager.close();
        }

        return Collections.emptyList();
    }

    @Override
    public List<EmployeeDto> getAllEmployeeDetails() {
        System.out.println("Running getAllEmployeeDetails method in admin repo implementation...");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String query = "SELECT e FROM EmployeeDto e";
            Query query1 = entityManager.createQuery(query);
            List<EmployeeDto> resultList = query1.getResultList();
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
    public void allocateEmployee(Long complaintId, int employeeId, String status) {
        System.out.println("Running allocateEmployee method in AdminRepoImpl...");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();

            // Find the complaint
            RaiseComplaintDto complaint = entityManager.find(RaiseComplaintDto.class, complaintId);
            if (complaint == null) {
                throw new RuntimeException("Complaint not found for ID: " + complaintId);
            }
            System.out.println("Found complaint: " + complaint);

            // Find the department
            EmployeeDto employee = entityManager.find(EmployeeDto.class, employeeId);
            if (employee == null) {
                throw new RuntimeException("Department not found for ID: " + employeeId);
            }
            employee.setStatus(status);
            System.out.println("Found department: " + employee);

            // Set the department for the complaint
            //complaint.setDepartment(department);
            //complaint.setStatus(status);
            complaint.setEmployeeId(employee);

            // Merge the updated complaint
            complaint = entityManager.merge(complaint);
            System.out.println("Updated complaint after merge: " + complaint);

            entityTransaction.commit();
            System.out.println("Department allocated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
        } finally {
            entityManager.close();
        }

    }


}






