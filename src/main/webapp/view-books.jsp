<%@ page import="java.util.List" %>
<%@ page import="model.Book" %>

<html>
<head>
    <title>View Books</title>
</head>

<body>

<h1>All Books</h1>

<table border="1">

    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Category</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Action</th>
    </tr>

    <%
        List<Book> books = (List<Book>) request.getAttribute("books");

        for(Book book : books){
    %>

    <tr>

        <td><%= book.getId() %></td>

        <td><%= book.getTitle() %></td>

        <td><%= book.getAuthor() %></td>

        <td><%= book.getCategory() %></td>

        <td><%= book.getPrice() %></td>

        <td><%= book.getQuantity() %></td>

        <td>
            <a href="delete-book?id=<%= book.getId() %>">
                Delete
            </a>
        </td>

    </tr>

    <%
        }
    %>

</table>

</body>
</html>