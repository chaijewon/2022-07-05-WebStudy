<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%
     // 자바 코딩 위치
     List<String> list=new ArrayList<String>();
     list.add("홍길동");
     list.add("심청이");
     list.add("박문수");
     
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <ul>
    <%
       for(String name:list)
       {
    %>
           <li><%=name %></li>
    <%
       }
    %>
  </ul>
</body>
</html>