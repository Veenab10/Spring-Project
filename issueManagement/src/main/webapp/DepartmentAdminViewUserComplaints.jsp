<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Department Admin View User Complaints</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>

</head>
<body>
<nav class="navbar navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" style="color:white;" href="index.jsp">Home</a>
        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
            <!-- Placeholder for profile image or icon -->
        </button>
        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuButton1">
            <li><a class="dropdown-item" href="AdminProfile.jsp">Admin Profile</a></li>
        </ul>
    </div>
</nav>


    <strong style="color:red;">${successMessage}</strong>
    <strong style="color:red;">${errorMessage}</strong>


    <!-- View of Raised Complaints -->
    <div class="container mt-3 mb-3 align-items-center vh-5">
         <div class="card" style="width: 750%; max-width: 1400px;">

            <div class="card-header">
            <h3><b>User Complaints</b></h3>
        </div>
        <div class="card-body ">
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
                        <th>Assign Employee</th>
                        <th>Submit</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Iterating over the first collection -->
                    <c:forEach var="departmentComplaints" items="${viewDepartmentComplaints}" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${departmentComplaints.complaintId}</td>
                            <td>${departmentComplaints.complaintType}</td>
                            <td>${departmentComplaints.country}</td>
                            <td>${departmentComplaints.state}</td>
                            <td>${departmentComplaints.city}</td>
                            <td>${departmentComplaints.area}</td>
                            <td>${departmentComplaints.address}</td>
                            <td>${departmentComplaints.description}</td>
                            <td>${departmentComplaints.userId.id}</td>

                            <form action="allocate-department" method="post">
                            <td >
                            <div style="width:110px;">

                            <select class="form-select" name="status" id="status">
                            <option selected >${complaint.status}</option>
                            <option value="Pending">Pending</option>
                            <option value="Active">Active</option>
                            <option value="InActive">InActive</option>
                            </select>
                            </div>

                            <td>
                            <div style="width:110px;">
                                       <select class="form-select" name="departmentId" id="departmentId">
                                           <c:forEach var="department" items="${departments}">
                                              <option value="${department.id}">${department.departmentName}</option>
                                           </c:forEach>
                                       </select>
                            </div>

                            </td>
                            <td>
                             <button type="submit" class="btn btn-primary mt-2">submit</button>
                             </td>
                              </form>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
        </div>
    </div>
</div>
</body>
</html>
