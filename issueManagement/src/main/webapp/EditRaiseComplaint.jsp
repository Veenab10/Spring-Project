<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script  src="/issueManagement/js/RaiseComplaint.js"></script>

</head>
<body>

<nav class="navbar navbar-dark bg-primary">
            <div class="container-fluid">
            <div class="navbar-header">
            <a class="navbar-brand" style="color:white;" href="index.jsp">Home</a>
            <a class="navbar-brand" style="color:white;" href="SignIn.jsp">SignIn</a>

            </div>
  </nav>

  <form action="edit-complaint" method="post">

      <div class="d-flex justify-content-center mt-3 mb-3 align-items-center vh-5">
          <div class="card" style="width: 30rem;">
              <div class="card-body">
                  <center><h5 class="card-title">Raise Complaint Form</h5></center>
                  <hr>
                  <strong style="color:green"/>${user}</strong>
                  <strong style="color:green"/>${raiseComplaintSucess}</strong>
                  <strong style="color:red"/>${ErrorRaiseComplaintSucess}</strong>

                   <div class="row mb-3">
                         <span id="countryNameError"></span>
                         <label for="countryName" class="form-label">Complaint Type:</label>
                         <select class="form-select custom-select-width" id="complaintType" name="complaintType"  placeholder="Complaint Type">
                               <option ${dto.complaintType==null ? 'selected' : ''}  selected value=" "></option>
                               <option value="Water Supply" ${dto.complaintType eq 'Water Supply' ? 'selected' : ''}>Water Supply</option>
                               <option value="System Problem"  ${dto.complaintType eq 'System Problem' ? 'selected' : ''}>System Problem</option>
                               <option value="Network Problem"  ${dto.complaintType eq 'Network Problem' ? 'selected' : ''}>Network Problem</option>
                               <option value="Electrical Problem"  ${dto.complaintType eq 'Electrical Problem' ? 'selected' : ''}>Electrical Problem</option>
                               <option value="Noise Problem"  ${dto.complaintType eq 'GMIT' ? 'selected' : ''}>Noise Problem</option>
                           </select>
                           <span id="collegeNameError"></span>
                       </div>

                       <!----Country ---!>

                                       <div class="row mb-3">
                                           <span id="countryNameError"></span>
                                           <label for="countryName" class="form-label">Country:</label>
                                           <select class="form-select custom-select-width" id="countryName" name="country" onchange="loadStates(this)"  placeholder="Enter country">
                                               <!-- Countries will be loaded here by JavaScript -->
                                           </select><br>
                                       </div>

                                       <!----State ---!>

                                       <div class="row mb-3">
                                           <span id="stateNameError"></span>
                                           <label for="state" class="form-label">State:</label>
                                           <select class="form-select custom-select-width" id="state" name="state" onchange="loadCities(this,countryName)"  placeholder="Enter State" >
                                               <!-- States will be loaded here by JavaScript -->
                                           </select><br>
                                       </div>

                                       <!----City ---!>

                                       <div class="row mb-3">
                                           <span id="cityNameError"></span>
                                           <label for="city" class="form-label">City:</label>
                                           <select class="form-select custom-select-width" id="city" name="city" placeholder="Enter city">
                                               <!-- Cities will be loaded here by JavaScript -->
                                           </select><br>
                                       </div>


                       <div class="row mb-3">
                                 <span id="areaError"></span><br>
                                 <label for="area" class="form-label">Area:</label>
                                 <input type="text" class="form-control" id="area" name="area" placeholder="Enter area">
                        </div>



                       <div class="mb-3">
                                <span id="errorAddress"></span><br>
                                <label for="area" class="form-label">Address:</label>
                                <label for="address" class="form-floating"></label>
                                <textarea class="form-control" placeholder="Enter address" id="address" style="height: 80px" name="address">${jobFormDTO.address}</textarea>
                       </div>



                       <div class="mb-3">
                                       <span id="descriptionError" class="text-danger"></span>
                                     <label for="area" class="form-label">Description:</label>
                                       <div class="form-floating">
                                           <textarea class="form-control" placeholder="Leave a comment here" name="description" id="description"  style="height:80px"  oninput="updateDescriptionCount()" maxlength="300" onblur="validateDescription()">${complaint.description}</textarea>
                                           <label for="description">Description</label>
                                       </div>
                                   </div>


                                       <div class="form-group p-3">
                                              <input type="checkbox" class="form-check-input" id="agree"  name="agree" onchange="agreeValidation()">
                                                           <label class="form-check-label" for="agree">Agree</label>
                                                           <span id="agreeError"></span>
                                                       </div>



                  <div class="form-group p-3">
                      <center><input type="submit" class="btn btn-primary" id="submit" name="submit" value="Apply" ></center>
                  </div>

                  <center> <a href="SignIn.jsp"/>Existing User?Login Here</a></center>


              </div>
          </div>
      </div>
  </form>

<!-- Including the JavaScript file after the DOM is loaded -->


  </body>
  </html>
