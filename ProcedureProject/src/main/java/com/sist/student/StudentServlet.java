package com.sist.student;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		// 오라클 데이터 읽기
		StudentDAO dao=new StudentDAO();
		List<StudentVO> list=dao.stdListData();
		out.print("<html>");
		out.print("<body>");
		out.print("<ul>");
		for(StudentVO vo:list)
		{
			out.print("<li>"+vo.getHakbun()+"-"+vo.getName()+"-"
		     +vo.getKor()+"-"+vo.getEng()+"-"+vo.getMath()+"</li>");
		}
		out.print("</ul>");
		out.print("</body>");
		out.print("</html>");
		
	}

}







