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
                 <center> <h3><b>View USer Profile</b></h3> </center>
              </div>
              <div class="card-body">
                  <table class="table table-bordered">
                      <thead>
                          <tr>
                              <th>Serial Number</th>
                              <th>User ID</th>
                              <th>First Name </th>
                              <th>Last Name</th>
                              <th>EmailID</th>
                              <th>Contact Number</th>
                              <th>Alternative Contact Number</th>
                              <th>Address</th>

                          </tr>
                      </thead>
                      <tbody>
                          <c:forEach var="viewUser" items="${ViewUserDetails}" varStatus="status">
                              <tr>
                                  <td>${status.index + 1 }</td>
                                  <td>${viewUser.id}</td>
                                  <td>${viewUser.firstName}</td>
                                  <td>${viewUser.lastName}</td>
                                  <td>${viewUser.emailId}</td>
                                  <td>${viewUser.contactNumber}</td>
                                  <td>${viewUser.alternativeContactNumber}</td>
                                  <td>${viewUser.address}</td>
                              </tr>
                          </c:forEach>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>


      </body>
      </html>