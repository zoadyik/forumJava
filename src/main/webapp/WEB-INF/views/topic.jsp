<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Topic Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
		.pagination {
    display: inline-block;
}

.pagination a {
    color: black;
    float: left;
    padding: 8px 16px;
    text-decoration: none;
}
	</style>
</head>
<body>
<h1>
	Add a Topic
</h1>

<c:url var="addAction" value="/topic/add" ></c:url>

<form:form action="${addAction}" commandName="topic">
<table>
	<c:if test="${!empty topic.topic}">
	<tr>
		<td>
			<form:label path="tid">
				<spring:message text="tid"/>
			</form:label>
		</td>
		<td>
			<form:input path="tid" readonly="true" size="8"  disabled="true" />
			<form:hidden path="tid" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="topic">
				<spring:message text="Topic"/>
			</form:label>
		</td>
		<td>
			<form:input path="topic" />
		</td> 
	</tr>

	<tr>
		<td colspan="2">
			<c:if test="${!empty topic.topic}">
				<input type="submit"
					value="<spring:message text="Edit Topic"/>" />
			</c:if>
			<c:if test="${empty topic.topic}">
				<input type="submit"
					value="<spring:message text="Add Topic"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Topics List</h3>
<c:if test="${!empty listTopics}">
	<table class="tg">
	<tr>
		<th width="80">Topic ID</th>
		<th width="120">Topic Name</th>
		<th width="120">Topic Create Date</th>
		<th width="120">View Comments</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listTopics}" var="topic">
		<tr>
			<td>${topic.tid}</td>
			<td>${topic.topic}</td>
			<td>${topic.createDate}</td>
			<td><a href="<c:url value='/comments/${topic.tid}' />" >View Comments</a></td>
			<td><a href="<c:url value='/edit/${topic.tid}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${topic.tid}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<div class="pagination">
    
        <a><c:forEach begin="${startpage}" end="${endpage}" var="p"><a href="<c:url value="/topics" ><c:param name="page" value="${p}"/>${p}</c:url>">${p}</a></c:forEach></a>
    
</div>
</body>
</html>