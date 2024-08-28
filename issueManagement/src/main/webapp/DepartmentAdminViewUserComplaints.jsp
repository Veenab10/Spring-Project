<%@ page isELIgnored="false"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

</head>
<body>

<nav class="navbar navbar-dark bg-primary">
            <div class="container-fluid">
            <div class="navbar-header">
            <a class="navbar-brand" style="color:white;" href="index.jsp">Home</a>
            </div>
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">Admin
                     <!---   <img src="${pageContext.request.contextPath}${sessionScope.profileImage}" alt="Profile" width="50" height="50" class="rounded-circle">---!>
                    </button>

                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuButton1">
                        <li><a class="dropdown-item" href="view-user-details">Users Profile </a></li>
                        <li><a class="dropdown-item" href="departmentAdmin-view-user-complaints">View User Complaints</a></li>
                        <li><a class="dropdown-item" href="view-department-list">AddEmployees</a></li>
                         <li><a class="dropdown-item" href="DepartmentAdminResetPassword.jsp">ResetPassword</a></li>


                    </ul>
        </div>
    </nav>

<!-- Display Success Message -->
<c:if test="${not empty successMessage}">
    <div class="alert alert-success" role="alert">
        ${successMessage}
    </div>
</c:if>

<!-- View of Raised Complaints -->
<div class="d-flex justify-content-center mt-3 mb-2 align-items-center vh-80">
    <div class="card highlight-card">
        <div class="card-body">
            <h3><b><center>DeptAdminComplaintView</center></b></h3>
            <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Serial Number</th>
                                    <th>Complaint ID</th>
                                    <th>Complaint Type</th>
                                    <th>Country</th>
                                    <th>State</th>
                                    <th>City</th>
                                    <th>Area</th>
                                    <th>Address</th>
                                    <th>Description</th>
                                    <th>User ID</th>
                                    <th>Status</th>
                                    <th>Assign Employee</th>
                                    <th>Submit</th>
                                </tr>
                            </thead>

                                    <c:forEach var="departmentComplaint" items="${viewDepartmentComplaints}" varStatus="status">
                                        <tr>
                                            <td>${status.index + 1}</td>
                                            <td>${departmentComplaint.complaintId}</td>
                                            <td>${departmentComplaint.complaintType}</td>
                                            <td>${departmentComplaint.country}</td>
                                            <td>${departmentComplaint.state}</td>
                                            <td>${departmentComplaint.city}</td>
                                            <td>${departmentComplaint.area}</td>
                                            <td>${departmentComplaint.address}</td>
                                            <td>${departmentComplaint.description}</td>
                                            <td>${departmentComplaint.userId.id}</td>

                                    <form action="allocate-employee" method="post">
                                    <td>
                                    <input type="hidden" name="complaintId" value="${departmentComplaint.complaintId}" id="complaintId">

                                    <select class="form-select" name="status" id="status">
                                        <option selected>${departmentComplaint.status}</option>
                                        <option value="Completed">Completed</option>
                                        <option value="Inprogress">Inprogress</option>
                                        <option value="Incompleted">Incompleted</option>
                                    </select>
                                </td>

                                <td>
                                    <div style="width:110px;">
                                        <select class="form-select" name="employeeId" id="employeeId">
                                            <c:forEach var="employee" items="${employeeNames}">
                                                <option value="${employee.employeeId}"
                                                    <c:if test="${employee.employeeId == employee.employeeId}">
                                                        selected
                                                    </c:if>>
                                                    ${employee.employeeName}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </td>

                                <td>
                                    <button type="submit" class="btn btn-primary mt-2"
                                        <c:if test="${not empty departmentComplaint.employeeId}">
                                            disabled
                                        </c:if>>
                                        Submit
                                    </button>
                                </td>
                            </form>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>