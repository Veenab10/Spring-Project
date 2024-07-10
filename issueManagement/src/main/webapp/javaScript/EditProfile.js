let fieldsChecks = {
    "firstName": false,
    "lastName": false,
    "contactNumber": false,
    "alternativeContactNumber": false,
    "address": false,
};

// Function to initialize fieldsChecks based on existing data
function initializeFieldsChecks() {
    // Example assuming signupdto is populated from server-side or other source
    if (signupdto.firstName && signupdto.firstName.length >= 3 && signupdto.firstName.length < 30 && /^[A-Za-z]+$/.test(signupdto.firstName)) {
        fieldsChecks["firstName"] = true;
    }
    if (signupdto.lastName && signupdto.lastName.length >= 1 && signupdto.lastName.length <= 30 && /^[A-Za-z]+$/.test(signupdto.lastName)) {
        fieldsChecks["lastName"] = true;
    }
    if (signupdto.contactNumber && /^[6-9]\d{9}$/.test(signupdto.contactNumber)) {
        fieldsChecks["contactNumber"] = true;
    }
    if (signupdto.alternativeContactNumber && /^[6-9]\d{9}$/.test(signupdto.alternativeContactNumber)) {
        fieldsChecks["alternativeContactNumber"] = true;
    }
    if (signupdto.address && signupdto.address.length >= 3 && signupdto.address.length <= 300) {
        fieldsChecks["address"] = true;
    }
}

// Call initializeFieldsChecks when the page loads or when signupdto is set
initializeFieldsChecks();

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

// Similar validation functions for lastName, contactNumber, alternativeContactNumber, address...

// Add event listeners to each input field to validate on blur or change
document.getElementById("firstName").addEventListener("blur", firstNameValidation);
document.getElementById("lastName").addEventListener("blur", lastNameValidation);
document.getElementById("contactNumber").addEventListener("blur", contactNumberValidation);
document.getElementById("alternativeContactNumber").addEventListener("blur", alternateContactNumberValidation);
document.getElementById("address").addEventListener("blur", addressValidation);

// Call validate on page load to set initial state of submit button
validate();
