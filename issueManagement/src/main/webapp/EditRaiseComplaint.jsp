<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script  src="/issueManagement/js/RaiseComplaint.js"></script>

</head>
<body>

<nav class="navbar navbar-dark bg-primary">
            <div class="container-fluid">
            <div class="navbar-header">
            <a class="navbar-brand" style="color:white;" href="index.jsp">Home</a>
            <a class="navbar-brand" style="color:white;" href="SignIn.jsp">SignIn</a>

            </div>
  </nav>

  <div class="d-flex justify-content-center mt-3 mb-3 align-items-center vh-5">
            <div class="card" style="width: 30rem;">
                <div class="card-body">
                <center><h5 class="card-title">Edit Complaint Form</h5></center>
                <hr>
             <form action="${pageContext.request.contextPath}/update-complaint" method="post">
              <strong style="color:green;">${updateMsg}</strong>
              <strong style="color:red;">${updateError}</strong>
                  <input type="hidden" name="complaintId" value="${raiseComplaintDto.complaintId}"/>

                  <div class="mb-3">
                      <label for="complaintType" class="form-label">Complaint Type</label>
                      <input type="text" class="form-control" id="complaintType" name="complaintType" value="${raiseComplaintDto.complaintType}" readOnly>
                  </div>

                  <div class="mb-3">
                      <label for="country" class="form-label">Country</label>
                      <input type="text" class="form-control" id="country" name="country" value="${raiseComplaintDto.country}" readOnly>
                  </div>

                  <div class="mb-3">
                      <label for="state" class="form-label">State</label>
                      <input type="text" class="form-control" id="state" name="state" value="${raiseComplaintDto.state}" readOnly>
                  </div>

                  <div class="mb-3">
                      <label for="city" class="form-label">City</label>
                      <input type="text" class="form-control" id="city" name="city" value="${raiseComplaintDto.city}" readOnly>
                  </div>

                  <div class="mb-3">
                      <label for="area" class="form-label">Area</label>
                      <input type="text" class="form-control" id="area" name="area" value="${raiseComplaintDto.area}" readOnly>
                  </div>

                  <div class="mb-3">
                      <label for="address" class="form-label">Address</label>
                      <input type="text" class="form-control" id="address" name="address" value="${raiseComplaintDto.address}" readOnly>
                  </div>

                  <div class="mb-3">
                      <label for="description" class="form-label">Description</label>
                      <textarea class="form-control" id="description" name="description" rows="3" required>${raiseComplaintDto.description}</textarea>
                  </div>

                  <button type="submit" class="btn btn-primary">Update</button>
              </form>
          </div>
      </div>
  </div>

  </body>
  </html>
