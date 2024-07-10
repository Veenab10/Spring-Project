<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Index</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</head>

<body>
<nav class="p-3 mb-3 bg-primary text-white">
    <div class="container-fluid">
        <a class="navbar-brand" style="color:white;" href="index.jsp">Home</a>

        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">

             <!--<img src="${pageContext.request.contextPath}/images/profileicon.jpg" alt="Profile" width="30" height="30" class="rounded-circle"> <!-- Add your profile icon path -->
             <img src="https://static.vecteezy.com/system/resources/previews/005/544/718/non_2x/profile-icon-design-free-vector.jpg" alt="Profile" width="40" height="40" class="rounded-circle"> <!-- Add your profile icon path -->

                    </button>  </button>

          <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuLink">
            <li><a class="dropdown-item" href="ResetPassword.jsp">ResetPassword</a></li>
            <li><a class="dropdown-item" href="edit-profile">Edit profile</a></li>
            <li><a class="dropdown-item" href="view-profile">view profile</a></li>
          </ul>
        </div>

    </div>
</nav>

<!-- Your body content here -->

</body>
</html>
