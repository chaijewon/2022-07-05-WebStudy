package com.sist.servlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.dao.*;
import com.sist.vo.*;
// post => form , ajax , axios => POST 
@WebServlet("/BoardDetail")
public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 변환 (전송방법) => HTML , XML , JSON
           response.setContentType("text/html;charset=UTF-8");
		// 2. 브라우저에서 읽어갈 위치의 메모리 설정 
		   PrintWriter out=response.getWriter();
		// 3. 사용자가 보내준 데이터를 받는다 ?no=88
		String no=request.getParameter("no");
		// <input type=text name=name> => 입력된 값 
		// 모든 데이터는 문자열로 읽는다 
		BoardDAO dao=new BoardDAO();
		BoardVO vo=dao.boardDetail(Integer.parseInt(no), 1);
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
		 out.println("<h1>내용보기</h1>");
		 out.println("<table width=700 class=table_content>");
		 out.println("<tr>");
		 out.println("<th width=20%>번호</th>");
		 out.println("<td width=30% align=center>"+vo.getNo()+"</td>");
		 out.println("<th width=20%>작성일</th>");
		 out.println("<td width=30% align=center>"+vo.getRegdate().toString()+"</td>");
		 out.println("</tr>");
		 out.println("<tr>");
		 out.println("<th width=20%>이름</th>");
		 out.println("<td width=30% align=center>"+vo.getName()+"</td>");
		 // <td width=30% align=center><%= vo.getName()%></td> 
		 // <td width=30% align=center>${vo.name}</td>
		 // <td width=30% align=center th:text=${vo.name}></td>(****)
		 out.println("<th width=20%>조회수</th>");
		 out.println("<td width=30% align=center>"+vo.getHit()+"</td>");
		 out.println("</tr>");
		 out.println("<tr>");
		 out.println("<th width=20%>제목</th>");
		 out.println("<td colspan=3>"+vo.getSubject()+"</td>");
		 out.println("</tr>");
		 out.println("<tr>");
		 out.println("<td colspan=4 align=left valign=top style=\"height:200px\">"+vo.getContent()+"</td>");
		 out.println("</tr>");
		 // 흐름 
		 out.println("<tr>");
		 out.println("<td colspan=4 align=right>");
		 out.println("<a href=BoardUpdate?no="+vo.getNo()+">수정</a>");
		 out.println("<a href=BoardDelete?no="+vo.getNo()+">삭제</a>");
		 out.println("<a href=BoardServlet>목록</a>");
         out.println("</td>");
		 out.println("</tr>");
		 
		 out.println("</table>");
		 out.println("</div>");
		 out.println("</body>");
		 out.println("</html>");
		 
	}

}











