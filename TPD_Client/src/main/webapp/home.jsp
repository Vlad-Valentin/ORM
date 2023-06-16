<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.tpd_client.controllers.HomeServlet" %>
<%@ page import="com.example.tpd_client.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.tpd_client.data_access.UserProductDAO" %>
<%@ page import="com.example.tpd_client.data_access.ProductDAO" %>
<html>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
    <%@include file="/css/home.css" %>
</style>
<head>
    <title>Title</title>
</head>
<body>

<div class="center">
    <h1>
        Hello, <%= request.getSession().getAttribute("username")%>!
    </h1>
</div>

<div class="product-list">
    <h3>These are your products listed for sale!</h3>
    <div class="table">

        <div class="row header blue">
            <div class="cell">
                #
            </div>
            <div class="cell">
                Name
            </div>
            <div class="cell">
                Price
            </div>
            <div class="cell">
                Delete
            </div>
        </div>
        <%
            if (request.getSession().getAttribute("errorMessage") == null) {
                int i = 1;
                int userId = (int) request.getSession().getAttribute("userId");
                List<Product> products = UserProductDAO.getProductsForUser(userId);
                for (Product product : products) {
        %>
        <div class="row">
            <div class="cell" data-title="#"><%= i++%>
            </div>
            <div class="cell" data-title="Name"><%= product.getName()%>
            </div>
            <div class="cell" data-title="Price"><%= product.getPrice()%>
            </div>
            <div class="cell" data-title="Delete">
                <form method="delete" action="${pageContext.request.contextPath}/home">
                    <button name="delete" value="<%= product.getId() %>" type="submit"><span
                            class="delete-span"> X </span></button>
                </form>
            </div>
        </div>
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


    </div>
</div>
<div class="buttons">
    <form method="post" class="buttons-form" action="${pageContext.request.contextPath}/home">
        <button role="button" class="blue-button" name="button" type="submit" value="logout">Log out</button>
        <button role="button" class="button-orange" type="submit" name="button" value="manage-products">Manage
            product list
        </button>
    </form>
</div>
</body>
</html>
