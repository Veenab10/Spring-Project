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
<nav class="p-3 mb-2 bg-primary text-white">
    <div class="container-fluid">

        </div>
                            <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">User
                             <!---   <img src="${pageContext.request.contextPath}${sessionScope.profileImage}" alt="Profile" width="50" height="50" class="rounded-circle">---!>
                            </button>

                            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuButton1">
                                <li><a class="dropdown-item" href="Signup.jsp">User Signup </a></li>
                                <li><a class="dropdown-item" href="SignIn.jsp">Users SignIn</a></li>
                            </ul>
                </div>

                <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">Admin
                       <!---   <img src="${pageContext.request.contextPath}${sessionScope.profileImage}" alt="Profile" width="50" height="50" class="rounded-circle">---!>
                                            </button>

                                            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuButton1">
                                                <li><a class="dropdown-item" href="AdminSignIn.jsp">Admin SignIn </a></li>
                                                <li><a class="dropdown-item" href="DepartmentAdminSignIn.jsp">Department Admin SignIn</a></li>
                                            </ul>

    </div>
</nav>
<body>

</body>
</html>
