<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="../../scripts/addTextFields.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>

<table style="margin: 10px; border: 1px solid black; padding: 10px;" rules="all">
    <tr>
        <th>ID</th>
        <th>Название тура</th>
        <th>Цена</th>
        <th>Описание</th>
        <th></th>
    </tr>
    <c:forEach items="${trips}" var="trip">
        <tr>
            <td>${trip.id}</td>
            <td><c:out value="${trip.title}"/></td>
            <td><c:out value="${trip.price}"/></td>
            <td><c:out value="${trip.shortDescription}"/></td>
            <td><a href="delete?id=${trip.id}">удалить</a></td>
        </tr>

    </c:forEach>
</table>

<h2>Добавление новой записи: </h2>
<form action="/add" method="POST" style="margin: 10px;" accept-charset="unicode">

    <table class="add-table" cellspacing="2">
        <tr>
            <td>Название:</td>
            <td><input name="title" type="text"></td>
            <td rowspan="13" style="margin:20px;"></td>
        </tr>
        <tr>
            <td>Цена:</td>
            <td><input name="price" type="text"></td>
            <td></td>
        </tr>
        <tr>
            <td>Короткое описание:</td>
            <td><input name="shortDescription" type="text"></td>
            <td></td>
        </tr>
        <tr>
            <td>Полное описание:</td>
            <td><input name="fullDescription" type="text"></td>
            <td></td>
        </tr>
        <tr class="last_feature">
            <td>Особенность 1:</td>
            <td><input name="feature1" type="text"></td>
            <td class="add_delete_feature_buttons"><input class="button manage-mod-green mod-small-min-width"
                                                          type="button" value="+" id="feature_added"
                                                          onclick="addFeatureTextField()"></td>
        </tr>

        <tr id="picture_1" class="last_picture">
            <td>Картинка 1:</td>
            <td><input name="pictureUrl1" type="text"></td>
            <td class="add_delete_picture_buttons"><input class="button manage-mod-green mod-small-min-width"
                                                          type="button" id="picture_added" value="+"
                                                          onclick="addPictureURLTextField()"></td>
        </tr>

        <tr id="last_row">
            <td></td>
            <td></td>
            <td><input id="sumbit_button" type="submit"></td>
        </tr>
    </table>
</form>


<jsp:include page="footer.jsp"/>
</body>
</html>
