<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>技记沥焊</h1>
	技记ID: <%=session.getId() %><br>
	技记 积己矫埃: <%=session.getCreationTime() %><br>
	技记 弥辟立辟矫埃: <%=session.getLastAccessedTime() %> <br>
	技记 Timeout 矫埃 : <%=session.getMaxInactiveInterval() %> <br>
	技记 isNew : <%=session.isNew() %> <br>
</body>
</html>