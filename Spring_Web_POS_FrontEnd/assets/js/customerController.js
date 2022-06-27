//  <!-- -------------------------- Customer jQuery ---------------------------------- -->


// --------------------Validation text deald-------------------


function buttonDisable(){
  let textFeald=[$("#txtCustomerId"),$("#txtCustomerName"),$("#txtCustomerAddress"),$("#txtCustomerSalary")];
  let result=false;

  for (let index = 0; index < textFeald.length; index++) {
    if(textFeald[index].css('border-color')==="rgb(255, 0, 0)"){
        result = true;
    }
    
  }
  if(result){
    $("#btnCustomerSave").attr("disabled",true);
    console.log("disabled");
  }else{
    $("#btnCustomerSave").attr("disabled",false);
    console.log("enabled");
  }

}



// ----------------------------customer ID-------------------------------------------
var customerId=/^(C-)[0-9]{4}$/;
$("#txtCustomerId").keyup(function(){

  setTimeout(function () {
    buttonDisable();
   }, 150);

  let input=$("#txtCustomerId").val();

  if(customerId.test(input)){
    $("#txtCustomerId").css('border','1px solid green');
    $("#txtCustomerName").css('border','1px solid red');
    // $("#error").text("ID is Correct..");

    $("#txtCustomerId").keydown(function(event){
      if(event.key=="Enter"){
        $("#txtCustomerName").focus();
        $("#txtCustomerId").css('border','1px solid green');
        // $("#btnCustomerSave").attr("disabled",false);
        // $("#error").hide();
        
      }
  });
  
  }else{
    $("#txtCustomerId").css('border','1px solid red');
    $("#btnCustomerSave").attr("disabled",true);
    // $("#error").text("Customer ID is Incorrect..");
    
  }

})

// --------------------------Customer Name---------------------------------------------


var customerName=/^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/;
$("#txtCustomerName").keyup(function(){

  setTimeout(function () {
    buttonDisable();
   }, 150);

  let input=$("#txtCustomerName").val();

  if(customerName.test(input)){
    $("#txtCustomerName").css('border','1px solid green');
    $("#txtCustomerAddress").css('border','1px solid red');
    // $("#error1").text("Name is Correct..");
    

    $("#txtCustomerName").keydown(function(event){
      if(event.key=="Enter"){
        $("#txtCustomerAddress").focus();
        $("#txtCustomerName").css('border','1px solid green');
        // $("#btnCustomerSave").attr("disabled",false);
        // $("#error1").hide();
     }
  });
    
  }else{
    $("#txtCustomerName").css('border','1px solid red');
    $("#btnCustomerSave").attr("disabled",true);
    // $("#error1").text("Name is Incorrect..");
  }

})


// --------------------------Customer Address---------------------------------------------


var customerAddress=/^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/;
$("#txtCustomerAddress").keyup(function(){

  setTimeout(function () {
    buttonDisable();
   }, 150);

  let input=$("#txtCustomerAddress").val();

  if(customerAddress.test(input)){
    $("#txtCustomerAddress").css('border','1px solid green');
    $("#txtCustomerSalary").css('border','1px solid red');
    // $("#error2").text("Name is Correct..");

    $("#txtCustomerAddress").keydown(function(event){
      if(event.key=="Enter"){
        $("#txtCustomerSalary").focus();
        $("#txtCustomerAddress").css('border','1px solid green');
        // $("#btnCustomerSave").attr("disabled",false);
        // $("#error2").hide();
     }
  });
    
  }else{
    $("#txtCustomerAddress").css('border','1px solid red');
    $("#btnCustomerSave").attr("disabled",true);
    // $("#error2").text("Name is Incorrect..");
  }

})



// --------------------------Customer Salary---------------------------------------------


var customerSalary=/^[0-9][0-9][0-9][0-9]*([.])[0-9]{2}?$/;
$("#txtCustomerSalary").keyup(function(){

  setTimeout(function () {
    buttonDisable();
   }, 150);

  let input=$("#txtCustomerSalary").val();

  if(customerSalary.test(input)){
    $("#txtCustomerSalary").css('border','1px solid green');
    // $("#error3").text("Name is Correct..");
    // $("#btnCustomerSave").attr("disabled",false);
    // $("#error3").hide();
    

    
  }else{
    $("#txtCustomerSalary").css('border','1px solid red');
    $("#btnCustomerSave").attr("disabled",true);
    // $("#error3").text("Name is Incorrect..");
  }

})



