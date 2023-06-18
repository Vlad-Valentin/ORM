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
    <h1>Login</h1>
    <form method="post" action="${pageContext.request.contextPath}/login">
        <div class="container-fluid">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="basic-addon-1">@</span>
                </div>
                <input class="form-control shadow-sm" placeholder="What is your username?" name="username" type="text"
                       required>
            </div>

            <div class="input-group mb-3">
                <input class="form-control shadow-sm" placeholder="Here goes your password." name="password"
                       type="password" required>
            </div>

            <div class="row justify-content-center all-buttons">
                <div class="col-md-6">
                    <div class="d-flex justify-content-between">
                        <button class="btn btn-success shadow-lg btn-login text-bold" value="login" name="button"
                                type="submit">Login
                        </button>
                        <div class="mx-2"></div>
                        <button class="btn btn-primary shadow-lg btn-register text-bold" name="button" type="submit"
                                value="register">Register
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
