<%--
  Created by IntelliJ IDEA.
  User: Salil's Alienware
  Date: 11/12/2020
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
  <title>Book Store App</title>
  <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
</head>
<body>

<header>
  <nav class="navbar navbar-expand-md navbar-dark"
       style="background-color: chocolate">
    <div>
      <a href="<%=request.getContextPath()%>" class="navbar-brand"> Book Store App </a>
    </div>

    <ul class="navbar-nav">
      <li><a href="<%=request.getContextPath()%>/list"
             class="nav-link">Books</a></li>
    </ul>
  </nav>
</header>
<br>
<div class="row">
  <div class="container">
    <h3 class="text-center">List of Books</h3>
    <hr>
    <div class="container text-left">
      <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
        New Book</a>
    </div>
    <br>
    <table class="table table-bordered">
      <thead>
      <tr>
        <th>Book ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Price</th>
        <th>Configure</th>
        <th>Cart Option</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="book" items="${listBook}">
        <tr>
          <td><c:out value="${book.bookId}" /></td>
          <td><c:out value="${book.title}" /></td>
          <td><c:out value="${book.author}" /></td>
          <td><c:out value="${book.price}" /></td>
          <td><a href="edit?id=<c:out value='${book.bookId}' />">Edit</a>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="delete?id=<c:out value='${book.bookId}' />">Delete</a></td>
          <td><a href="addtocart?id=<c:out value='${book.bookId}' />">Add to Cart</a></td>
        </tr>
      </c:forEach>
      <!-- } -->
      </tbody>

    </table>

  </div>
</div>
</body>
</html>