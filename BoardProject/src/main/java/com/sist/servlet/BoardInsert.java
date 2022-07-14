package com.sist.servlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

@WebServlet("/BoardInsert")
public class BoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 변환 (전송방법) => HTML , XML , JSON
		response.setContentType("text/html;charset=UTF-8");
		// 2. 브라우저에서 읽어갈 위치의 메모리 설정 
		 PrintWriter out=response.getWriter();
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
		 out.println("<h1>글쓰기</h1>");
		 out.println("<form method=post action=BoardInsert>");
		 out.println("<table width=700 class=table_content>");
		 out.println("<tr>");
		 out.println("<th align=right width=15%>이름</th>");
		 out.println("<td width=85%><input type=text name=name size=15></td>");
		 out.println("</tr>");
		 out.println("<tr>");
		 out.println("<th align=right width=15%>제목</th>");
		 out.println("<td width=85%><input type=text name=subject size=45></td>");
		 out.println("</tr>");
		 out.println("<tr>");
		 out.println("<th align=right width=15%>내용</th>");
		 out.println("<td width=85%><textarea rows=10 cols=50 name=content></textarea></td>");
		 out.println("</tr>");
		 out.println("<tr>");
		 out.println("<th align=right width=15%>비밀번호</th>");
		 out.println("<td width=85%><input type=password name=pwd size=10></textarea></td>");
		 out.println("</tr>");
		 out.println("<tr>");
		 out.println("<td colspan=2 align=center>");
		 out.println("<input type=submit value=글쓰기>");
		 out.println("<input type=button value=취소 onclick=\"javascript:history.back()\">");
		 out.println("</td>");
		 out.println("</tr>");
		 out.println("</table>");
		 out.println("</form>");
		 out.println("</div>");
		 out.println("</body>");
		 out.println("</html>");
	}
    /*
     *   https://www.google.com/search?q=%EC%9E%90%EB%B0%94&oq=%EC%9E%90%EB%B0%94&aqs=chrome..69i57j0i131i433i512j0i433i512j0i131i433i512j0i512j0i131i433i512l2j0i512j0i131i433i512l2.815j0j15&sourceid=chrome&ie=UTF-8
     */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try
		{
			// 한글 => 변환 
			req.setCharacterEncoding("UTF-8"); //POST방식 
			// 디코딩 ==> 인코딩(byte[]) => 
			/*
			 *   %EC%9E%90%EB%B0%94 ===> 자바
			 *     브라우저                응용프로그램 
			 *      (char = 1)            (char =2)
			 *      인코딩                 디코딩
			 */
			
		}catch(Exception ex) {}
		String name=req.getParameter("name"); // 유효성 검사 (Jquery)
		String subject=req.getParameter("subject");
		String content=req.getParameter("content");
		String pwd=req.getParameter("pwd");
		
		BoardVO vo=new BoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		
		// DAO연결 
		BoardDAO dao=new BoardDAO();
		dao.boardInsert(vo);
		// 화면 이동 => BoardServlet
		resp.sendRedirect("BoardServlet");
		
	}
	

}







