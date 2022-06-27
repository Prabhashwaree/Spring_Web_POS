// <!-- -------------------------- Item jQuery ---------------------------------- -->
// -------------------auto save table data (practice)----------------------


function buttonDisabled(){
  let textFeald=[$("#txtItemCode"),$("#txtItemName"),$("#txtItemPrice"),$("#txtItemQuantity")];
  let result=false;

  for (let index = 0; index < textFeald.length; index++) {
    if(textFeald[index].css('border-color')==="rgb(255, 0, 0)"){
        result = true;
    }
    
  }
  if(result){
    $("#btnItemSave").attr("disabled",true);
    console.log("disabled");
  }else{
    $("#btnItemSave").attr("disabled",false);
    console.log("enabled");
  }

}


 // ----------------------------Item Code-------------------------------------------

var itemCode=/^(I-)[0-9]{4}$/;
$("#txtItemCode").keyup(function(){
  
  setTimeout(function () {
    buttonDisabled();
   }, 150);

  let input=$("#txtItemCode").val();
  
  if(itemCode.test(input)){
    $("#txtItemCode").css('border','1px solid green');
    $("#txtItemName").css('border','1px solid red');
    // $("#errors").text("ID is Correct..");

    $("#txtItemCode").keydown(function(event){
      if(event.key=="Enter"){
        $("#txtItemName").focus();
        $("#txtItemCode").css('border','1px solid green');
        // $("#errors").hide();
      }
  });

  }else{
    $("#txtItemCode").css('border','1px solid red');
    // $("#btnItemSave").attr("disabled",true);
    // $("#errors").text("Customer ID is Incorrect..");
  }

})
 // ----------------------------Item Name-------------------------------------------

var itemName=/^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z])$/;
$("#txtItemName").keyup(function(){
  

  setTimeout(function () {
    buttonDisabled();
   }, 150);

  let input=$("#txtItemName").val();
  
  if(itemName.test(input)){
    $("#txtItemName").css('border','1px solid green');
    $("#txtItemPrice").css('border','1px solid red');
    // $("#errors1").text("ID is Correct..");

    $("#txtItemName").keydown(function(event){
      if(event.key=="Enter"){
        $("#txtItemPrice").focus();
        $("#txtItemName").css('border','1px solid green');
        // $("#btnItemSave").attr("disabled",false);
        // $("#errors1").hide();

      }
  });

  }else{
    $("#txtItemName").css('border','1px solid red');
    $("#btnItemSave").attr("disabled",true);
    // $("#errors1").text("Customer ID is Incorrect..");

  }

})



// ----------------------------Item Prices-------------------------------------------

var itemPrices=/^[0-9][0-9][0-9][0-9]*([.])[0-9]{2}?$/;
$("#txtItemPrice").keyup(function(){
  
  setTimeout(function () {
    buttonDisabled();
   }, 150);


  let input=$("#txtItemPrice").val();
  
  if(itemPrices.test(input)){
    $("#txtItemPrice").css('border','1px solid green');
    $("#txtItemQuantity").css('border','1px solid red');
    // $("#errors1").text("ID is Correct..");

    $("#txtItemPrice").keydown(function(event){
      if(event.key=="Enter"){
        $("#txtItemQuantity").focus();
        $("#txtItemPrice").css('border','1px solid green');
        // $("#btnItemSave").attr("disabled",false);
        // $("#errors1").hide();

      }
  });

  }else{
    $("#txtItemPrice").css('border','1px solid red');
    $("#btnItemSave").attr("disabled",true);
    // $("#errors1").text("Customer ID is Incorrect..");
  }
})



// ----------------------------Item Quantity-------------------------------------------
var itemQuantity=/^[0-9]{1,20}$/;
$("#txtItemQuantity").keyup(function(){
  

  setTimeout(function () {
    buttonDisabled();
   }, 150);


  let input=$("#txtItemQuantity").val();
  
  if(itemQuantity.test(input)){
    $("#txtItemQuantity").css('border','1px solid green');
    // $("#errors3").text("Name is Correct..");
    
    $("#btnItemSave").attr("disabled",false);
    // $("#errors3").hide();



  }else{
    $("#txtItemQuantity").css('border','1px solid red');
    // $("#btnItemSave").attr("disabled",true);
    // $("#errors3").text("Name is Incorrect..");
  }

})


