<%--
  Created by IntelliJ IDEA.
  User: Salil's Alienware
  Date: 11/13/2020
  Time: 12:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>User Management Application</title>
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
            <a href="<%=request.getContextPath()%>" class="navbar-brand"> Book Store App</a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Books</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${book != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${book == null}">
                <form action="insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${book != null}">
                                Edit Book
                            </c:if>
                            <c:if test="${book == null}">
                                Add New Book
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${book != null}">
                        <input type="hidden" name="id" value="<c:out value='${book.id}' />" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>Book Title</label> <input type="text"
                                                        value="<c:out value='${book.title}' />" class="form-control"
                                                        name="title" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Book Author</label> <input type="text"
                                                         value="<c:out value='${book.author}' />" class="form-control"
                                                         name="author">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Book Price</label> <input type="text"
                                                           value="<c:out value='${user.price}' />" class="form-control"
                                                           name="price">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>