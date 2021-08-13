<%--
  Created by IntelliJ IDEA.
  User: nmtu3
  Date: 2021-08-12
  Time: 6:01 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Projected Investment</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h1>Projected table of customer number ${id}</h1>
    <h1>Name: ${name}</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Year</th>
            <th>Starting Amount</th>
            <th>Interest</th>
            <th>Ending Balance</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos1}" var="todo">
            <tr>
                <td>${todo.yr}</td>
                <td>${todo.startAmount}</td>
                <td>${todo.interest}</td>
                <td>${todo.balance}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form method="POST">
        <input class="btn btn-back" type="submit" value="Submit" />
    </form>
</div>
</body>
</html>
