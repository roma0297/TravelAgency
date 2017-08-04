<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="../../styles/styles.css" type="text/css">

<header class="header">

    <c:if test="${lang == 'ru_RU'} eq ru_RU">
        русский
    </c:if>
    <c:if test="${lang == 'en_US'} eq en-EN">
        англ
    </c:if>
    <c:if test="${lang} eq de_DE">
        нем
    </c:if>

    <div class="header-wrapper">
        <a class="header-logo" href="trips" title="Couchsurfing">
            <img alt="Couchsurfing" src="../../pictures/logo.png" title="TravelAgency" height="35" width="400" />
        </a>
        <ul class="header-nav-buttons-list mod-logged-out">

            <li class="header-nav-buttons-list-item mod-inline-web mod-no-mobile mod-space header-language-dropdown">
                <!-- Language dropdown -->

                <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

                <script type='text/javascript'>
                    function changeLanguage(){
                        var selected = $('#locale').find('option[selected]');
                        if(selected.attr('id') == 'de'){alert(1);};
                        if(selected.attr('id') == 'en'){alert(2);};
                        if(selected.attr('id') == 'ru'){alert(3);};
                        location.reload();
                    };
                </script>


                <form action="changeLanuage" method="get">
                    <div class="select-dropdown">
                            <select id = "locale" class="select-dropdown__language" data-set-locale-path="/locale" id="locale" name="locale" onchange="this.form.submit()">
                                <option id="en" value="en_US">English</option>
                                <option id="ru" selected value="ru_RU">Русский</option>
                                <option id="de" value="de_DE">Deutsche</option>
                            </select>
                    </div>
                </form>
            </li>

            <li class="header-nav-buttons-list-item mod-inline-web mod-no-mobile mod-space">
                <a class="header-link header-nav-button mod-gray mod-uppercase" href="about">О нас</a>
            </li>

            <%--<li class="header-nav-buttons-list-item mod-inline-web mod-no-mobile mod-space">--%>
                <%--<a class="header-link header-nav-button mod-gray mod-uppercase" href="#trust-and-safety">Безопасность</a>--%>
            <%--</li>--%>

            <%--<li class="header-nav-buttons-list-item">--%>
                <%--<a class="header-nav-button button mod-join mod-small-min-width" data-amplitude-click="signup_modal" data-amplitude-properties="{&quot;source&quot;:&quot;homepage&quot;}" data-modal="true" href="/users/sign_up?join_source=header">Регистрация</a>--%>
            <%--</li>--%>

            <c:if test="${user == null}">
                <li class="header-nav-buttons-list-item">
                    <a class="header-nav-button button mod-join mod-small-min-width" data-amplitude-click="signup_modal" data-amplitude-properties="{&quot;source&quot;:&quot;homepage&quot;}" data-modal="true" href="signUp">Зарегистрироваться</a>
                </li>

                <li class="header-nav-buttons-list-item">
                    <a class="header-nav-button button mod-blue mod-outline mod-small-min-width" data-amplitude-click="login_modal" data-amplitude-properties="{&quot;source&quot;:&quot;homepage&quot;}" data-modal="true" href="/authentification">Вход</a>
                </li>
            </c:if>

            <c:if test="${role != null}">
                <li class="header-nav-buttons-list-item">
                    <a class="header-nav-button button mod-orange mod-small-min-width" data-amplitude-click="signup_modal" data-modal="true" href="admin">Администрирование</a>
                </li>
            </c:if>
            <c:if test="${user != null}">
                <li class="header-nav-buttons-list-item">
                    <a class="header-nav-button button mod-join mod-small-min-width" data-amplitude-click="signup_modal" data-amplitude-properties="{&quot;source&quot;:&quot;homepage&quot;}" data-modal="true" href="account">Аккаунт</a>
                </li>

                <li class="header-nav-buttons-list-item">
                    <a class="header-nav-button button mod-blue mod-outline mod-small-min-width" data-amplitude-click="login_modal" data-amplitude-properties="{&quot;source&quot;:&quot;homepage&quot;}" data-modal="true" href="logout">Выход</a>
                </li>
            </c:if>

        </ul>

    </div>
</header>