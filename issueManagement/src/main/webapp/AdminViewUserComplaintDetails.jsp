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
        </button>

        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuButton1">
            <li><a class="dropdown-item" href="view-user-details">Users Profile</a></li>
            <li><a class="dropdown-item" href="departmentAdmin-view-user-complaints">View User Complaints</a></li>
            <li><a class="dropdown-item" href="view-department-list">Add Employees</a></li>
            <li><a class="dropdown-item" href="DepartmentAdminResetPassword.jsp">Reset Password</a></li>
        </ul>
    </div>
</nav>

<!-- Display Success Message -->
<c:if test="${not empty successMessage}">
    <div class="alert alert-success" role="alert">
        ${successMessage}
    </div>
</c:if>

<!-- Display Error Message -->
<c:if test="${not empty errorMessage}">
    <div class="alert alert-danger" role="alert">
        ${errorMessage}
    </div>
</c:if>

<div class="container mt-5 mb-5">
    <!-- Search Form for Complaints -->
    <form action="search-user-complaints" method="post">
        <div class="row mb-3">
            <label for="complaintType" class="form-label">Complaint Type:</label>
            <select class="form-select" id="complaintType" name="complaintType">
                <option value="">Select Complaint Type</option>
                <option value="Water Supply">Water Supply</option>
                <option value="System Problem">System Problem</option>
                <option value="Network Problem">Network Problem</option>
                <option value="Electrical Problem">Electrical Problem</option>
                <option value="Noise Problem">Noise Problem</option>
            </select>
        </div>
        <div class="row mb-3">

            <label for="city" class="form-label">City Name:</label>
            <input type="text" id="city" name="city" class="form-control" placeholder="Enter City Name">
        </div>
        <div class="row mb-3">
            <div class="col">
                <button type="submit" class="btn btn-primary">Search</button>
            </div>
        </div>
    </form>


<!-- View of Raised Complaints -->
<div class="d-flex justify-content-center mt-3 mb-2 align-items-center vh-80">
    <div class="card highlight-card">
        <div class="card-body">
            <h3><b><center>DeptAdminComplaintView</center></b></h3>
            <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Serial Number</th>
                                                                <th>ID</th>
                                                                <th>Complaint Type</th>
                                                                <th>Country</th>
                                                                <th>State</th>
                                                                <th>City</th>
                                                                <th>Area</th>
                                                                <th>Address</th>
                                                                <th>Description</th>
                                                                <th>User ID</th>
                                                                <th>Status</th>
                                                                <th>Department Allocation</th>
                                                                <th>Submit</th>

                                </tr>
                            </thead>

                <tbody>
            <c:forEach var="complaint" items="${viewRaiseComplaints}" varStatus="status">
                            <form action="allocate-department" method="post" class="d-inline-block">
                                <tr>
                                    <td>${status.index + 1}</td>
                                    <td>${complaint.complaintId}</td>
                                    <td>${complaint.complaintType}</td>
                                    <td>${complaint.country}</td>
                                    <td>${complaint.state}</td>
                                    <td>${complaint.city}</td>
                                    <td>${complaint.area}</td>
                                    <td>${complaint.address}</td>
                                    <td>${complaint.description}</td>
                                    <td>${complaint.userId.id}</td>
                                    <td>
                                        <select class="form-select" name="status" id="status">
                                            <option selected>${complaint.status}</option>
                                            <option value="Inprogress">Inprogress</option>
                                            <option value="Completed">Completed</option>
                                            <option value="Incompleted">Incompleted</option>
                                        </select>
                                    </td>
                                    <td>
                                        <select class="form-select" name="departmentId" id="departmentId">
                                            <c:forEach var="department" items="${departments}">
                                                <option value="${department.id}">${department.departmentName}</option>
                                            </c:forEach>
      </select>
                                    </td>
                                    <td>
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>