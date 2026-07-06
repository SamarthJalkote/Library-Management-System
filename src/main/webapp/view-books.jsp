<%@ page import="java.util.List" %>
<%@ page import="model.Book" %>
<%@ include file="navbar.jsp" %>

<html>
<head>
    <title>View Books</title>
</head>

<body>

<form action="search-book" method="get">

    <input
            type="text"
            name="keyword"
            placeholder="Search by Title">

    <input
            type="submit"
            value="Search">

</form>

<br>

<h1>All Books</h1>
<%
    String message = request.getParameter("message");

    if(message != null){
%>

<p style="color:green;font-weight:bold;">
    <%= message %>
</p>

<%
    }
%>

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

        if (books == null) {
            response.sendRedirect("view-books");
            return;
        }

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

            <a href="edit-book?id=<%= book.getId() %>">
                Edit
            </a>

            &nbsp;|&nbsp;

            <a href="delete-book?id=<%= book.getId() %>"
               onclick="return confirm('Are you sure you want to delete this book?')">
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