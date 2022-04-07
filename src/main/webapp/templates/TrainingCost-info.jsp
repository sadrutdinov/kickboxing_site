<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!doctype html>
<html>

<body>

<h2>Информация о тренировке</h2>

<form:form action="saveTrainingCost" modelAttribute="TrainingCost">

    <form:hidden path="id"/>

    Описание <form:input path="description"/>
    <br>
    Тип <form:select path="type">
        <form:option value="ONE">ONE</form:option>
        <form:option value="EIGHT">EIGHT</form:option>
        <form:option value="TWELVE">TWELVE</form:option>
    </form:select>
    <br>
    Цена <form:input path="price"/>
    <br>

    <input type="submit" value="OK">

</form:form>
</body>
</html>