<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous"></script>
    <style>
        <%@include file="/css/login.css" %>
        <%@include file="/css/manage-products.css" %>
    </style>
</head>
<body>
<div class="wrapper">
    <h1>What are you selling today, <%= request.getSession().getAttribute("username")%>?</h1>
    <form method="post" action="${pageContext.request.contextPath}/manage-products">
        <div class="container-fluid">
            <div class="input-group mb-3">
                <input class="form-control shadow-sm" placeholder="Enter the product name..." name="name" type="text">
            </div>

            <div class="input-group mb-3">
                <input class="form-control shadow-sm" placeholder="Enter the price..." name="price" type="number" min="1">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon-1">$</span>
                </div>
            </div>

            <div class="row justify-content-center all-buttons">
                <div class="col-md-6">
                    <div class="d-flex justify-content-between">
                        <button class="btn btn-success btn-lg btn-login shadow-lg text-bold" name="button" type="submit"
                                value="add-product">Add
                        </button>
                        <div class="mx-2"></div>
                        <button role="button" class="btn btn-warning btn-lg shadow-lg btn-register text-white text-bold" name="button"
                                type="submit" value="home">Back
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
