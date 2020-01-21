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

        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                var dialog, form,
                    topicTitle = $("#topicTitle"),
                    allFields = $([]).add(topicTitle);

                function addTopic() {
                    var valid = true;
                    $(post).append("<tr>" +
                        "<td>" + topicTitle.val() + "</td>" +
                        "</tr>");
                    dialog.dialog("close");
                    return valid;
                }

                dialog = $("#dialog-form").dialog({
                    autoOpen: false,
                    height: 400,
                    width: 350,
                    modal: true,
                    buttons: {
                        "Create a new topic": addTopic,
                        Cancel: function () {
                            dialog.dialog("close");
                        }
                    },
                    close: function () {
                        form[0].reset();
                        allFields.removeClass("ui-state-error");
                    }
                });
                form = dialog.find("form").on("submit", function (event) {
                    event.preventDefault();
                    addTopic();
                });
                $("#create-topic").button().on("click", function () {
                    dialog.dialog("open");
                });
            });
        </script>
        <body>
        <div id="dialog-form" title="Создание новой темы">
            <form>
                <fieldset>
                    <label for="topicTitle">Название</label>
                    <input type="text" name="topicTitle" id="topicTitle" value="Название темы"
                           class="text ui-widget-content ui-corner-all">
                    <!-- Allow form submission with keyboard without duplicating the dialog button -->
                    <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
                </fieldset>
            </form>
        </div>
        <button id="create-topic">Создать тему</button>
        </body>

        </body>


    </sec:authorize>
    </head>
    <body>
</t:base-page>

