<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
    FoodDAO dao=new FoodDAO();
    String no=request.getParameter("no");
    if(no==null)
    	no="1"; // 페이지 나누기 , 화면 출력
    List<CategoryVO> list=dao.categoryData(Integer.parseInt(no));
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.cate_list{
   width: 960px;
   margin-top: 50px;
}
.link{
   width:700px;
   margin: 0px auto;
}
a{
    color: black;
    text-decoration: none;
}
a:hover{
   color:green;
   text-decoration: underline;
}
.cate{
  width:300px;
  text-align: center;
  display: block;
  float: left;
}
.title{
  margin-top: 20px;
  margin-bottom: 4px;
}
</style>
</head>
<body>
  <div class="cate_list">
   <div class="link">
    <a href="list.jsp?no=1">믿고보는 맛집 리스트</a>&nbsp;
    <a href="list.jsp?no=2">지역별 인기 맛집</a>&nbsp;
    <a href="list.jsp?no=3">메뉴별 인기 맛집</a>
   </div>
  </div>
  <div class="cate_list">
   <%
      for(CategoryVO vo:list)
      {
   %>
		    <a href="food_list.jsp?cno=<%=vo.getCno() %>" class="cate">
		     <img src="<%=vo.getPoster() %>" width="280" height="200">
		     <div class="title"><%=vo.getTitle() %></div>
		    </a>
    <%
      }
    %>
  </div>
</body>
</html>






