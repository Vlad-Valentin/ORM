<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    <%@include file="/css/login.css" %>
</style>
<head>
    <title>Login</title>
    <%--        <jsp:include page="utils/bootstrap.jsp"/>--%>
    <link href="utils/button_link.css" rel="stylesheet" type="text/css">
    <link href="utils/layout.css" rel="stylesheet" type="text/css">
    <link href="utils/alert_box.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="wrapper">
    <h1 class="title">Login</h1>
    <form method="post" action="${pageContext.request.contextPath}/login">
        <div class="container-fluid">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon-1">@</span>
                </div>
                <input class="form-control" placeholder="What is your username?" name="username" type="text" required>
            </div>
            <input class="form-control" placeholder="Here goes your password." name="password" type="password" required>

            <%--    <button name="button" type="submit" value="login">Login</button>--%>
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <button class="btn btn-success btn-block" value="login" name="button" type="submit">Login</button>
                    <button class="btn btn-primary btn-block" name="button" type="submit" value="register">Register
                    </button>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
