
let fieldsChecks = {

     //"name attribute: value"
    "firstName": false,
    "lastName": false,
    "emailId": false,
    "contactNumber": false,
    "alternativeContactNumber": false,
    "address": false,
    "agree": false
};

// Function to validate all fields and enable/disable signup button
function validate() {
    let isValid = true;

    // Check each field validity
    for (let field in fieldsChecks) {
        if (!fieldsChecks[field]) {
            isValid = false;
            break;
        }
    }

    // Enable/disable submit button based on overall form validity
    document.getElementById("submit").disabled = !isValid;
}

// Function to validate first name
function firstNameValidation() {
    let element = document.getElementById("firstName");
    let error = document.getElementById("firstNameError");
    let nameRegex = /^[A-Za-z]+$/;

    if (element.value.length >= 3 && element.value.length < 30 && nameRegex.test(element.value)) {
        error.innerHTML = "";
        fieldsChecks["firstName"] = true;
    } else {
        error.innerHTML = "Invalid first name. Should be alphabetic characters only and length should be between 3 and 30.";
        error.style.color = "red";
        fieldsChecks["firstName"] = false;
    }

    validate();
}

// Function to validate last name
function lastNameValidation() {
    let element = document.getElementById("lastName");
    let error = document.getElementById("lastNameError");
    let nameRegex = /^[A-Za-z]+$/;

    if (element.value.length >= 1 && element.value.length <= 30 && nameRegex.test(element.value)) {
        error.innerHTML = "";
        fieldsChecks["lastName"] = true;
    } else {
        error.innerHTML = "Invalid last name. Should be alphabetic characters only and length should be between 1 and 30.";
        error.style.color = "red";
        fieldsChecks["lastName"] = false;
    }

    validate();
}

// Function to validate email
function emailValidation() {
    let element = document.getElementById("emailId");
    let error = document.getElementById("emailError");
    let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (emailRegex.test(element.value)) {
        error.innerHTML = "";
        fieldsChecks["emailId"] = true;
    } else {
        error.innerHTML = "Invalid email address.";
        error.style.color = "red";
        fieldsChecks["emailId"] = false;
    }

    validate();
    validateEmail();
}

// Function to validate contact number
function contactNumberValidation() {
    let element = document.getElementById("contactNumber");
    let error = document.getElementById("contactNumberError");
    let mobileRegex = /^[6-9]\d{9}$/;

    if (mobileRegex.test(element.value)) {
        error.innerHTML = "";
        fieldsChecks["contactNumber"] = true;
    } else {
        error.innerHTML = "Invalid contact number. Should start with 6, 7, 8, or 9 and be 10 digits long.";
        error.style.color = "red";
        fieldsChecks["contactNumber"] = false;
    }

    validate();
    validatePhone();
}

// Function to validate alternative contact number
function alternateContactNumberValidation() {
    let element = document.getElementById("alternativeContactNumber");
    let error = document.getElementById("alternativeContactError");
    let mobileRegex = /^[6-9]\d{9}$/;

//    if (element.value === "" || mobileRegex.test(element.value)) {
//        error.innerHTML = "";
//        fieldsChecks["alternativeContactNumber"] = true;
//    }

    if (mobileRegex.test(element.value)) {
            error.innerHTML = "";
            fieldsChecks["alternativeContactNumber"] = true;
        }
    else {
        error.innerHTML = "Invalid alternative contact number. Should start with 6, 7, 8, or 9 and be 10 digits long.";
        error.style.color = "red";
        fieldsChecks["alternativeContactNumber"] = false;
    }

    validate();
}

// Function to validate address
function addressValidation() {
    let element = document.getElementById("address");
    let error = document.getElementById("addressError");

    if (element.value.length >= 3 && element.value.length <= 300) {
        error.innerHTML = "";
        fieldsChecks["address"] = true;
    } else {
        error.innerHTML = "Invalid address. Should be between 3 and 300 characters.";
        error.style.color = "red";
        fieldsChecks["address"] = false;
    }

    validate();
}

// Function to validate agree checkbox
function agreeValidation() {
    let element = document.getElementById("agree");
    let error = document.getElementById("agreeError");

    if (element.checked) {
        error.innerHTML = "";
        fieldsChecks["agree"] = true;
    } else {
        error.innerHTML = "Please agree to the terms.";
        error.style.color = "red";
        fieldsChecks["agree"] = false;
    }

    validate();
}
