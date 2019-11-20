$(document).ready(function () {
   
    $('#client-form').validate({
        rules: {
            formclientName: "required",
            formclientCompanyName : "required",
            formclientEmail: {
                required: true,
                email: true,
            },
            formclientPhone:{
                 required:true,
                 minlength:10,
                 number:true,
            }
        },
        messages: {
            formclientName: "Please Enter Your Client Name",
            formclientCompanyName: "Please Enter Comapny Name",
          
            formclientEmail:"Please enter a valid email address",
            formclientPhone:{
                 required:"Please Enter Client Phone Number",
                 minlength:"Please Enter Valid Phone Number",
                number:"Please Enter Valid Phone Number",
            }
        }

    })
});