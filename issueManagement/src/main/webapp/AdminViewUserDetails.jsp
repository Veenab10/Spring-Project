<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Profile View</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

</head>
<body>
     <nav class="navbar navbar-dark bg-primary">
                 <div class="container-fluid">
                     <div class="navbar-header">
                 <a class="navbar-brand" style="color:white;" href="index.jsp">Home</a>

                 </div>

         <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
              <img src="${pageContext.request.contextPath}${sessionScope.profileImage}" alt="Profile" width="80" height="80" class="rounded-circle">
         </button>

        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuButton1">
                <li><a class="dropdown-item" href="AdminProfile.jsp">AdminProfile</a></li>
        </ul>


  </nav>

  <div class="container mt-5 mb-5">
          <div class="card">
              <div class="card-header">
                  <h3><b>View USer Profile</b></h3>
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