$("#search1").keyup(function(event){
  var searchItemId=$("#search1").val();
  var responceId=searchItem(searchItemId);

  if(event.key=="Enter"){
   
    if(responceId){
      $("#txtItemCode").val(responceId.getItemCode());
        $("#txtItemName").val(responceId.getItemName());
        $("#txtItemPrice").val(responceId.getItemPrice());
        $("#txtItemQuantity").val(responceId.getItemQuantity());

    }else{
      // alert("hi");
    }

  }
})


function searchItem(code){
  for(let i=0;i<ItemDB.length;i++){
    if(ItemDB[i].getItemCode()==code){
      return ItemDB[i];
    }
  }
}


function saveItem(){
    var data = $("#itemForm").serialize();
    $.ajax({
        url: "http://localhost:8080/pos/item",
        method:"POST",
        data:data,
        success:function (add){
            alert(add.data);
            loadAllItem();

        }
    })
}



function itemFirstLoad(){
    loadAllItem();
}


function loadAllItem(){
  $("#selecterowItem").empty();

    $.ajax({
        url: "http://localhost:8080/pos/item",
        method:"GET",
        success:function (load){

            for(var i of load.data){

                let itemData=`<tr><td>${i.itemCode}</td>
                <td>${i.itemName}</td>
                <td>${i.price}</td>
                <td>${i.qty}</td>
               </tr>`
                            $('#selecterowItem').append(itemData);
            }
            buttonCliceEvent();
        }
    })
  }



function buttonCliceEvent(){
    $('#selecterowItem>tr').click(function (){
        let code = $(this).children().eq(0).text();
        let name = $(this).children().eq(1).text();
        let price = $(this).children().eq(2).text();
        let qty = $(this).children().eq(3).text();

        $("#txtItemCode").val(code);
        $("#txtItemName").val(name);
        $("#txtItemPrice").val(price);
        $("#txtItemQuantity").val(qty);

    });
}



$(".updateItems").click(function(){

    alert("hello");
   let iCode=$("#txtItemCode").val();
   let itName=$("#txtItemName").val();
   let iPrice=$("#txtItemPrice").val();
   let iQuantity=$("#txtItemQuantity").val();

   for(var i=0;i<ItemDB.length;i++){
     
     if($("#txtItemCode").val()==ItemDB[i].getItemCode()){
       
       ItemDB[i].setItemCode(iCode);
       ItemDB[i].setItemName(itName);
       ItemDB[i].setItemPrice(iPrice);
       ItemDB[i].setItemQuantity(iQuantity);
     }

   }
   loadAllItem();

})


//-------DeleteItem---------

$(".deleteItem").click(function (){
    let code = $("#txtItemCode").val();

    $.ajax({
        url: "http://localhost:8080/pos/item?itemCode"+code,
        method:"DELETE",
        success:function (dele){

            if (dele.status==200){
                alert(dele.message);
                loadAllItem();

            }else if(dele.status==400){
                alert(dele.data);

            }else {
                alert(dele.data);
            }
        }
    })
})


//-------UpdateItem---------

 $("#btnItemSave").click(function () {

      $("#selecterowItem>tr").off("click");

     loadAllItem();
      saveItem();


    $("#txtItemCode").css('border','black');
    $("#txtItemName").css('border','black');
    $("#txtItemPrice").css('border','black');
    $("#txtItemQuantity").css('border','black');

    // ----select table row data move to text feald-----

    $("#selecterowItem>tr").click(function(){
      var code = $(this).find("td:eq(0)").text();
      var name = $(this).find("td:eq(1)").text();
      var price = $(this).find("td:eq(2)").text();
      var quantity = $(this).find("td:eq(3)").text();



    console.log(code,name,price,quantity);

    $("#txtItemCode").val(code);
    $("#txtItemName").val(name);
    $("#txtItemPrice").val(price);
    $("#txtItemQuantity").val(quantity);

    })


    });



    // ----clear text feald data------

    $("#btnItemSave").click(function () {
      $("#txtItemCode").val('');
      $("#txtItemName").val('');
      $("#txtItemPrice").val('');
      $("#txtItemQuantity").val('');

}); 

