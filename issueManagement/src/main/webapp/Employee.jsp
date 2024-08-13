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

<form action="save-employee-details" method="post">
    <div class="d-flex justify-content-center mt-3 mb-3 align-items-center vh-5">
        <div class="card" style="width: 30rem;">
            <div class="card-body">
                <center><h5 class="card-title">Employee Form</h5></center>
                <strong style="color:green"><c:out value="${departmentadminsuccess}"/></strong>
                <strong style="color:red"><c:out value="${departmentadminfailed}"/></strong>
                <strong style="color:red"><c:out value="${successMessage}"/></strong>
                <strong style="color:red"><c:out value="${errorMessage}"/></strong>

                <div class="form-group p-3">
                    <label for="departmentAdminName">Employee Name</label>
                    <input type="text" class="form-control" id="employeeName" name="employeeName" placeholder="Enter Employee Name" >
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
                    <label for="employeeEmail">Email ID</label>
                    <input type="email" class="form-control" id="employeeEmail" name="employeeEmail" placeholder="Enter Email ID" >
                </div>

                <div class="form-group p-3">
                    <label for="employeeContactNumber">Contact Number</label>
                    <input type="text" class="form-control" id="employeeContactNumber" name="employeeContactNumber" placeholder="Enter Contact Number" >
                </div>

                <div class="form-group p-3">
                    <label for="employeeAlternativeNumber">Alternative Contact Number</label>
                    <input type="text" class="form-control" id="employeeAlternativeNumber" name="employeeAlternativeNumber" placeholder="Enter Alternative Contact Number" >
                </div>

                <div class="form-group p-3">
                    <center><input type="submit" class="btn btn-primary" id="submit" name="submit" value="Submit"></center>
                </div>

                <center><a href="DepartmentAdminSignIn.jsp">Existing User? Login Here</a></center>
            </div>
        </div>
    </div>

</form>

</body>
</html>
