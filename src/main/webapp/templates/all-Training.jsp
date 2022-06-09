<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!doctype html>
<html>
<head>
    <link rel="shortcut icon" type="image/ico" href="../static/favicon.ico"/>
</head>
<body>
<h2>Расписание тренировок</h2>
<br>
<jsp:useBean id="date" class="java.util.Date"/>
<table>
    <tr>
        <th>Название</th>
        <th>Время</th>
        <th>Дни тренировки</th>
        <th>Опции</th>
    </tr>
    <c:forEach var="training" items="${allTraining}">

        <c:url var="updateButton" value="training_schedule/updateTraining">
            <c:param name="TrainingId" value="${training.id}"/>
        </c:url>
        <c:url var="deleteButton" value="training_schedule/deleteTraining">
            <c:param name="TrainingId" value="${training.id}"/>
        </c:url>

        <tr>
            <td>${training.name}</td>
            <td>${training.trainingTime}</td>
            <td>${training.trainingDays}</td>
            <td>
                <input type="button" value="Обновить" onclick="window.location.href = '${updateButton}'"/>
                <input type="button" value="Удалить" onclick="window.location.href = '${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>

</table>
<br>
<input type="button" value="Создать" onclick="window.location.href = 'training_schedule/addNewTraining'">
<br>
<br>
<input type="button" value="Назад в админку" onclick="window.location.href = 'admin'">
</body>
</html>