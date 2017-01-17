<html>
<head>
    <title></title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
 <script>
 
     $(document).ready(function () {
 
         $.ajax({
             type: "GET",
             url: "http://localhost:8080/JersyWebService/rest/employee/banks/370941",
             success: function (response) {
                 var names = response.d;
                 alert("success");
                 document.getElementById("content").innerHTML=response.employeeId +" "+response.employeeName+" "+response.bankName+" "+response.bankBalance;
             },
             failure: function (response) {
            	 alert("fail");
                 alert(response.d);
             }
         });
     });
 </script>
</head>
<body>
 
<form id="frm" method="post">
    <div id="content">
 
    </div>
 
</form>
 
</body>
</html>
