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
<nav class="p-3 mb-3 bg-primary text-white">
    <div class="container-fluid">
        <a class="navbar-brand" style="color:white;" href="index.jsp">Home</a>

        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
            <img src="<%= request.getContextPath() %>/images/profileicon.jpg" alt="Profile" width="30" height="30" class="rounded-circle"> <!-- Placeholder icon -->
        </button>

        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuButton1">
            <li><a class="dropdown-item" href="ResetPassword.jsp">Reset Password</a></li>
            <li><a class="dropdown-item" href="edit-profile">Edit Profile</a></li>
            <li><a class="dropdown-item" href="view-profile">View Profile</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <h2>Welcome to the Homepage</h2>

    <%-- Assuming 'uploadedFileName' is a variable that holds the name of the uploaded image file --%>
    <% String uploadedFileName = (String) request.getAttribute("uploadedFileName"); // Retrieve uploaded file name from request attribute --%>
    <img src="<%= request.getContextPath() %>/images/<%= uploadedFileName %>" alt="Uploaded Image" class="img-thumbnail">
</div>

</body>
</html>
