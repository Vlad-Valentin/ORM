<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.tpd_client.controllers.HomeServlet" %>
<%@ page import="com.example.tpd_client.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.tpd_client.dal.UserProductDAO" %>
<%@ page import="com.example.tpd_client.dal.ProductDAO" %>
<html>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<style>
    <%@include file="/css/login.css" %>
    <%@include file="/css/home.css" %>
</style>
<head>
    <title>Welcome, <%= request.getSession().getAttribute("username")%>!</title>
</head>
<body>

<div>
    <form class="buttons-form" method="post" action="${pageContext.request.contextPath}/home">
        <button role="button" class="btn btn-warning btn-lg shadow-lg btn-login text-white text-bold" name="button"
                type="submit"
                value="logout">Logout
        </button>
    </form>
</div>

<div class="center mt-3">
    <h1 class="mt-3">
        Hello, <%= request.getSession().getAttribute("username")%>!
    </h1>
</div>

<div class="product-list">
    <h4 class="mb-3">These are your products listed for sale!</h4>
    <form method="post" action="${pageContext.request.contextPath}/home">
        <button role="button" class="btn btn-success btn-lg shadow-lg btn-register text-white text-bold mb-3"
                type="submit"
                name="button"
                value="manage-products">Add Product
        </button>
    </form>
    <table class="table table-hover table-striped table-dark">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <%
            if (request.getSession().getAttribute("errorMessage") == null) {
                int i = 1;
                int userId = (int) request.getSession().getAttribute("userId");
                List<Product> products = UserProductDAO.getProductsForUser(userId);
                for (Product product : products) {
        %>
        <tbody>
        <tr>
            <th scope="row"><%= product.getName()%>
            </th>
            <th scope="row"><%= product.getPrice()%>
            </th>
            <th scope="row">
                <form class="btn-delete-form" method="delete" action="${pageContext.request.contextPath}/home">
                    <button class="btn btn-danger btn-lg btn-register mt-3" name="delete" value="<%= product.getId() %>"
                            type="submit">Delete
                    </button>
                </form>
            </th>
        </tr>
        <%
            }
        } else {
        %>
        <div>
            <h1><%=request.getSession().getAttribute("errorMessage") %>
            </h1>
        </div>

        <%
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
