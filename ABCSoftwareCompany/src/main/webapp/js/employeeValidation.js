$(document).ready(function () {
   
    $('#Employee-form').validate({
        rules: {
            formemployeepossition: "required",
            formemployeeaddress : "required",
          formemployeefirstname: "required",
           formemployeelastname: "required",
            formemployeephone:{
                 required:true,
                 minlength:10,
                 number:true,
            }
        },
        messages: {
            formemployeepossition: "Please Enter your Possition",
            formemployeeaddress: "Please Enter your Address",
           formemployeefirstname: "Please Enter first name",
            formemployeelastname: "Please Enter last name",
            formemployeephone:{
                 required:"Please Enter Employee Phone Number",
                 minlength:"Please Enter Valid Phone Number",
                number:"Please Enter Valid Phone Number",
            }
        }

    })
});