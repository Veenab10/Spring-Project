<%@ page  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Index</title>
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

                         <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                             <img src="${pageContext.request.contextPath}${sessionScope.profileImage}" alt="Profile" width="80" height="80" class="rounded-circle">
                         </button>

                         <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuButton1">
                             <li><a class="dropdown-item" href="ResetPassword.jsp">Reset Password</a></li>
                             <li><a class="dropdown-item" href="edit-profile">Edit Profile</a></li>
                             <li><a class="dropdown-item" href="view-profile">View Profile</a></li>
                              <li><a class="dropdown-item" href="view-complaint">view-complaint</a></li>
                              <li><a class="dropdown-item" href="RaiseComplaint.jsp">RaiseComplaint</a></li>
                         </ul>
             </div>
         </nav>

<form action="search-user-complaints" method="post">

<div class="d-flex justify-content-center mt-3 mb-2 align-items-center vh-80">
<div class="card" style="width: 50rem;">
  <div class="card-body">
   <center> <h5 class="card-title">Search RaiseComplaint Form</h5></center>
    <div class="row mb-3">
         <span id="countryNameError"></span>
             <label for="countryName" class="form-label">Complaint Type:</label>
                <select class="form-select custom-select-width" id="complaintType" name="complaintType"  placeholder="Complaint Type">
                       <option ${dto.complaintType==null ? 'selected' : ''}  selected value=" "></option>
                        <option value="Water Supply" ${dto.complaintType eq 'Water Supply' ? 'selected' : ''}>Water Supply</option>
                         <option value="System Problem"  ${dto.complaintType eq 'System Problem' ? 'selected' : ''}>System Problem</option>
                         <option value="Network Problem"  ${dto.complaintType eq 'Network Problem' ? 'selected' : ''}>Network Problem</option>
                         <option value="Electrical Problem"  ${dto.complaintType eq 'Electrical Problem' ? 'selected' : ''}>Electrical Problem</option>
                         <option value="Noise Problem"  ${dto.complaintType eq 'GMIT' ? 'selected' : ''}>Noise Problem</option>
                </select>
                </div>

         <!----City ---!>

         <div class="row mb-3">
                     <label for="city" class="form-label">City Name:</label>
                     <input type="text" id="city" name="city" placeholder="Enter city Name">
          </div>

      <div>
      <center><button type="submit" class="btn btn-primary">Submit</button><center>
      </div>

  </div>
</div>
</div>

</form>

<div class="d-flex justify-content-center mt-3 mb-2 align-items-center vh-80">
<div class="card" >
  <div class="card-body">
    <strong style="color:green;">Search result for , ${complaintType}</strong>
<table class="table">
  <thead>
    <tr>
      <th scope="col">Serial Number</th>
      <th scope="col">ID </th>
      <th scope="col">Complaint Type</th>
      <th scope="col">Country</th>
      <th scope="col">State</th>
      <th scope="col">City</th>
      <th scope="col">Area</th>
      <th scope="col">Address</th>
      <th scope="col">Description</th>

    </tr>
  </thead>
  <tbody>
       <c:forEach items="${listOfComplaintType}" var="searchRaiseComplaint" varStatus="status">
              <tr>
              <td>${status.index + 1 }</td>
                  <td>${searchRaiseComplaint.complaintId}</td>
                   <td>${searchRaiseComplaint.complaintType}</td>
                    <td>${searchRaiseComplaint.country}</td>
                    <td>${searchRaiseComplaint.state}</td>
                     <td>${searchRaiseComplaint.city}</td>
                     <td>${searchRaiseComplaint.area}</td>
                     <td>${searchRaiseComplaint.address}</td>
                     <td>${searchRaiseComplaint.description}</td>

              </tr>
       </c:forEach>

  </tbody>
</table>

</body>
</html>

