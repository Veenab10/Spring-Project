<%@ page  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Index</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script  src="/issueManagement/js/EditProfile.js"></script>

</head>

<body>
<nav class="navbar navbar-dark bg-primary">
            <div class="container-fluid">
            <div class="navbar-header">
            <a class="navbar-brand" style="color:white;" href="index.jsp">Home</a>
            <a class="navbar-brand" style="color:white;" href="SignIn.jsp">SignIn</a>
             <a class="navbar-brand" style="color:white;" href="RaiseComplaint.jsp">RaiseComplaint</a>

            </div>

                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                        <img src="${pageContext.request.contextPath}${sessionScope.profileImage}" alt="Profile" width="50" height="50" class="rounded-circle">
                    </button>

                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuButton1">
                        <li><a class="dropdown-item" href="ResetPassword.jsp">Reset Password</a></li>
                        <li><a class="dropdown-item" href="edit-profile">Edit Profile</a></li>
                        <li><a class="dropdown-item" href="view-profile">View Profile</a></li>
                    </ul>
        </div>
    </nav>

<form action="upload" method="post" enctype="multipart/form-data">

    <div class="d-flex justify-content-center mt-3 mb-3 align-items-center vh-5">
        <div class="card" style="width: 30rem;">
            <div class="card-body">
                <center><h5 class="card-title">Signup Edit Form</h5></center>

                <strong style="color:green"/>${profileMessage}</strong>
                <strong style="color:green"/>${profileError}</strong>
                <strong style="color:red"/>${imageError}</strong>


                <div class="form-group p-3">
                    <label for="firstName">First Name</label>
                    <input type="text" class="form-control" id="firstName" name="firstName" onblur="firstNameValidation()"  placeholder="Enter First Name" value="${signupdto.firstName}">
                    <span id="firstNameError"></span>
                </div>

                <div class="form-group p-3">
                    <label for="lastName">Last Name</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" onblur="lastNameValidation()"  placeholder="Enter Last Name" value="${signupdto.lastName}">
                    <span id="lastNameError"></span>
                </div>

                <div class="form-group p-3">
                    <label for="emailId">Email ID</label>
                    <input type="email" class="form-control" id="emailId" name="emailId"   placeholder="Enter Email ID" value="${signupdto.emailId}" disabled >
                    <span id="emailError" style="color: red;"></span>
                </div>

                <div class="form-group p-3">
                    <label for="contactNumber">Contact Number</label>
                    <input type="text" class="form-control" id="contactNumber" name="contactNumber"  onblur="contactNumberValidation()"  placeholder="Enter Contact Number" value="${signupdto.contactNumber}" >
                    <span id="contactNumberError" style="color:red;"></span>
                </div>

                <div class="form-group p-3">
                    <label for="alternativeContactNumber">Alternative Contact Number</label>
                    <input type="text" class="form-control" id="alternativeContactNumber"  name="alternativeContactNumber" onblur="alternateContactNumberValidation()"   placeholder="Enter Alternative Contact Number" value="${signupdto.alternativeContactNumber}" >
                    <span id="alternativeContactError"></span>
                </div>

                <div class="form-group p-3">
                    <label for="address">Address</label>
                    <textarea class="form-control" placeholder="Enter address here" id="address" onblur="addressValidation()" name="address">${signupdto.address}</textarea>
                    <span id="addressError"></span>
                </div>



                 <div class="form-group p-3">
                         <label for="fileUpload">Upload File</label>
                       <input type="file" class="form-control" id="file" name="file">
                 </div>



                <div class="form-group p-3">
                    <center><input type="submit" class="btn btn-primary" id="submit" name="submit" value="UpdateProfile" ></center>
                </div>
               <center> <a href="SignIn.jsp"/>Existing User?Login Here</a></center>

            </div>
        </div>
    </div>


</form>


</body>
</html>
