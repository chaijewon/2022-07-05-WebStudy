<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
      지시자 
       = page : jsp 파일에 대한 정보 
                145page
                = contentType : 변환(브라우저에 알림)
                  => 브라우저에서 번역 (파일명) => a.html , a.xml
                  => HTML : text/html 
                     XML  : text/xml ==> 오픈 API
                     JSON : text/plain
                = import : 자바 라이브러리 추가 (사용자 정의)
                = errorPage : 에러시에 이동하는 파일즐 지정 
                = buffer : 출력메모리 크기 => 8kb 
                           화면이 잘려서 출력 
                           
                = 형식)
                   <%@ page contentType="text/html;charset=UTF-8">
                   *****<%@ page import="java.util.*,java.io.*"%>
                   <%@ page import="java.util.*"%>
                   <%@ page import="java.io.*"%>
                   <%@ page errorPage="에러시 보여줄 파일 지정"%>
                   <%@ page buffer="16kb"%>
       = taglib : java에서 사용되는 변수선언 , 제어문 , 화면 이동 , 날짜 변환 ...
                  => 태그로 제공 
                  <%
                      if(조건문)
                      {
                  %>
                         HTML 
                  <%
                      }
                  %>
                  
                  <c:if test="조건문">
                     HTML
                  </c:if>
       = include : jsp안에 다른 jsp를 첨부 (조립식) 
                   html안에 다른 HTML을 포함 (<iframe>)
           | 정적 <%@ include file="변경이 안되는 파일"%>
             String jsp="main.jsp"
                    jsp="login.jsp"
                    jsp="board.jsp"
             동적 <jsp:include page="<%=jsp%>"/>(*****)
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 
</body>
</html>