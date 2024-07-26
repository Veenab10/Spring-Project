<%@ page isELIgnored="false"%>
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
                        <li><a class="dropdown-item" href="AdminProfile.jsp">AdminProfile </a></li>
                    </ul>
        </div>
    </nav>

<div class="container">
    <h2>Welcome to Add Department</h2>

    <form action="save-department" method="post">

        <div class="d-flex justify-content-center mt-3 mb-3 align-items-center vh-5">
            <div class="card" style="width: 30rem;">
                <div class="card-body">
                    <center><h5 class="card-title">Department Form</h5></center>
                    <strong style="color:green"/>${savedsuccess}</strong>
                    <strong style="color:green"/>${savedfailed}</strong>

                    <div class="form-group p-3">
                        <label for="Department Name">Department Name</label>
                        <input type="text" class="form-control" id="departmentName" name="departmentName"   placeholder="Enter Department Name" required>
                    </div>

                    <div class="form-group p-3">
                       <label for="address">Address</label>
                       <textarea class="form-control" placeholder="Enter address here" id="address" onblur="addressValidation()" name="address" required></textarea>
                    </div>


                <div class="form-group p-3">
                    <label for="address">City</label>
                    <textarea class="form-control" placeholder="Enter area" id="city" onblur="addressValidation()" name="city"  required></textarea>
                </div>

                <div class="row mb-3">
                    <div class="col">
                        <center>   <button type="submit" class="btn btn-primary">submit</button></center>
                    </div>
                </div>

</div>

</body>
</html>