<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Registration Form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="Student">
First Name: <form:input path="firstName" />
<br><br>
Last Name: <form:input path="lastName" />
<br><br>
Country: <form:select path="country">
<form:option value="India" label="India" />
<form:option value="America" label="America" />
<form:option value="Japan" label="Japan" />
</form:select>
<br><br>
CountryCode: <form:select path="countryCode">
<form:options items="${Student.countryOptions}" />
</form:select>
<br><br>
Favorite Programming Language:
C<form:radiobutton path="favoritePL" value="C"/>
Java<form:radiobutton path="favoritePL" value="Java"/>
Python<form:radiobutton path="favoritePL" value="Python"/>
<br><br>
Operating Systems:
Linux<form:checkbox path="OS" value="Linux"/>
Windows<form:checkbox path="OS" value="Windows"/>
Mac<form:checkbox path="OS" value="Mac"/>
<br><br>
<input type="submit" value="Submit"/>
</form:form>
</body>
</html>