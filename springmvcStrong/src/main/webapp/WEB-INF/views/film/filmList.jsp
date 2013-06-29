<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach  items="${users }" var="user">
	<em>${user.age }</em>
</c:forEach>

	${fn:length(films)}
	<table>
		<thead>
			<tr>
				<td>ID</td>
				<td>TITLE</td>
				<td>LANGUAGE</td>
				<td>DESCRIPTION</td>
				<td>RELEASE-YEAR</td>
				<td>RENTAL-DURATION</td>
				<td>RENTAL-RATE</td>
				<td>LENGTH</td>
				<td>REPLACEMENT-COST</td>
				<td>RATING</td>
				<td>SPECIAL-FEATURES</td>
				<td>LAST-UPDATE</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${films}"  var="f" >
				<tr>
					<%-- <td>${film.filmId}</td>
					<td>${film.title}</td>
					<td>${film.language}</td>
					<td>${film.description}</td>
					<td>${film.releaseYear}</td>
					<td>${film.rentalDuration}</td>
					<td>${film.rentalRate}</td>
					<td>${film.length}</td>
					<td>${film.replacementCost}</td>
					<td>${film.rating}</td>
					<td>${film.specialFeatures}</td>
					<td>${film.lastUpdate}</td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>