$("#search").keyup(function(event){
  var searchId=$("#search").val();
  var responces=seachCustomer(searchId);

  if(event.key=="Enter"){
   
    if(responces){
      $("#txtCustomerId").val(responces.getCusId());
        $("#txtCustomerName").val(responces.getCusName());
        $("#txtCustomerAddress").val(responces.getCusAddress());
        $("#txtCustomerSalary").val(responces.getCusSalary());

    }else{
     // alert("hi");
    }


        
        // console.log("hi");
      
    
  }
})


function seachCustomer(id){
  for(let i=0;i<CustomerDB.length;i++){
    if(CustomerDB[i].getCusId()==id){
      return CustomerDB[i];
    }
  }
}



function saveCustomer(){

    var data = $("#customerForm").serialize();
    $.ajax({
        url: "http://localhost:8080/pos/customer",
        method:"POST",
      data:data,
        success:function (add){
            alert(add.data);
            loadAllCustomer();

        }
    })

}


function  customerFirstLoad(){
  loadAllCustomer();


}

function loadAllCustomer(){
  $("#selecterow").empty();

  $.ajax({
    url: "http://localhost:8080/pos/customer",
    method:"GET",
    success:function (load){


      for(var i of load.data){

        let data=`<tr><td>${i.id}</td>
    <td>${i.name}</td>
    <td>${i.address}</td>
    <td>${i.salary}</td></tr>`
        $('#selecterow').append(data);
      }
      buttonFunctionCliceEvent();

    }
  })
}


function buttonFunctionCliceEvent(){
  $('#selecterow>tr').click(function (){
      let id = $(this).children().eq(0).text();
      let name = $(this).children().eq(1).text();
      let address = $(this).children().eq(2).text();
      let salary = $(this).children().eq(3).text();

      $("#txtCustomerId").val(id);
      $("#txtCustomerName").val(name);
      $("#txtCustomerAddress").val(address);
      $("#txtCustomerSalary").val(salary);

  });
}


$("#btnCustomerSave").click(function () {

  $("#selecterow>tr").off("click");

  loadAllCustomer();
  saveCustomer();

  $("#txtCustomerId").css('border','black');
  $("#txtCustomerName").css('border','black');
  $("#txtCustomerAddress").css('border','black');
  $("#txtCustomerSalary").css('border','black');




// ----delete------

  $(".deleteCustomer").click(function (){
    let cusId = $("#txtCustomerId").val();

    $.ajax({
      url: "http://localhost:8080/pos/customer?Cus_ID"+cusId,
      method:"DELETE",
      success:function (dele){

        if (dele.status==200){
            alert(dele.message);
          loadAllCustomer();

        }else if(dele.status==400){
          alert(dele.data);

        }else {
          alert(dele.data);
        }
      }
    })
  })



//-------UpdateCustomer---------
$("#updateCustomer").click(function(){
  // console.log("Enter");

  var custOb = {
      cusId : $("#txtCustomerId").val(),
      cusName : $("#txtCustomerName").val(),
      cusAddress : $("#txtCustomerAddress").val(),
      cusSalary : $("#txtCustomerSalary").val()
  }

   $.ajax({
     url: "http://localhost:8080/pos/customer",
     method:"PUT",
     contentType:"application/json",
     data: JSON.stringify(custOb),
     success:function (updates){


       if(updates.status==200){
            alert(updates.message);
            loadAllCustomer();

       }else if(updates.status==400){
         alert(updates.message);

       }else {
         alert(updates.data);
       }
     }
   })
    loadAllCustomer();

})





$("#selecterow>tr").click(function(){
    // console.log(this);
    var id = $(this).find("td:eq(0)").text();
    var name = $(this).find("td:eq(1)").text();
    var address = $(this).find("td:eq(2)").text();
    var salary = $(this).find("td:eq(3)").text();


    console.log(id,name,address,salary);

    $("#txtCustomerId").val(id);
    $("#txtCustomerName").val(name);
    $("#txtCustomerAddress").val(address);
    $("#txtCustomerSalary").val(salary);

    })

});




  $("#btnCustomerSave").click(function () {
    $("#txtCustomerId").val('');
    $("#txtCustomerName").val('');
    $("#txtCustomerAddress").val('');
    $("#txtCustomerSalary").val('');

  });



