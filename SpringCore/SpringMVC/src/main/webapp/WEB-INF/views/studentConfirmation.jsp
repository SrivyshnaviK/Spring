<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Student Confirmation Form</title>
</head>
<body>
<h2>The Student is Confirmed: ${Student.firstName} ${Student.lastName}</h2>
<h2>Selected Country: ${Student.country}</h2>
<h2>Selected CountryCode: ${Student.countryCode}</h2>
<h2>Selected Programming Language: ${Student.favoritePL}</h2>
<h2>Operating Systems</h2>
<ul>
<c:forEach var="temp" items="${Student.OS}">
<li>${temp}
</c:forEach>
</ul>
</body>
</html>