let fieldsChecks = {

	    "emailId" : false,
	    "password" :false,

	}

function validate(){
    let flag = false;

    for(let [key, value] of Object.entries(fieldsChecks)){

        if(value === false){
            flag = true;
            break;
        }
    }

    if(!flag){
        document.getElementById("submit").removeAttribute("disabled");
    }else{
        document.getElementById("submit").setAttribute("disabled","");
    }
}

function emailValidation() {
               let element = document.getElementById("emailId");
              let error = document.getElementById("emailError");

                              <!----Regular expression pattern for validating email address--!>
      let emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

                                  <!---Check if the email is valid--!>
      if (emailRegex.test(element.value)) {
                                   //Email is valid
                                  error.innerHTML = "";
                                  fieldsChecks["emailId"] = true;
                              } else {
                            //email is Invalid
                                  error.innerHTML = "Invalid email address.";
                                  error.style.color = "red";
                                  fieldsChecks["emailId"] = false;
                              }
                              validate();
                          }

      function passwordValidation(){
      console.log(" pvalidation")
                          let element = document.getElementById("password");
                          let error = document.getElementById("passwordError");

                         if(element.value.length != "0"){
                              error.innerHTML = "";
                              fieldsChecks["password"] = true;
                          }else{
                              error.innerHTML ="please Enter password";
                              error.style.color="red"
                              fieldsChecks["password"] = false;

                          }
                          validate();
                      }
                 function disableButton() {
                          var accountLocked = document.getElementById("accountLocked").value;
                          if (accountLocked === "true") {
                              document.getElementById("submit").disabled = true;
                          }
                      }
                      window.onload = disableButton;

