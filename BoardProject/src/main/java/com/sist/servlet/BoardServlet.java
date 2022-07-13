package com.sist.servlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 *    GET ==> <a> , <form> 
 *    POST ==> <form> ============> ajax
 *    ------------ 데이터 전송법 (웹) ==> URL주소 
 *    
 */
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // 1. 변환 (전송방법) => HTML , XML , JSON
		 response.setContentType("text/html;charset=UTF-8");
		 // 2. 브라우저에서 읽어갈 위치의 메모리 설정 
		 PrintWriter out=response.getWriter();
		 // 3. 데이터 읽기
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
		 out.println("<th width=10%>번호</th>");
		 out.println("<th width=45%>제목</th>");
		 out.println("<th width=15%>이름</th>");
		 out.println("<th width=20%>작성일</th>");
		 out.println("<th width=10%>조회수</th>");
		 out.println("</tr>");
		 for(BoardVO vo:list)
		 {
			 out.println("<tr class=dataTr>");
			 out.println("<td width=10%>"+vo.getNo()+"</td>");
			 out.println("<td width=45%>"+vo.getSubject()+"</td>");
			 out.println("<td width=15%>"+vo.getName()+"</td>");
			 out.println("<td width=20%>"+vo.getRegdate().toString()+"</td>");
			 out.println("<td width=10%>"+vo.getHit()+"</td>");
			 out.println("</tr>");
		 }
		 out.println("</div>");
		 out.println("<html>");
		 out.println("</body>");
		 out.println("</html>");
		 
	}

}




















