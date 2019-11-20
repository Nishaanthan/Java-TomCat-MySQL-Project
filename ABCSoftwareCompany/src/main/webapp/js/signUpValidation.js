$(document).ready(function () {
   
    $('#signup-form').validate({
        rules: {
            formusername: "required",
            formpassword: {
                required: true,
                minlength: 5
            },
            formconfirmpassword: {
                required: true,
                minlength: 5,
                equalTo: "#formpassword"

            },
            formemail: {
                required: true,
                email: true,
            }
        },
        messages: {
            formusername: "Please Enter Your User Name",
            formpassword: {
                required: "Please Provide a Passord",
                minlength: "You Password must cconsist of at least 5 Characters"

            },
            formconfirmpassword: {
                required: "Please Provide a Passord",
                minlength: "You Password must cconsist of at least 5 Characters",
                equalTo:"Please enter the same password as above"

            },
            formemail:"Please enter a valid email address",

        }

    })
});