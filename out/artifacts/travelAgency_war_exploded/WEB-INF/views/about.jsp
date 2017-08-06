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
    <title>О нас</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/header.jsp"/>

<section class="hero mod-how-it-works">
    <div class="hero-content">
        <h2 class="hero-content-title">
            О нас
        </h2>

        <hr class="mod-short mod-white"/>

        <div class="info-box-container">

            <div class="info-box mod-orange">
                <article>
                    <img alt="Discover amazing people 75ec5628b259a817d9389816d8b3b9c8369d87c524f0fc29f5fd81d7bdb462e5"
                         class="mod-center mod-margin-bottom"
                         src="https://assets.couchsurfing.com/assets/icons/discover-amazing-people-75ec5628b259a817d9389816d8b3b9c8369d87c524f0fc29f5fd81d7bdb462e5.png"/>

                    <h3 class="info-box-title">
                        Удобство
                    </h3>
                    <hr class="mod-short mod-white"/>
                    <p>
                        На одном сайте в режиме онлайн, не выходя из дома или офиса, Вы сможете планировать своё
                        путешествие в любую точку планеты. От готового путешествия Вас отделяет всего несколько простых
                        шагов!
                    </p>
                </article>
            </div>

            <div class="info-box mod-orange">
                <article>
                    <img alt="Book a stay 64b707177c5c69aa958920761cdd560d7ced3edf3ca7c09c91155c2863f5bdc8"
                         class="mod-center mod-margin-bottom"
                         src="https://assets.couchsurfing.com/assets/icons/book-a-stay-64b707177c5c69aa958920761cdd560d7ced3edf3ca7c09c91155c2863f5bdc8.png"/>
                    <h3 class="info-box-title">Выбор</h3>
                    <hr class="mod-short mod-white"/>
                    <p>
                        Самостоятельно составить свой туристический маршрут теперь действительно просто — наконец, Вы
                        можете почувствовать себя свободным человеком, хозяином жизни, перед которым открыты границы
                        целого мира!
                    </p>
                </article>
            </div>

            <div class="info-box mod-orange">
                <article>
                    <img alt="Join events 23ca802d7e5993838f1122d360dc35b3ef00291507a9a960b435d116baf30979"
                         class="mod-center mod-margin-bottom"
                         src="https://assets.couchsurfing.com/assets/icons/join-events-23ca802d7e5993838f1122d360dc35b3ef00291507a9a960b435d116baf30979.png"/>
                    <h3 class="info-box-title">
                        Безопасность
                    </h3>
                    <hr class="mod-short mod-white"/>
                    <p>
                        Мы даем гарантию на то, что Вы будете зарегистрированы на рейс, тур или в гостинице по
                        электронному билету/ваучеру.
                    </p>
                </article>
            </div>
        </div>
    </div>
</section>


<section class="hero mod-how-it-works-green">
    <div class="hero-content">
        <h2 class="hero-content-title">
            Отзывы
        </h2>

        <hr class="mod-short mod-white"/>

        <div class="info-box-container">

            <div class="info-box mod-green">
                <article>
                    <img alt="Discover amazing people 75ec5628b259a817d9389816d8b3b9c8369d87c524f0fc29f5fd81d7bdb462e5"
                         class="mod-center mod-margin-bottom"
                         src="http://x-lines.ru/letters/i/cyrillicfancy/0376/ffffff/34/0/4ncpbf6o1mejmwfb4ntpbggoih.png"/>

                    <h3 class="info-box-title">
                        <%--Познакомьтесь с классными людьми--%>
                    </h3>
                    <hr class="mod-short mod-white"/>
                    <p>
                        "Лучший портал для планирования путешествий."
                    </p>
                </article>
            </div>

            <div class="info-box mod-green">
                <article>
                    <img alt="Book a stay 64b707177c5c69aa958920761cdd560d7ced3edf3ca7c09c91155c2863f5bdc8"
                         class="mod-center mod-margin-bottom"
                         src="http://x-lines.ru/letters/i/cyrillicbasic/0004/ffffff/34/0/4nq7b8so1mejbwfxrdej8wro4nm7bfqowmejy.png"/>
                    <%--<h3 class="info-box-title">Найти хоста</h3>--%>
                    <hr class="mod-short mod-white"/>
                    <p>
                        Офигенный портал
                    </p>
                </article>
            </div>

            <div class="info-box mod-green">
                <article>
                    <img alt="Join events 23ca802d7e5993838f1122d360dc35b3ef00291507a9a960b435d116baf30979"
                         class="mod-center mod-margin-bottom"
                         src="http://x-lines.ru/letters/i/cyrillicfancy/0376/ffffff/34/0/4ne7dy6ozuembwfu4nay.png"/>
                    <h3 class="info-box-title">
                        <%--Принять участие в мероприятиях--%>
                    </h3>
                    <hr class="mod-short mod-white"/>
                    <p>
                        Знакомьтесь с путешественниками в других городах или в вашем родном городе! Поблизости всегда
                        происходит что-то интересное!
                    </p>
                </article>
            </div>
        </div>
    </div>
</section>


<section class="hero u-text-center">
    <div class="hero-content">
        <h2 class="hero-content-title text mod-navy">
            Мы предлагаем:
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

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>
