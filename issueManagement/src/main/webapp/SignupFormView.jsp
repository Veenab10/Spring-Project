<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Profile View</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <nav class="navbar navbar-dark bg-primary">
        <div class="container-fluid">
            <div class="navbar-header">

                <a class="navbar-brand text-white" href="index.jsp"><b>Home</b></a>
                <a class="navbar-brand text-white" href="SignIn.jsp"><b>SignIn</b></a>
            </div>
        </div>
    </nav>

    <div class="d-flex justify-content-center mt-3 mb-3 align-items-center vh-5">
            <div class="card" style="width: 30rem;">
                <div class="card-body">
                <center><strong class="card-title">USER PROFILE</strong></center>
               <p class="card-title"><strong> First Name:</strong> ${signupDto.firstName}</p><br>
               <p class="card-title"><strong> Last Name:</strong>${signUpDTO.lastName}</p><br>
                <p class="card-text"><strong> Email: </strong>${signupDto.emailId}</p><br>
                <p class="card-text"><strong> Contact Number:</strong> ${signupDto.contactNumber}</p><br>
                 <p class="card-text"><strong> Alternative Contact Number:</strong> ${signupDto.alternativeContactNumber}</p><br>
                <p class="card-text"><strong> Address:</strong> ${signupDto.address}</p><br>
            </div>
        </div>
    </div>
</body>
</html>