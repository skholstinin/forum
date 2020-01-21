<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<t:base-page>
    <head>
        <title>Главная страница</title>
    </head>
    <body>
    <div style="text-align: center">
        <h1 align="center">Список тем форума</h1>
    </div>
    <sec:authorize access="hasAuthority(T(ru.testtask.security.Actions).ENABLE_MAINPAGE_VIEW)">
        <div class="col col-sm-9">
            <ol>
                <c:forEach var="topic" items="${topics}">
                    <li><a href="/topic/${topic.id}">${topic.title}</a></li>
                </c:forEach>
            </ol>
        </div>
        </body>

        <form method="post" action="/topic/${currentUser.id}/0">
            <input type="text" name="topicTitle" maxlength="100" value="">
            <input type="submit" name="btnAddArticle" value="Добавить">
        </form>
    </sec:authorize>
    </head>
    <body>
</t:base-page>
