<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!doctype html>
<html>
<head>
    <link rel="shortcut icon" type="image/ico" href="../static/favicon.ico"/>
</head>

<body>

<h2>Информация о тренировке</h2>

<form:form action="saveTraining" modelAttribute="Training">

    <form:hidden path="id"/>

    Название <form:input path="name"/>
    <br>
    Дни тренировки <form:input path="trainingDays"/>
    <br>
    Время <form:input path="trainingTime"/>
    <br>

    <input type="submit" value="OK">

</form:form>
</body>
</html>