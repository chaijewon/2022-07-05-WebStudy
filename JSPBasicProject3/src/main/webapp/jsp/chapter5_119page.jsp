<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
      119page 
      JSP의 스크립트 
        => JSP = Java+HTML(CSS,JavaScript)
                 -------------------------- 구분해서 코딩
                 스크립트 => 자바 코딩하는 위치 
        => 자바 코딩 
           -------
            1. 일반 자바 : 지역변수 , 제어문 , 연산처리 , 메소드 
               <%  %> => 스크립트릿 
            2. 선언식 : 메소드 선언 , 전역변수 
               <%! %>
            3. 표현식 : 변수값, 자바에서 나오는 결과값 출력 
                      System.out.println()
                      <%= %>
 --%>
<%-- 메소드 선언  --%>
<%!
    public int add(int a,int b)
    {
	    return a+b;
    }
    // 자바 문법을 따라 간다 ==> class영역에 설정 (멤버변수 , 메소드)
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%-- 메소드 호출  --%>
  <%
       int res=add(10,20); // _jspService() 메소드 영역에 코딩
  %>
  <%-- 결과값 출력  
    out.println();
  --%>
  <%= res %><%-- ;을 사용할 수 없다  --%>
</body>
</html>






