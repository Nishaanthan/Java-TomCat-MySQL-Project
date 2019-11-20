$(document).ready(function(){
$('#login-form').validate({
  rules : {
    formusername:"required",
formpassword:{
    required:true,
    minlength:5
}
  },
  messages:{
    formusername:"Please Enter Your User Name",
    formpassword:{
        required:"Please Provide a Passord",
        minlength:"You Password must cconsist of at least 5 Characters"

    }

  }

})
});