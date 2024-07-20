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
                             <li><a class="dropdown-item" href="ResetPassword.jsp">Reset Password</a></li>
                             <li><a class="dropdown-item" href="edit-profile">Edit Profile</a></li>
                             <li><a class="dropdown-item" href="view-profile">View Profile</a></li>
                              <li><a class="dropdown-item" href="view-complaint">view-complaint</a></li>
                         </ul>
             </div>
         </nav>

    <div class="d-flex justify-content-center mt-3 mb-3 align-items-center vh-5">
            <div class="card" style="width: 60rem;">
                <div class="card-body">
                <table class="table">
                  <thead>
                    <tr>
                      <th scope="col">complaintId</th>
                      <th scope="col">complaintType </th>
                      <th scope="col">country </th>
                      <th scope="col">state</th>
                      <th scope="col">city</th>
                      <th scope="col">area</th>
                      <th scope="col">address</th>
                      <th scope="col">description</th>
                    </tr>
                  </thead>
                  <tbody>

                              <tr>
                              <td>${raiseComplaintDto.complaintId}</td>
                              <td>${raiseComplaintDto.complaintType}</td>
                              <td>${raiseComplaintDto.country}</td>
                              <td>${raiseComplaintDto.state}</td>
                              <td>${raiseComplaintDto.city}</td>
                              <td>${raiseComplaintDto.area}</td>
                              <td>${raiseComplaintDto.address}</td>
                              <td>${raiseComplaintDto.description}</td>
                             <td><a href="view-complaint?complaintId=${raiseComplaintDto.complaintId}">Edit</a></td>
                              </tr>


                  </tbody>
                </table>

            </div>
        </div>
    </div>
</body>
</html>