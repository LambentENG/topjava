<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="color" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Подсчет калорий</title>
</head>

<body>
<h3><a href="index.html">Home</a></h3>
<header>
    <h2>Моя еда</h2>
</header>

<table border="1" cellspacing="0" cellpadding="8">
    <thead>
    <tr>
        <th>Дата / Время</th>
        <th>Описание</th>
        <th>Калории</th>
    </tr>
    </thead>

    <tbody>

    <jsp:useBean id="meals" scope="request" type="java.util.List"/>
    <c:forEach var="meals" items="${meals}">
        <tr style="${meals.excess ? "color: red" :  "color: green"}">
            <td><fmt:parseDate value="${meals.dateTime}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDate"/>
                <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${parsedDate}"/></td>
            <td>${meals.description}</td>
            <td>${meals.calories}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>

</html>


