package com.sist.emp;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;
@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub => 화면 출력 
		// JSP => _jspService(){JSP코딩}
		// 1. 변환 ==> 컴파일 => HTML
		response.setContentType("text/html;charset=UTF-8");
		// text/html , text/xml , text/plain=>JSON
		PrintWriter out=response.getWriter();// 사용자의 정보 
		// out => 클라이언트의 브라우저에서 읽어가는 위치 지정 
		// 출력할 데이터를 가지고 온다 
		EmpDAO dao=new EmpDAO();
		List<EmpVO> list=dao.empListData2();
		
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>사원 목록</h1>");
		out.println("<table width=600 border=1 bordercolor=black>");
		out.println("<tr>");
		out.println("<th>사번</th>");
		out.println("<th>이름</th>");
		out.println("<th>직위</th>");
		out.println("<th>입사일</th>");
		out.println("<th>부서명</th>");
		out.println("<th>근무지</th>");
		out.println("<th>급여등급</th>");
		out.println("</tr>");
		for(EmpVO vo:list)
		{
			out.println("<tr>");
			out.println("<td>"+vo.getEmpno()+"</td>");
			out.println("<td>"+vo.getEname()+"</td>");
			out.println("<td>"+vo.getJob()+"</td>");
			out.println("<td>"+vo.getHiredate().toString()+"</td>");
			out.println("<td>"+vo.getDname()+"</td>");
			out.println("<td>"+vo.getLoc()+"</td>");
			out.println("<td>"+vo.getGrade()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

}









