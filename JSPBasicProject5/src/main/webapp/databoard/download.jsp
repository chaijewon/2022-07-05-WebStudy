<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*,java.net.*"%>
<%
      // 1. 요청값 받기 
      try
      {
    	  request.setCharacterEncoding("UTF-8");
    	  String fn=request.getParameter("fn");
    	  File file=new File("c:\\download\\"+fn);
    	  
    	  // 다운로드 창을 보여준다 
    	  response.setHeader("Content-Disposition", "attachement;filename="
    	                 +URLEncoder.encode(fn, "UTF-8"));
    	  // 실제 다운로드 
    	  
      }catch(Exception ex){}
%>
