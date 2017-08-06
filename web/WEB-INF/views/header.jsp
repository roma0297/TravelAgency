<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=utf-8" language="java" %>

<link rel="stylesheet" href="../../styles/styles.css" type="text/css">

<header class="header">

    <fmt:setBundle basename="locale"/>
    <c:if test="${cookie.locale eq ru_RU}">
        <fmt:setLocale value="ru_RU"/>
    </c:if>
    <c:if test="${cookie.locale eq en_US}">
        <fmt:setLocale value="en_US"/>
    </c:if>
    <c:if test="${cookie.locale eq de_DE}">
        <fmt:setLocale value="de_DE"/>
    </c:if>
    <c:if test="${empty cookie.locale}">
        <fmt:setLocale value="ru_RU"/>
    </c:if>

    <div class="header-wrapper">
        <a class="header-logo" href="trips" title="Couchsurfing">
            <img alt="Couchsurfing" src="../../pictures/logo.png" title="TravelAgency" height="35" width="400"/>
        </a>
        <ul class="header-nav-buttons-list mod-logged-out">

            <li class="header-nav-buttons-list-item mod-inline-web mod-no-mobile mod-space header-language-dropdown">

                <%--<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>--%>
                <script>
                    function onChange() {
                        var n = document.getElementById("locale").options.selectedIndex;
                        //document.getElementById("locale").options[n].selected=true;

                        switch (n) {
                            case 0:
                                document.cookie = 'locale = ru_RU';
                                break;
                            case 1:
                                document.cookie = 'locale = en_US';
                                break;
                            case 2:
                                document.cookie = 'locale = de_DE';
                                break;
                            default:
                                document.cookie = 'locale = ru_RU';
                        }
                        location.reload();
                    }
                </script>

                <div class="select-dropdown">
                    <select id="locale" class="select-dropdown__language" data-set-locale-path="/locale" id="locale"
                            name="locale" onchange="onChange();">
                        <option value="ru_RU">Русский</option>
                        <option value="en_US">English</option>
                        <option value="de_DE">Deutsche</option>
                    </select>
                </div>

            </li>

            <li class="header-nav-buttons-list-item mod-inline-web mod-no-mobile mod-space">
                <a class="header-link header-nav-button mod-gray mod-uppercase" href="about">О нас</a>
            </li>

            <c:if test="${user == null}">
                <li class="header-nav-buttons-list-item">
                    <a class="header-nav-button button mod-join mod-small-min-width" data-amplitude-click="signup_modal"
                       data-amplitude-properties="{&quot;source&quot;:&quot;homepage&quot;}" data-modal="true"
                       href="signUp">Зарегистрироваться</a>
                </li>

                <li class="header-nav-buttons-list-item">
                    <a class="header-nav-button button mod-blue mod-outline mod-small-min-width"
                       data-amplitude-click="login_modal"
                       data-amplitude-properties="{&quot;source&quot;:&quot;homepage&quot;}" data-modal="true"
                       href="/authentification">Вход</a>
                </li>
            </c:if>

            <c:if test="${role eq 'admin'}">
                <li class="header-nav-buttons-list-item">
                    <a class="header-nav-button button manage-mod-green mod-small-min-width"
                       data-amplitude-click="signup_modal" data-modal="true" href="admin">Администрирование</a>
                </li>
            </c:if>
            <c:if test="${user != null}">
                <li class="header-nav-buttons-list-item">
                    <a class="header-nav-button button mod-join mod-small-min-width" data-amplitude-click="signup_modal"
                       data-amplitude-properties="{&quot;source&quot;:&quot;homepage&quot;}" data-modal="true"
                       href="account">Аккаунт</a>
                </li>

                <li class="header-nav-buttons-list-item">
                    <a class="header-nav-button button mod-blue mod-outline mod-small-min-width"
                       data-amplitude-click="login_modal"
                       data-amplitude-properties="{&quot;source&quot;:&quot;homepage&quot;}" data-modal="true"
                       href="logout">Выход</a>
                </li>
            </c:if>

        </ul>

    </div>
</header>