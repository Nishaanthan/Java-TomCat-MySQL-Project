$(document).ready(function () {
   
    $('#project-form').validate({
        rules: {
          
            formClientName: {
                required: true,
             
            },
            formLevel: {
                required: true,
             
            },
            formStatus: {
                required: true,
             
            },
            formStartDate: {
                required: true,
            
            },
             formStartDate: {
                required: true,
            
            },
            formEndDate: {
                required: true,
              
            },
            formdescription: "required",
            formname: {
                required: true,
              
            },
        },
        messages: {
        
            formClientName: {
                required: "Please Select Client Name",
              

            },
             formLevel: {
                required: "Please Select Level Of the Project",
              

            },
             formStatus: {
                required: "Please Select Status Of the Project",
              

            },
            formStartDate: {
                required: "Please Select Start Date",
               
            },
             formEndDate: {
                required: "Please Select End Date",
               
            },
            formdescription: "please Enter Project Description",
            formname: {
                required: "Please Enter Project Name",
               
            },
          
        }

    })
});