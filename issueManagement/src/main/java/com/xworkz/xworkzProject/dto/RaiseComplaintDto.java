package com.xworkz.xworkzProject.dto;

import javax.persistence.*;

@Entity
@Table(name = "complaint_types")
public class RaiseComplaintDto {

    public RaiseComplaintDto()
    {
        System.out.println("Created RaiseComplaintDto");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complaint_id")
    private  Long complaintId;

    @Column(name = "complaint_type")
    private String complaintType;

    @Column(name = "country")
    private  String country;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "area")
    private String area;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    public Long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @ManyToOne(fetch = FetchType.LAZY) // Example mapping assuming many images to one signup
    @JoinColumn(name = "id", referencedColumnName = "id") // Adjust as per your schema
    private SignupDto userId;

    public SignupDto getUserId() {
        return userId;
    }

    public void setUserId(SignupDto userId)
    {
        this.userId = userId;
    }

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentDto department;

    public DepartmentDto getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDto department) {
        this.department = department;
    }

    @Column(name = "status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeDto employeeId;

    public EmployeeDto getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(EmployeeDto employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "RaiseComplaintDto{" +
                "complaintId=" + complaintId +
                ", complaintType='" + complaintType + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                ", department=" + department +
                ", status='" + status + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }
}
