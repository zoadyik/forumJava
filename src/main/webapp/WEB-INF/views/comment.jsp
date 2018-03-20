<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<title>Comment Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
	
	<script>
	$(document).ready(function(){
	    $('#btn').prop('disabled',true);
	    $('#comment').keyup(function(){
	        $('#btn').prop('disabled', this.value == "" ? true : false);     
	    })

	}); 
    function stoppedTyping(){
        if(this.value.length > 0) { 
            document.getElementById('btn').disabled = false; 
        } else { 
            document.getElementById('btn').disabled = true;
        }
    }
</script>
</head>
<body>
<h1>
	Add a Comment
</h1>

<c:url var="addAction" value="/comment/add/${topicId }"></c:url>
              
<form:form action="${addAction}" commandName="comment">
<table>
	<tr>
		<td>
			<form:label path="tid">
				<spring:message text="tid"/>
			</form:label>
		</td>
		<td>
			<form:input path="" value="${topicId }" readonly="true" size="8"  disabled="true" />
			<form:hidden path="tid" />
		</td> 
	</tr>
	<c:if test="${!empty comment.comment}">
	<tr>
		<td>
			<form:label path="cid">
				<spring:message text="cid"/>
			</form:label>
		</td>
		<td>
			<form:input path="cid" readonly="true" size="8"  disabled="true" />
			<form:hidden path="cid" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="comment">
				<spring:message text="Comment"/>
			</form:label>
		</td>
		<td>
			<form:input path="comment" onkeyup="stoppedTyping()"/>
		</td> 
	</tr>

	<tr>
		<td colspan="2">
			<c:if test="${!empty comment.comment}">
				<input type="submit" id="btn"
					value="<spring:message text="Edit comment"/>" />
			</c:if>
			<c:if test="${empty comment.comment}">
				<input type="submit" id="btn"
					value="<spring:message text="Add comment"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<p>${param.pId}</p>
<br>
<h3>Comments List</h3>
<c:if test="${!empty listComments}">
	<table class="tg">
	<tr>
		<th width="80">Comment ID</th>
		<th width="120">Comment Name</th>
		<th width="120">Comment Create Date</th>
		<th width="80">Topic ID</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listComments}" var="comment">
		<tr>
			<td>${comment.cid}</td>
			<td>${comment.comment}</td>
			<td>${comment.createDate}</td>
			<td>${comment.tid}</td>
			<td><a href="<c:url value='/comment/edit/${topicId }/${comment.cid}' />" >Edit</a></td>
			<td><a href="<c:url value='/comment/remove/${topicId }/${comment.cid}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
<a href="<c:url value='/topics' />" >Back</a>
</body>
</html>

