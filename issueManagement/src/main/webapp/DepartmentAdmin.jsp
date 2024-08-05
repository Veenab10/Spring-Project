<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Index</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="/issueManagement/js/Signup.js"></script>
</head>

<body>
<nav class="p-3 mb-2 bg-primary text-white">
    <div class="container-fluid">
        <a class="navbar-brand" style="color:white;" href="index.jsp">Home</a>
    </div>
</nav>

<form action="save-departmentadmin" method="post">
    <div class="d-flex justify-content-center mt-3 mb-3 align-items-center vh-5">
        <div class="card" style="width: 30rem;">
            <div class="card-body">
                <center><h5 class="card-title">Department Admin Form</h5></center>
                <strong style="color:green"><c:out value="${departmentadminsuccess}"/></strong>
                <strong style="color:red"><c:out value="${departmentadminfailed}"/></strong>
                <strong style="color:red"><c:out value="${successMessage}"/></strong>
                <strong style="color:red"><c:out value="${errorMessage}"/></strong>

                <div class="form-group p-3">
                    <label for="departmentAdminName">Department Admin Name</label>
                    <input type="text" class="form-control" id="departmentAdminName" name="departmentAdminName" placeholder="Enter First Name" >
                </div>

                <div class="form-group p-3">
                    <label for="departmentType">Select Department</label>
                    <select class="form-select" name="departmentType" id="departmentType">
                        <c:forEach var="department" items="${departments}">
                            <option value="${department.departmentName}">${department.departmentName}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group p-3">
                    <label for="departmentAdminEmailId">Email ID</label>
                    <input type="email" class="form-control" id="departmentAdminEmailId" name="departmentAdminEmailId" placeholder="Enter Email ID" >
                </div>

                <div class="form-group p-3">
                    <label for="departmentAdminContactNumber">Contact Number</label>
                    <input type="text" class="form-control" id="departmentAdminContactNumber" name="departmentAdminContactNumber" placeholder="Enter Contact Number" >
                </div>

                <div class="form-group p-3">
                    <label for="departmentAdminAlternativeContactNumber">Alternative Contact Number</label>
                    <input type="text" class="form-control" id="departmentAdminAlternativeContactNumber" name="departmentAdminAlternativeContactNumber" placeholder="Enter Alternative Contact Number" >
                </div>

                <div class="form-group p-3">
                    <center><input type="submit" class="btn btn-primary" id="submit" name="submit" value="Submit"></center>
                </div>

                <center><a href="DepartmentAdminSignIn.jsp">Existing User? Login Here</a></center>
            </div>
        </div>
    </div>
    ${departments}
</form>

<script>
    function validateEmail() {
        // Your email validation JavaScript code
    }

    function validatePhone() {
        // Your phone validation JavaScript code
    }
</script>
</body>
</html>
