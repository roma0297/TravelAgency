<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<jsp:include page="header.jsp"/>


<section class="hero u-text-center">
    <div class="hero-content">
        <h2 class="hero-content-title text mod-navy">
            Регистрация
        </h2>

        <hr class="mod-short mod-navy">

        <div class="info-box-container">
            <div class="info-box mod-white">
                <form action="addUser" method="post">
                    <p class="mod-uppercase" style="font-size: 20px; margin-bottom: 5px;">логин</p>
                    <input name="userName" type="text"><br>

                    <br>
                    <p class="mod-uppercase" style="font-size: 20px; margin-bottom: 5px;">пароль</p>
                    <input name="password" type="password"><br><br>
                    <input type="submit" style="font-size: 20px; margin: 5px;" value="Зарегистрироваться">
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="footer.jsp"/>
</body>
</html>
