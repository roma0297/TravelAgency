<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 02.08.17
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<style type="text/css">

    .table_price {
        margin-left: 30px;
    }

    .table_price caption {
        background: #F79361;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px;
        padding: 10px;
        box-shadow: 0 2px 4px 0 rgba(0, 0, 0, .3);
        color: white;
        font-family: "Roboto Slab", serif;
        font-style: normal;
        font-size: 26px;
        text-align: center;
        margin: 0;
    }

    .table_price td, .table_price th {
        padding: 10px;
    }

    .table_price th {
        text-align: left;
        font-size: 18px;
    }

    .table_price tr:nth-child(2n) {
        background: #E5E5E5;
    }

    .table_price td:last-of-type {
        text-align: center;
    }

    /*.table_price a {*/
    /*display: inline-block;*/
    /*padding: 5px 10px;*/
    /*background: #F79361;*/
    /*box-shadow: 2px 2px 0 0 #a22800;*/
    /*position: relative;*/
    /*}*/
    /*.table_price a:hover {*/
    /*box-shadow: none;*/
    /*top: 2px;*/
    /*left: 2px;*/
    /*}*/
</style>


<section class="hero u-text-center">
    <div class="hero-content">
        <h2 class="hero-content-title text mod-navy">
            Корзина
        </h2>

        <hr class="mod-short mod-navy">

        <div class="info-box-container">
            <c:if test="${isEmpty != null}">
                <div class="info-box mod-white">
                    <h3 class="info-box-title mod-large mod-tight">
                        <span class="mod-uppercase">Ваша корзина пуста</span>
                    </h3>
                </div>
            </c:if>

            <c:if test="${isEmpty == null}">
                <div class="info-box mod-white">
                    <table class="table_price mod-center-align -center-feature">
                        <tr>
                            <th colspan="2">Путешествие</th>
                            <th>Стоимость</th>
                            <th>Описание</th>
                            <th></th>
                        </tr>

                        <c:forEach items="${cart}" var="trip">
                            <tr>
                                    <%--<td><img src="https://html5book.ru/wp-content/uploads/2015/04/dress-2.png"></td>--%>
                                <td></td>
                                <td>${trip.title}</td>
                                <td>${trip.price}</td>
                                <td>${trip.shortDescription}</td>
                                <td><a href="deleteFromCart?id=${trip.id}">удалить</a></td>
                                    <%--<td>1</td>--%>
                                    <%--<td>2500</td>--%>
                            </tr>
                        </c:forEach>
                    </table>
                </div>


                <div class="info-box mod-white">
                        <%--<h3 class="info-box-title mod-large mod-tight">--%>
                        <%--<span class="mod-uppercase">135 <small></small></span>--%>
                        <%--</h3>--%>

                        <%--<p><span class="mod-large">туров по акции</span></p>--%>

                    <div class="header-nav-buttons-list-item" style="padding: 50% 0;">
                        <a class="pay-button" data-amplitude-click="login_modal"
                           data-amplitude-properties="{&quot;source&quot;:&quot;homepage&quot;}" data-modal="true"
                           href="pay">Оплатить</a>
                    </div>
                </div>
            </c:if>

        </div>
    </div>
</section>


<section class="hero u-text-center">
    <div class="hero-content">
        <h2 class="hero-content-title text mod-navy">
            Покупки
        </h2>

        <hr class="mod-short mod-navy">

        <div class="info-box mod-white">
            <table class="table_price mod-center-align -center-feature">
                <c:forEach var="purchase" items="${oldPurchases}">
                    <tr>
                        <td>${purchase.title}</td>
                        <td>${purchase.price}</td>
                        <td>${purchase.shortDescription}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</section>

<jsp:include page="footer.jsp"/>
</body>
</html>