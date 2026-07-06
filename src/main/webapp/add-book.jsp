
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="navbar.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Book</title>
</head>
<body>

<h1>Add New Book</h1>

<form action="add-book" method="post">

    <label>Title:</label><br>
    <input type="text" name="title"><br><br>

    <label>Author:</label><br>
    <input type="text" name="author"><br><br>

    <label>Category:</label><br>
    <input type="text" name="category"><br><br>

    <label>Price:</label><br>
    <input type="number" step="0.01" name="price"><br><br>

    <label>Quantity:</label><br>
    <input type="number" name="quantity"><br><br>

    <input type="submit" value="Add Book">

</form>

</body>
</html>