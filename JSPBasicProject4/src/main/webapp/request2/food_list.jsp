<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
    String cno=request.getParameter("cno");
    int i=Integer.parseInt(cno);
    
    FoodDAO dao=new FoodDAO();
    List<FoodVO> list=dao.food_category(i);
    for(FoodVO vo:list)
    {
    	String poster=vo.getPoster();
    	poster=poster.substring(0,poster.indexOf("^"));
    	vo.setPoster(poster);
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <center>
    <table border=1 width=600>
      <tr>
       <td align="center">
       
        <%
           for(FoodVO vo:list)
           {
        %>
              <table>
                <tr>
                  <td width=30% align=center rowspan="4">
                   <img src="<%=vo.getPoster() %>" width=100%>
                  </td>
                  <td width=70%>
                    <%=vo.getName() %>
                  </td>
                </tr>
                <tr>
                  <td width=70%>
                    <%=vo.getAddress() %>
                  </td>
                </tr>
                <tr>
                  <td width=70%>
                    <%=vo.getTel() %>
                  </td>
                </tr>
                <tr>
                  <td width=70%>
                    <%=vo.getType() %>
                  </td>
                </tr>
              </table>
        <%
           }
        %>
       </td>
      </tr>
    </table>
   </center>
</body>
</html>






