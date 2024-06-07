<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Assign Project</title>
</head>
<body>
<h1>Assign Project to Employee</h1>

<c:if test="${not empty message}">
    <p style="color: green;">${message}</p>
</c:if>
<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

<form action="${pageContext.request.contextPath}/manager/assign" method="post">
    <label for="projectId">Select Project:</label>
    <select name="projectId" id="projectId">
        <c:forEach var="project" items="${projects}">
            <option value="${project.id}">${project.name}</option>
        </c:forEach>
    </select>
    <br/>

    <label for="employeId">Select Employee:</label>
    <select name="employeId" id="employeId">
        <c:forEach var="employee" items="${employees}">
            <option value="${employee.id}">${employee.name}</option>
        </c:forEach>
    </select>
    <br/>

    <button type="submit">Assign Project</button>
</form>
</body>
</html>
