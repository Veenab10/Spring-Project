<%@ page  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Index</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script  src="/issueManagement/js/Signup.js"></script>

</head>

<body>
<nav class="p-3 mb-2 bg-primary text-white">
    <div class="container-fluid">
        <a class="navbar-brand" style="color:white;" href="index.jsp">Home</a>
    </div>
</nav>

<form action="signup" method="post">

    <div class="d-flex justify-content-center mt-3 mb-3 align-items-center vh-5">
        <div class="card" style="width: 30rem;">
            <div class="card-body">
                <center><h5 class="card-title">Signup Form</h5></center>
                <strong style="color:green"/>${result}</strong>

                <div class="form-group p-3">
                    <label for="firstName">First Name</label>
                    <input type="text" class="form-control" id="firstName" name="firstName" onblur="firstNameValidation()"  placeholder="Enter First Name" >
                    <span id="firstNameError"></span>
                </div>

                <div class="form-group p-3">
                    <label for="lastName">Last Name</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" onblur="lastNameValidation()"  placeholder="Enter Last Name" >
                    <span id="lastNameError"></span>
                </div>

                <div class="form-group p-3">
                    <label for="emailId">Email ID</label>
                    <input type="email" class="form-control" id="emailId" name="emailId" onchange="validateEmail()" onblur="emailValidation()"  placeholder="Enter Email ID" >
                    <span id="emailError" style="color: red;"></span>
                </div>

                <div class="form-group p-3">
                    <label for="contactNumber">Contact Number</label>
                    <input type="text" class="form-control" id="contactNumber" name="contactNumber" onchange="validatePhone()" onblur="contactNumberValidation()"  placeholder="Enter Contact Number" >
                    <span id="contactNumberError" style="color:red;"></span>
                </div>

                <div class="form-group p-3">
                    <label for="alternativeContactNumber">Alternative Contact Number</label>
                    <input type="text" class="form-control" id="alternativeContactNumber"  name="alternativeContactNumber" onblur="alternateContactNumberValidation()"   placeholder="Enter Alternative Contact Number" >
                    <span id="alternativeContactError"></span>
                </div>

                <div class="form-group p-3">
                    <label for="address">Address</label>
                    <textarea class="form-control" placeholder="Enter address here" id="address" onblur="addressValidation()" name="address" ></textarea>
                    <span id="addressError"></span>
                </div>

                <div class="form-group p-3">
                    <input type="checkbox" class="form-check-input" id="agree"  name="agree" onchange="agreeValidation()">
                    <label class="form-check-label" for="agree">Agree</label>
                    <span id="agreeError"></span>
                </div>

                <div class="form-group p-3">
                    <center><input type="submit" class="btn btn-primary" id="submit" name="submit" value="Signup" ></center>
                </div>
               <center> <a href="SignIn.jsp"/>Existing User?Login Here</a></center>

            </div>
        </div>
    </div>
</form>

<script>

function validateEmail()
{
    console.log("validateEmail");
    let email=document.getElementById("emailId").value;
    console.log(email);
    let error=document.getElementById("emailError");
    if(email=="")
    {
        document.getElementById("emailError").innerHTML="Enter valid email";

    }
    else{
    const request = new XMLHttpRequest();
    request.open("GET","http://localhost:8080/issueManagement/validateEmail/"+email);
    request.send();
    console.log(request);
    request.onload = function()
    {
        let ref =this.responseText;
        console.log(ref);
        error.innerHTML = ref;

    };
    }

}


function validatePhone()
{
    console.log("validatePhone");
    let phone=document.getElementById("contactNumber").value;
    console.log(phone);
    let error=document.getElementById("contactNumberError");
    if(phone=="")
    {
        document.getElementById("contactNumberError").innerHTML="Enter valid Contact number";

    }
    else{
    const request = new XMLHttpRequest();
    request.open("GET","http://localhost:8080/issueManagement/validatePhone/"+phone);
    request.send();
    console.log(request);
    request.onload = function()
    {
        let ref =this.responseText;
        console.log(ref);
        error.innerHTML = ref;

    };
    }

}

</script>
</body>
</html>
