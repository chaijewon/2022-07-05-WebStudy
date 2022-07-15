<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
    MusicDAO dao=new MusicDAO();
    List<MusicVO> list=dao.musicListData(1);
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

<section></section>

<template id="movie-template">
 <%
   for(MusicVO vo:list)
   {
 %>
  <figure>
    <img src="<%= vo.getPoster() %>" />
    <figcaption>
      <p><%=vo.getTitle() %></p>
      <div class="rating">
        <i class="fa fa-heart"></i>
        <h4><%=vo.getSinger() %></h4>
      </div>
    </figcaption>
  </figure>
  <%
   }
  %>
</template>
<!-- partial -->
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/mustache.js/2.3.0/mustache.min.js'></script><script  src="./script.js"></script>

</body>
</html>
