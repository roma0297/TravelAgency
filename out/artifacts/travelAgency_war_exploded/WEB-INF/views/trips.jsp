<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<c:forEach items="${trips}" var="trip">
    <div class="product-item">
        <img class="small-image" src="../../pictures/${trip.pictureURLs[0]}">
        <div class="product-list">
            <h3 class="info-box-title mod-large mod-tight">${trip.title}</h3>
            <span class="price mod-uppercase">${trip.price}</span>
            <div class="mod-margin-top mod-buttons u-text-center">
                <a style="margin-top: -25px" class="button mod-couchsurfing mod-homepage mod-over-image"
                   data-amplitude-click="join" data-amplitude-properties="{&quot;type&quot;:&quot;plan_trip&quot;}"
                   data-modal="true" href="/trip?id=${trip.id}">Спланировать поездку</a>
            </div>
        </div>
    </div>
</c:forEach>

<jsp:include page="footer.jsp"/>
</body>
</html>
