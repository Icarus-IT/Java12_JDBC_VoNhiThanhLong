<%@page import="cybersoft.java12.jsp.util.UrlUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>
    <link rel="stylesheet" href="styles.css">
    <link rel="shortcut icon" href="visualstudio_icon_188909.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body >
    <h1 class="text-primary text-center m-2"> User Dashboard</h1>
    <a href="<%=request.getContextPath()+UrlUtils.CUSTOMER_ADD %>"
    class="btn btn-primary text-white p-2 m-2">Add new customer</a>
    <table  class="table table-bordered">
        <thead class="table-dark">
            <tr>
             <th>No.</th>
                <th>Code</th>
                <th>Name</th>
                <th>Address</th>
                <th>Email</th>
                 <th>Function</th>
            </tr>
        </thead>
        <tbody>
      <c:forEach var="customer" items="${customers}" varStatus="loopStatus" >
           <tr>
            	<td>${loopStatus.count }</td>
                <td>${customer.code }</td>
                <td>${customer.name }</td>
                 <td>${customer.address }</td>
     		 <td>${customer.email }</td>
     		 <td>
     		 <a href="<%=request.getContextPath()+UrlUtils.CUSTOMER_DELETE %>?code=${customer.code}" class="btn btn-sm btn-outline-danger text-danger">
     		 <i class="fa fa-trash" aria-hidden="true"></i></a>
     		 <a  href="<%=request.getContextPath()+UrlUtils.CUSTOMER_UPDATE %>?code=${customer.code}"class="btn btn-sm btn-outline-success text-success">
     		 <i class="fa fa-wrench" aria-hidden="true"></i></a>
     		 </td>
       		</tr>
      </c:forEach>
       
        </tbody>
    </table>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>