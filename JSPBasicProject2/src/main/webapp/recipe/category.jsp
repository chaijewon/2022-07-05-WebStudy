<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
    FoodDAO dao=new FoodDAO();
    List<CategoryVO> list=dao.categoryListData();
%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>지니뮤직</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'><link rel="stylesheet" href="./style.css">

</head>
<body>
<!-- partial:index.partial.html -->
<header>  
  
</header>
<h1 style="text-align: center">믿고보는 맛집 리스트</h1>
<section>
 <%
     for(int i=0;i<12;i++)
     {
    	 CategoryVO vo=list.get(i);
 %>
          <figure>
            <figcaption>
		    <img src="<%= vo.getPoster()%>" style="width: 420px;height: 150px">
		      <p><%=vo.getTitle() %></p>
		     
		    </figcaption>
		  </figure> 
 <%
     }
 %>
  
</section>
<h1 style="text-align: center">지역별 인기 맛집</h1>
<section>
 <%
     for(int i=12;i<18;i++)
     {
    	 CategoryVO vo=list.get(i);
 %>
          <figure>
            <figcaption>
		    <img src="<%= vo.getPoster()%>" style="width: 420px;height: 150px">
		      <p><%=vo.getTitle() %></p>
		     
		    </figcaption>
		  </figure> 
 <%
     }
 %>
  
</section>
<h1 style="text-align: center">메뉴별 인기 맛집</h1>
<section>
 <%
     for(int i=18;i<30;i++)
     {
    	 CategoryVO vo=list.get(i);
 %>
          <figure>
            <figcaption>
		    <img src="<%= vo.getPoster()%>" style="width: 420px;height: 150px">
		      <p><%=vo.getTitle() %></p>
		     
		    </figcaption>
		  </figure> 
 <%
     }
 %>
  
</section>


 
<!-- partial -->
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/mustache.js/2.3.0/mustache.min.js'></script><script  src="./script.js"></script>

</body>
</html>