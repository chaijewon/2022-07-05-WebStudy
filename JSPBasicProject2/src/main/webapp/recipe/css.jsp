<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
    FoodDAO dao=new FoodDAO();
    List<CategoryVO> list=dao.categoryListData();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container{
   width:960px;
}
.product_list{
   width:700px;
   margin: 0px auto;
}
.product{
  text-align:center;
  width: 225px;
  display: block;
  float: left;
}
.product-name{
  margin-top: 20px;
  margin-bottom: 4px;
}
</style>
</head>
<body>
 <div class="container">
   <div class="product_list">
    <%
     for(int i=0;i<12;i++)
     {
    	 CategoryVO vo=list.get(i);
   %>
     <a href="#" class="product">
       <img src="<%=vo.getPoster() %>" width=220 height=200>
       <div class="product_name"><%=vo.getTitle() %></div>
     </a>
   <%
     
     }
   %>
   </div>
 </div>
</body>
</html>