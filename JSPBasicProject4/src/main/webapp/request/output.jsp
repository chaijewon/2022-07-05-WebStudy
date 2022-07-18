<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
     // 사용자가 보낸 모든 데이터는 request에 담겨서 들어 온다 
     // 한글 변환 =>디코딩
     request.setCharacterEncoding("UTF-8");
     String name=request.getParameter("name");
     String sex=request.getParameter("sex");
     String job=request.getParameter("job");
     String content=request.getParameter("content");
     String[] hobby=request.getParameterValues("hobby");// 다중 검색
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   이름:<%=name %><br>
   성별:<%= sex %><br>
   직위:<%= job %><br>
   소개:<%= content %><br>
   취미:
     <ul>
       <%
          try
          {
           for(int i=0;i<hobby.length;i++)
           {
       %>
               <li><%= hobby[i] %></li>
       <%
           }
          }catch(Exception ex)
          {
      %>
              <font color=red>취미가 없습니다!!</font>
      <%
          }
       %>
     </ul>
     <%
        
        /*
        try
        {
        	
        }catch(Exception ex)
        {
        	
        }*/
     %>
</body>
</html>







