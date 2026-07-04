<%@ page import="model.Book" %>

<%
    Book book = (Book) request.getAttribute("book");
%>

<!DOCTYPE html>

<html>

<head>
    <title>Edit Book</title>
</head>

<body>

<h1>Edit Book</h1>

<form action="update-book" method="post">

    <input type="hidden"
           name="id"
           value="<%= book.getId() %>">

    <label>Title</label><br>
    <input type="text"
           name="title"
           value="<%= book.getTitle() %>">

    <br><br>

    <label>Author</label><br>
    <input type="text"
           name="author"
           value="<%= book.getAuthor() %>">

    <br><br>

    <label>Category</label><br>
    <input type="text"
           name="category"
           value="<%= book.getCategory() %>">

    <br><br>

    <label>Price</label><br>
    <input type="number"
           step="0.01"
           name="price"
           value="<%= book.getPrice() %>">

    <br><br>

    <label>Quantity</label><br>
    <input type="number"
           name="quantity"
           value="<%= book.getQuantity() %>">

    <br><br>

    <input type="submit"
           value="Update Book">

</form>

</body>

</html>