<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=utf-8" %>
<!doctype html>
<html>
<body>
<h2>Таблица стоимости тренировок</h2>
<br>
<jsp:useBean id="date" class="java.util.Date"/>
<table>
    <tr>
        <th>Описание</th>
        <th>Тип</th>
        <th>Цена</th>
        <th>Опции</th>
    </tr>
    <c:forEach var="trainingCost" items="${allTrainingCost}">

        <c:url var="updateButton" value="training_cost/updateTrainingCost">
            <c:param name="TrainingCostId" value="${trainingCost.id}"/>
        </c:url>
        <c:url var="deleteButton" value="training_cost/deleteTrainingCost">
            <c:param name="TrainingCostId" value="${trainingCost.id}"/>
        </c:url>

        <tr>
            <td>${trainingCost.description}</td>
            <td>${trainingCost.type}</td>
            <td>${trainingCost.price}</td>
            <td>
                <input type="button" value="Обновить" onclick="window.location.href = '${updateButton}'"/>
                <input type="button" value="Удалить" onclick="window.location.href = '${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>

</table>
<br>
<input type="button" value="Создать" onclick="window.location.href = 'training_cost/addNewTrainingCost'">
<br>
<br>
<input type="button" value="Назад в админку" onclick="window.location.href = 'admin'">
</body>
</html>