<%--
  Created by IntelliJ IDEA.
  User: nmtu3
  Date: 2021-08-12
  Time: 4:37 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Record</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>

<div class="container">
    <h1>Add an entry</h1>
    <form method="POST">
        <fieldset class="form-group">
            <label> Customer Number:</label>
            <input name="customerNumber" type="text" class="form-control" required />

        </fieldset>


        <fieldset class="form-group">
            <label> Customer Name :</label>
            <input name="customerName" type="text" class="form-control" required />

        </fieldset>

        <fieldset class="form-group">
            <label> Customer Initial Deposit :</label>
            <input name="customerDeposit" type="text" class="form-control" required />

        </fieldset>

        <fieldset class="form-group">
            <label> Number of years :</label>
            <input name="year" type="text" class="form-control" required />

        </fieldset>

        <fieldset class="form-group">
            <label> Savings Type :</label>
            <select name="savingType" class="form-control" required >
                <option value="Savings-Deluxe">Savings-Deluxe</option>
                <option value="Savings-Regular">Savings-Regular</option>
            </select>

        </fieldset>
        <input class="btn btn-success" type="submit" value="Submit" />
    </form>

</div>


<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>


</body>
</html>
