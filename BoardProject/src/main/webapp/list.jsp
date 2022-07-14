<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*,com.sist.vo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%
 BoardDAO dao=new BoardDAO();
 List<BoardVO> list=dao.boardListData(1);
 // 4. 읽은 데이터 출력 
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
 out.println("<h1>자유게시판</h1>");
 
 out.println("<table width=700 class=table_content>");
 out.println("<tr>");
 out.println("<td><a href=BoardInsert>새글</a></td>");
 out.println("</tr>");
 out.println("</table>");
 out.println("<table width=700 class=table_content>");
 out.println("<tr>");
 out.println("<th width=\"10%\">번호</th>");
 out.println("<th width=\"45%\">제목</th>");
 out.println("<th width=\"15%\">이름</th>");
 out.println("<th width=\"20%\">작성일</th>");
 out.println("<th width=\"10%\">조회수</th>");
 out.println("</tr>");
 for(BoardVO vo:list)
 {
	 out.println("<tr class=dataTr>");
	 out.println("<td width=10% align=center>"+vo.getNo()+"</td>");
	 out.println("<td width=45% align=left><a href=BoardDetail?no="+vo.getNo()+">"+vo.getSubject()+"</a></td>");
	 out.println("<td width=15% align=center>"+vo.getName()+"</td>");
	 out.println("<td width=20% align=center>"+vo.getRegdate().toString()+"</td>");
	 out.println("<td width=10% align=center>"+vo.getHit()+"</td>");
	 out.println("</tr>");
 }
 out.println("</div>");
 out.println("<html>");
 out.println("</body>");
 out.println("</html>");
 %>
</body>
</html>