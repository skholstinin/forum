<%@ tag description="Simple Wrapper Tag" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <title>Форум</title>

  <spring:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" var="bootstrapCss"/>
  <spring:url value="/resources/css/base.css" var="baseCss"/>

  <!-- Bootstrap core CSS -->
  <link href="${bootstrapCss}" rel="stylesheet"/>

  <!-- Custom styles  -->
  <link href="${baseCss}" rel="stylesheet"/>
</head>
<body>
<div class="container error-page">
  <jsp:doBody/>
</div>

</body>
</html>