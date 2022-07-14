<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
//private static final long serialVersionUID = 1L;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%
	out.println("<html>");
	out.println("<head>");
	out.println("<style type=text/css>");
	out.println("div{ width:100% }");
	out.println("h1{margin-top:50px; text-align:center}");
	out.println("table{ margin:0px auto;}");
	out.println("</style>");
	out.println("<link rel=stylesheet href=table.css>");
	out.println("</head>");
	out.println("<body>");
	out.println("<div>");
	out.println("<h1>글쓰기</h1>");
	out.println("<form method=post action=BoardInsert>");
	out.println("<table width=700 class=table_content>");
	out.println("<tr>");
	//out.println("<th align=right width=15%>이름</th>");
	out.println("<td width=85%><input type=text name=name size=15></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<th align=right width=15%>제목</th>");
	out.println("<td width=85%><input type=text name=subject size=45></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<th align=right width=15%>내용</th>");
	out.println("<td width=85%><textarea rows=10 cols=50 name=content></textarea></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<th align=right width=15%>비밀번호</th>");
	out.println("<td width=85%><input type=password name=pwd size=10></textarea></td>");
	out.println("</tr>");
	out.println("<tr>");
	out.println("<td colspan=2 align=center>");
	out.println("<input type=submit value=글쓰기>");
	out.println("<input type=button value=취소 onclick=\"javascript:history.back()\">");
	out.println("</td>");
	out.println("</tr>");
	out.println("</table>");
	out.println("</form>");
	out.println("</div>");
	out.println("</body>");
	out.println("</html>");
	%>
</body>
</html>