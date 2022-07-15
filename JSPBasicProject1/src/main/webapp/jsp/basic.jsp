<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
      HTML + JAVA를 동시에 주석 
      <%
         자바 코딩 
         => 변수선언
         => 연산자
         => 제어문 
         => 주석 : 자바와 동일  // , /* */
      %>
      
      JSP 
      1. 지시자 
         = page :JSP에 대한 정보 
                 변환 => HTML/XML => contentType => 한글 처리 
                 에러처리 => errorPage
                 buffer => HTML을 출력하는 메모리 공간 (8kb) => 16kb
                 import => 외부 라이브러리 / 자바 라이브러리 
                 => 속성은 한번만 사용이 가능 
                 => import는 여러개 사용이 가능 
                 <%@ page import="java.util.*,java.io.*"%>
                 <%@ page import="java.util.*"%>
                 <%@ page import="java.io.*"%>
         = taglib : 자바 제어문 , 자바 변수 선언 , 화면 이동 , 날짜변경 , String
                    => 태그로 만들어져 있다 
                    <%
                       for(int i=1;i<=100;i++)
                       {
                           if(i%2==0)
                           {
                    %>
                                출력 => HTML 
                                <%=i %>&nbsp;
                    <%
                           }
                       }
                    %>
                    
                    JSTL => Spring , Spring-Boot
                    <c:forEach var="i" begin="1" end="100" step="1">
                       <c:if test="i%2==0">
                         ${i}&nbsp;
                       </c:if>
                    </c:forEach>
         = include : JSP안에 다른 JSP첨부 해서 사용이 가능 (조립식)
                     => 
      2. 스크립트
           스크립트릿 : 일반 자바  <%  %> 
           표현식 : 브라우저에 변수 출력  <%= %> => out.println()
           ------------------------------------ _jspService()
           선언식 : 메소드선언 , 멤버변수 => class영역에 첨부 <%! %>
                  => 사용빈도가 거의 없다 
      3. 내장 객체 : 미리 객체를 생성 => 사용이 가능하게 만든다 (9개)
                   *****request : 사용자 요청값 : 지역변수
                   *****response : 응답 (화면 변환) 
                   *****session : 서버 일부 정보를 저장 => 모든 JSP에서 사용이 가능 
                             => static 
                             => 로그인 => id,name 
                                예매 => session에 있는 id를 사용      
                   application : 서버 정보를 가지고 있다 
                                 getRealPath() , 로그파일 
                   pageContext : include(), forward()
                   page : this
                   config : 환경설정 => web.xml
                   exception : 예외처리 => try~catch
                   *****out : 화면 출력 print() , println() <%=%>
      4. jsp액션 태그 : XML 
              <jsp:include> : 화면 조립 
              <jsp:useBean> : 객체 메모리 할당 
              <jsp:setProperty> : setter에 값을 채운다 
              
              사용자 => 이름 , 성별 , 주소 , 전화 , 소개 
                    String name=request.getParameter("name");
                    String sex=request.getParameter("sex");
                    String addr=request.getParameter("addr");
                    String tel=request.getParameter("tel");
                    String content=request.getParameter("content");
                    
                    MemberVO vo=new MemberVO();
                    vo.setName(name);
                    vo.setSex(sex);
                    vo.setAddr(addr);
                    vo.setTel(tel);
                    vo.setContent(content);
                    
                    <jsp:setProperty name="vo" property="*">
              <jsp:getProperty>: 받은 데이터를 출력 => getter
      5. Cookie : 클라이언트에 정보 저장 => 최신 방문 (내장객체가 아니다)
               GET / POST 
               session / cookie 
      6. EL / JSTL  ==> ${} , <c:forEach> , <c:if> ....
      7. Error : errorPage , 종류별 => web.xml
      8. 데이터베이스 연동 : JDBC 
      ***9. MVC : 자바 , HTML분리 => 사용목적 (확장성, 재사용성 => 유지보수 목적)
         ** 실무 MVC => jsp, php , asp , html .... 
                       .do , nhn , daum...
                       
         JSP : 절차적언어 => 재사용이 않된다 => model1   
         M(Java)V(JSP)C(Servlet) : 객체 => 재사용성           => model2
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <center>
    <h1>구구단(HTML)</h1>
    <table width=560 border=1>
      <tr>
        <th>2단</th>
        <th>3단</th>
        <th>4단</th>
        <th>5단</th>
        <th>6단</th>
        <th>7단</th>
        <th>8단</th>
        <th>9단</th>
      </tr>
      <tr>
        <td align=center>2*1=2</td>
        <td align=center>3*1=3</td>
        <td align=center>4*1=4</td>
        <td align=center>5*1=5</td>
        <td align=center>6*1=6</td>
        <td align=center>7*1=7</td>
        <td align=center>8*1=8</td>
        <td align=center>9*1=9</td>
      </tr>
    </table>
    <h1>자바+HTML(JSP)</h1>
    <table width=560 border=1>
      <tr>
        <%
           for(int i=2;i<=9;i++)
           {
        %>
        	   <th><%= i+"단" %></th>
        
        <%
           }
        %>
      </tr>
      <%
         for(int i=1;i<=9;i++)
         {
      %>
            <tr>
            <%
               for(int j=2;j<=9;j++)
               {
            %>
                    <td align=center><%= j+"*"+i+"="+(j*i) %></td>
            <%
            	   
               }
            %> 
            <tr>     
      <%
      
         }
      %>
    </table>
    <h1>JSTL(MVC)=실무 , Spring, Spring-Boot</h1>
    <table width=560 border=1>
      <tr>
        <c:forEach var="i" begin="2" end="9">
          <th>${i }단</th>
        </c:forEach>
      </tr>
      <c:forEach var="i" begin="1" end="9">
        <tr>
          <c:forEach var="j" begin="2" end="9">
            <td align=center>${ j }*${i }=${i*j }</td>
          </c:forEach>
        </tr>
      </c:forEach>
    </table>
  </center>
</body>
</html>









