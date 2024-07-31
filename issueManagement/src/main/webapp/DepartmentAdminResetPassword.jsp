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

                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">Admin
                     <!---   <img src="${pageContext.request.contextPath}${sessionScope.profileImage}" alt="Profile" width="80" height="80" class="rounded-circle"> ---!>
                    </button>

                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuButton1">
                        <li><a class="dropdown-item" href="AdminProfile.jsp">Admin Profile</a></li>

                    </ul>
        </div>
    </nav>
<form action="admin-reset-password" method="post">

    <div class="d-flex justify-content-center mt-3 mb-3 align-items-center vh-5">
        <div class="card" style="width: 30rem;">
            <div class="card-body">
                <center><h5 class="card-title">Reset Password Form</h5></center>
                <strong style="color:green"/>${passwordResetMessage}</strong>
                <strong style="color:red"/>${passwordResetError}</strong>

            <div class="form-group p-3">
                                <label for="emailId">Email ID</label>
                                <input type="email" class="form-control" id="departmentAdminEmailId" name="departmentAdminEmailId"    placeholder="Enter Email ID" >
                                <span id="emailError" style="color: red;"></span>
                            </div>

                <div class="p-3">
                      <label for="exampleInputPassword1" class="form-label">Enter Old Password</label>
                      <input type="password" class="form-control" placeholder="Enter old password" id="oldPassword" name="oldPassword"  >
                      <span id="passwordError" style="color:red;"></span>
                       </div>

                <div class="p-3">
                          <label for="exampleInputPassword1" class="form-label">Enter New Password</label>
                          <input type="password" class="form-control" placeholder="Enter new  password" id="newPassword" name="newPassword"  >
                          <span id="passwordError" style="color:red;"></span>
                        </div>

                <div class="p-3">
                          <label for="exampleInputPassword1" class="form-label">Enter Confirm Password</label>
                          <input type="password" class="form-control" placeholder="Enter new  password" id="confirmPassword" name="confirmPassword"  >
                          <span id="passwordError" style="color:red;"></span>
                          </div>


                <div class="form-group p-3">
                    <center><input type="submit" class="btn btn-primary" id="submit" name="submit" value="submit" ></center>
                </div>


            </div>
        </div>
    </div>
</form>

</body>
</html>
