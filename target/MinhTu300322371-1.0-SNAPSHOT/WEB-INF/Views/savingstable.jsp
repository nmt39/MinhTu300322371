<%--
  Created by IntelliJ IDEA.
  User: nmtu3
  Date: 2021-08-12
  Time: 4:20 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Minh Tu Nguyen 300322371</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script>
        function myFunction(){
            var a = confirm("Are you sure you want to delete the record ?")
            return a;
        }
    </script>
    <style>
        h1 {
            text-align:center;
        }

    </style>



</head>
<body>
<%--header--%>
<h1>Savings Investment Record</h1>

<p></p>
<p></p>

<div class="container">

    <h1 id="mes">${errorMessage}</h1>
    <div class="container2">
        <p>The following are the savings records...</p>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Customer Number</th>
                <th>Customer Name</th>
                <th>Customer Deposit</th>
                <th>Number of years</th>
                <th>Savings Type</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${todos}" var="todo">



                <tr>
                    <td>${todo.customerNumber}</td>
                    <td>${todo.customerName}</td>
                    <td>${todo.customerDeposit}</td>
                    <td>${todo.year}</td>
                    <td>${todo.savingType}</td>

                    <td>    <a type="button" class="btn btn-primary"
                               href="update-todo?id=${todo.customerNumber}" >Edit</a> </td>



                    <td>  <a type="button" style='background-color: orange;' class="btn btn-primary" onclick="myFunction()"
                               href="delete-todo?id=${todo.customerNumber}" >Delete</a> </td>

                    <td>    <a type="button" class="btn btn-primary"
                               href="see-todo?id=${todo.customerNumber}" >Projected Investment</a> </td>



                </tr>


            </c:forEach>
            </tbody>
        </table>
    </div>

    <%--add a button Add--%>
    <a class="btn btn-success" href="add-todo">Add</a>
</div>



</body>
</html>
