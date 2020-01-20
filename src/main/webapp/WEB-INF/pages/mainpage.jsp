<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<tags:base-page>
    <head>
        <title>Главная страница</title>
    </head>
    <body>
    <div style="text-align: center">
        <h1 align="center">Список тем форума</h1>
    </div>

    <div class="col col-sm-9">
        <div class="card-columns">
            <sec:authorize access="hasAuthority(T(ru.testtask.security.Actions).ENABLE_MAINPAGE_VIEW)">
                <c:forEach var="topic" items="${topics}">
                    <div>
                        <ol>
                            <li>
                                <a href="/topic/${topic.id}">${topic.title}</a>
                            </li>
                        </ol>
                    </div>
                </c:forEach>
            </sec:authorize>
        </div>
    </div>
    </body>

    <script type="text/javascript">
        function show_prompt() {
            var name = prompt("Введите название темы", "Название");
            if (name != null && name != "") {
                document.location.href = "/createtopic";
            }
        }
    </script>
    </head>
    <body>

    <input type="button" onclick="show_prompt()" value="Новая тема"/>

</tags:base-page>
