<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 02.08.17
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="header.jsp"/>


<section class="hero u-text-center">
    <div class="hero-content">
        <%--<h2 class="hero-content-title text mod-navy">--%>
            <%--${trip.title}--%>
        <%--</h2>--%>

        <%--<hr class="mod-short mod-navy">--%>

        <div class="info-box-container">

            <div class="info-box mod-white">

                <ul class="carousel-container">
                    <li><input type="radio" name="carousel-toggle" checked="checked" id="carousel-tab-0" hidden="hidden"
                               class="carousel-toggle"/><label for="carousel-tab-0" class="dot"></label>
                        <ul class="carousel-content">
                            <li><img src="../../pictures/${trip.pictureUrl1}"/><label for="carousel-tab-9"
                                                                                      class="arrow back"></label><label
                                    for="carousel-tab-1" class="arrow next"></label></li>
                        </ul>
                    </li>
                    <li><input type="radio" name="carousel-toggle" id="carousel-tab-1" hidden="hidden"
                               class="carousel-toggle"/><label for="carousel-tab-1" class="dot"></label>
                        <ul class="carousel-content">
                            <li><img src="../../pictures/${trip.pictureUrl2}"/><label for="carousel-tab-0"
                                                                                      class="arrow back"></label><label
                                    for="carousel-tab-2" class="arrow next"></label></li>
                        </ul>
                    </li>
                    <li><input type="radio" name="carousel-toggle" id="carousel-tab-2" hidden="hidden"
                               class="carousel-toggle"/><label for="carousel-tab-2" class="dot"></label>
                        <ul class="carousel-content">
                            <li><img src="../../pictures/${trip.pictureUrl3}"/><label for="carousel-tab-1"
                                                                                      class="arrow back"></label><label
                                    for="carousel-tab-3" class="arrow next"></label></li>
                        </ul>
                    </li>
                    <li><input type="radio" name="carousel-toggle" id="carousel-tab-3" hidden="hidden"
                               class="carousel-toggle"/><label for="carousel-tab-3" class="dot"></label>
                        <ul class="carousel-content">
                            <li><img src="../../pictures/${trip.pictureUrl4}"/><label for="carousel-tab-2"
                                                                                      class="arrow back"></label><label
                                    for="carousel-tab-4" class="arrow next"></label></li>
                        </ul>
                    </li>

                </ul>
            </div>

            <div class="info-box mod-white">
                <h3 class="hero-content-title text mod-navy">${trip.title}</h3>
                <hr class="mod-short mod-navy">

                <div class="mod-margin-top mod-buttons u-text-center">
                    <a style="align:bottom; margin-top: -25px" class="button mod-couchsurfing mod-homepage mod-over-image" data-amplitude-click="join" data-amplitude-properties="{&quot;type&quot;:&quot;plan_trip&quot;}" data-modal="true" href="/addToCart?id=${trip.id}">Купить</a>
                </div>
            </div>
        </div>
    </div>
</section>


<section class="hero mod-how-it-works">
    <div class="hero-content">
        <h2 class="hero-content-title">
            Описание
        </h2>

        <hr class="mod-short mod-white"/>

        <div class="info-box-container">

            <div class="info-box mod-orange">
                <article>
                    <%--<img alt="Join events 23ca802d7e5993838f1122d360dc35b3ef00291507a9a960b435d116baf30979" class="mod-center mod-margin-bottom" src="https://assets.couchsurfing.com/assets/icons/join-events-23ca802d7e5993838f1122d360dc35b3ef00291507a9a960b435d116baf30979.png" />--%>
                    <%--<h3 class="info-box-title">--%>
                    <%--Безопасность--%>
                    <%--</h3>--%>
                    <%--<hr class="mod-short mod-white"/>--%>
                    <h3>
                        ${trip.fullDescription}
                    </h3>
                </article>
            </div>
        </div>
    </div>
</section>


<section class="hero mod-how-it-works-blue">
    <div class="hero-content">
        <h2 class="hero-content-title">
            Детали
        </h2>

        <hr class="mod-short mod-white"/>

        <div class="info-box-container">

            <div class="info-box mod-blue">
                <article>
                    <%--<img alt="Join events 23ca802d7e5993838f1122d360dc35b3ef00291507a9a960b435d116baf30979" class="mod-center mod-margin-bottom" src="http://x-lines.ru/letters/i/cyrillicfancy/0376/ffffff/34/0/4ne7dy6ozuembwfu4nay.png" />--%>
                    <%--<h3 class="info-box-title">--%>
                    <%--&lt;%&ndash;Принять участие в мероприятиях&ndash;%&gt;--%>
                    <%--</h3>--%>
                    <%--<hr class="mod-short mod-white"/>--%>
                    <%--<p>--%>
                    <%--Знакомьтесь с путешественниками в других городах или в вашем родном городе! Поблизости всегда происходит что-то интересное!--%>
                    <%--</p>--%>
                    <p>
                    <ul class="push">
                        <li>${trip.feature1}</li>
                        <li>${trip.feature2}</li>
                        <li>${trip.feature3}</li>
                        <li>${trip.feature4}</li>
                        <li>${trip.feature5}</li>
                    </ul>
                    </p>
                </article>
            </div>
        </div>
    </div>
</section>


<section class="hero u-text-center">
    <div class="hero-content">
        <h2 class="hero-content-title text mod-navy">
            ${trip.title}
        </h2>

        <hr class="mod-short mod-navy">

        <div class="info-box-container">
            <div class="info-box mod-white">
                <h3 class="info-box-title mod-large mod-tight">
                    1,200
                </h3>

                <p><span class="mod-large">направлений</span></p>
            </div>

            <div class="info-box mod-white">
                <h3 class="info-box-title mod-large mod-tight">
                    <span class="mod-uppercase">7 <small>тысяч</small></span>
                </h3>

                <p><span class="mod-large">туров</span></p>
            </div>

            <div class="info-box mod-white">
                <h3 class="info-box-title mod-large mod-tight">
                    <span class="mod-uppercase">135 <small></small></span>
                </h3>

                <p><span class="mod-large">туров по акции</span></p>
            </div>
        </div>
    </div>
</section>

    <jsp:include page="footer.jsp"/>
</body>
</html>
