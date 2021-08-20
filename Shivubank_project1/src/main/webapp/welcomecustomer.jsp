<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- JSP CODE starts-->
    <%if(session.getAttribute("customer")==null){
        response.sendRedirect("first.html");
        }
    %>
      <!-- JSP CODE ends -->

 <div class="container">
        <div class="jumbotron">
            <h1 class="display-4">Welcome Customer to Shivubank</h1>
            <p class="lead">Customer menu</p>
            <hr class="my-4">
        </div>
        <a href='/Shivubank_project1/account.html'>Click Here to Create Account</a><br><br>
        <a href='/Shivubank_project1/deposit.html'>Click Here to Deposit</a><br><br>
        <a href='/Shivubank_project1/withdraw.html'>Click Here to Withdraw</a><br><br>
        <a href='/Shivubank_project1/transaction.html'>Click Here to Transaction</a><br><br>           
        <a href='logout'>Click Here to Logout</a><br><br>
    </div>
    
</body>
</html>