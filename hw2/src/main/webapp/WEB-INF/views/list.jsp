<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
<h2>List of ${title}</h2>
<c:forEach items="${data}" var="data">
    <p>${data.toString()}</p>
</c:forEach>
</body>
</html>