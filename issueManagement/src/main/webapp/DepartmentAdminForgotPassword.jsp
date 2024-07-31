<%@ page  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Index</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


</head>

<body>
<nav class="p-3 mb-2 bg-primary text-white">
    <div class="container-fluid">
        <a class="navbar-brand" style="color:white;" href="index.jsp">Home</a>
    </div>
</nav>

<form action="forgot-password" method="post">


    <div class="d-flex justify-content-center mt-3 mb-3 align-items-center vh-5">
        <div class="card" style="width: 30rem;">
            <div class="card-body">
                <center><h5 class="card-title">ForgetPassword Form</h5></center>
                <strong style="color:green"/>${Loginresult}</strong>
                <strong style="color:green;">${forgotMessage}</strong>
                <strong style="color:red;">${forgotError}</strong>
                <div class="form-group p-3">
                    <label for="emailId">Email ID</label>
                    <input type="email" class="form-control" id="departmentAdminEmailId" name="departmentAdminEmailId" value="${departmentAdminEmailId}"  onblur="emailValidation()"  placeholder="Enter Email ID" >
                    <span id="emailError" style="color: red;"></span>
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
