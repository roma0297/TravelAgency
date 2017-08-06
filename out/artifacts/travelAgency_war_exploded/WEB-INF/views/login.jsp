<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 03.08.17
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<%--<form action="login" method="post">--%>
<%--Input for username:<br>--%>
<%--<input name="username" type="text"><br>--%>
<%--Input for password:<br>--%>
<%--<input name="password" type="password"><br>--%>
<%--<input type="submit" value="Авторизироваться">--%>
<%--</form>--%>


<section class="hero u-text-center">
    <div class="hero-content">
        <h2 class="hero-content-title text mod-navy">
            Авторизация
        </h2>

        <hr class="mod-short mod-navy">

        <div class="info-box-container">
            <div class="info-box mod-white">
                <form action="login" method="post">
                    <p class="mod-uppercase" style="font-size: 20px; margin-bottom: 5px;">логин</p>
                    <input name="username" type="text"><br>

                    <br>
                    <p class="mod-uppercase" style="font-size: 20px; margin-bottom: 5px;">пароль</p>
                    <input name="password" type="password"><br><br>
                    <input type="submit" style="font-size: 20px; margin: 5px;" value="Войти">
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="footer.jsp"/>
</body>
</html>
