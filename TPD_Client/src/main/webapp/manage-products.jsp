<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
    <style>
        <%@include file="/css/manage-products.css" %>
    </style>
</head>
<body>
<div class="wrapper">
    <h1>Product management page for user <%= request.getSession().getAttribute("username")%>
    </h1>
    <div class="add-product">
        <h2>Products</h2>
        <form method="post" action="${pageContext.request.contextPath}/manage-products">
            <table>
                <tr>
                    <td>
                        <label>Name: </label>
                        <input class="form-control" placeholder="Enter the product name..." name="name" type="text">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Price: </label>
                        <input class="form-control" placeholder="Enter the price..." name="price" type="number">
                    </td>
                </tr>
            </table>
            <div class="buttons">
                <button class="form-button" name="button" type="submit" value="add-product">Add Product</button>
                <button role="button" class="form-button" name="button" type="submit" value="home">Back</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
