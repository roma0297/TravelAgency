<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="header.jsp"/>


    <table style="margin: 10px; border: 1px solid black; padding: 10px;" rules = "all" >
        <tr>
            <th>ID</th>
            <th>Название тура</th>
            <th>Цена</th>
            <th>Описание</th>
            <th></th>
        </tr>
        <c:forEach items="${trips}" var = "trip">
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

    <form action="/add" method="POST" style="margin: 10px;">

        <table class="add-table" cellspacing="2">
            <tr>
                <td>Название: </td>
                <td><input name="title" type="text"></td>
                <td rowspan="13" style="margin:20px;"></td>
            </tr>
            <tr>
                <td>Цена: </td>
                <td><input name="price" type="text"></td>
                <td></td>
            </tr>
            <tr>
                <td>Короткое описание: </td>
                <td><input name="shortDescription" type="text"></td>
                <td></td>
            </tr>
            <tr>
                <td>Полное описание: </td>
                <td><input name="fullDescription" type="text"></td>
                <td></td>
            </tr>
            <tr>
                <td>Особенность 1: </td>
                <td><input name="feature1" type="text"></td>
                <td></td>
            </tr>
            <tr>
                <td>Особенность 2: </td>
                <td><input name="feature2" type="text"></td>
                <td></td>
            </tr>
            <tr>
                <td>Особенность 3: </td>
                <td><input name="feature3" type="text"></td>
                <td></td>
            </tr>
            <tr>
                <td>Особенность 4: </td>
                <td><input name="feature4" type="text"></td>
                <td></td>
            </tr>
            <tr>
                <td>Особенность 5: </td>
                <td><input name="feature5" type="text"></td>
                <td></td>
            </tr>
            <tr>
                <td>Картинка 1: </td>
                <td><input name="pictureUrl1" type="text"></td>
                <td></td>
            </tr>
            <tr>
                <td>Картинка 2: </td>
                <td><input name="pictureUrl2" type="text"></td>
                <td></td>
            </tr>
            <tr>
                <td>Картинка 3: </td>
                <td><input name="pictureUrl3" type="text"></td>
                <td></td>
            </tr>
            <tr>
                <td>Картинка 4: </td>
                <td><input name="pictureUrl4" type="text"></td>
                <td rowspan="13" style="margin:20px;"><input type="submit"></td>
            </tr>
        </table>
    </form>



    <jsp:include page="footer.jsp"/>
</body>
</html>
