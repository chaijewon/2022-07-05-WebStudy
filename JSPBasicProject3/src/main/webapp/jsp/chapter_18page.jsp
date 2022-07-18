<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
      19page : 
               서버 ====> 웹서버 , 톰캣(WAS): 자바번역 
                                --------- 테스트용 Web Server(50명)
               클라이언트 ====> 웹브라우저 
               
               C/S 
                사용자 : 요청  => 주소란를 이용해서 요청 
                                요청 방식 
                                -------
                                 GET => 요청데이터를 보낼때 URL뒤에 첨부 
                                 POST=> 내부네트워크로 전송 (보안 , 데이터가 많다)
                서버 : 응답 (응답에 대한 처리 => 웹 프로그래머)
                      => HTML , COOKIE , 이미지 , JSON(Rest)
                                                ----------- javascript(Ajax,Vue,React), kotlin
      22page : 
             *** 웹에서 전송(브라우저) => 일반 자바로는 요청을 받을 수 없다
                 => 서블릿 , JSP
             Servlet : Java형태 중간에 HTML을 이용해서 처리 
                       => 효율성이 떨어진다 
                       => 보안 (자바와 관련된 코딩은 Servlet을 이용한다)
                          스프링에서 라이브러리 제공 (서블릿)
                        
             JSP : HTML을 사용하기 편리 , CSS , JavaScript사용이 편리 
                   View(화면 출력용) 
                   => 보안 취약 ( jsp: 전체 소스 전송 , java:class)
      24page : JSP(Java Server Page) : 서버에서 실행하는 자바파일 
               => 파일(X) , 페이지
               동적  / 정적
               => 동적 페이지를 생성하기 위한 서버 측 스크립트 언어 (단순한 언어) 
               설치(JDK , Tomcat , Eclipse)  
      72page 동작 
      -----------
        1) 사용자가 요청 (파일 요청) ==> 브라우저 주소창 (유일하게 서버와 연결) 
           http://localhost:8080/JSPBasicProject3/jsp/chapter_18page.jsp
        2) 웹 서버 , 웹 애플리케이션 서버 (WAS) 
           ------  ----------------------
             |
            요청 => 파일 찾기 => 응답 
                     |
                  --------- .html,.xml,.json => 자체에서 처리 가능 
                  --------- .jsp , .php , .asp => 무조건 (HTML로 변경후에 브라우저 전송)  
            *** .jsp를 요청 
                ----------
                   웹서버 ==> 톰캣으로 전송 
                            -----------
                               1) jsp파일을 java파일로 변경 
                               2) 변경된 java파일 => 컴파일 ==> javac
                               3) 컴파일된 파일 실행 ==> java
                               4) HTML만 메모리에 출력 (출력버퍼)
                               5) 요청한 브라우저에서 읽어 간다  
       3) JSP => 생명주기 
          => 생성 => 화면 출력 => 메모리 해제
             init()   service()  destory() => 화면이동 , 새로고침 
                         |
                       미제작 (웹프로그래머 => 화면(HTML)을 사용자에게 전송)
          => 자바의 기본 문법 
             => 변수 / 데이터형 
             => 연산자 / 제어문 
             => 배열 (1차원)
             => 메소드 제작 
             => 객체 지향 프로그램 
                => 클래스 생성 (멤버변수 , 멤버메소드 , 생성자)
                => 캡슐화 / 상속 , 포함 / 다형성 (오버라이딩)
                => 클래스 종류 (추상 클래스 , 인터페이스)
             => 예외처리 
             => 라이브러리 
                java.util , java.lang , java.io
                   |           | String , Wrapper , Object ...
                  Date , StringTokenizer , List , Map , Set(제네릭스)
                
             => java.sql (데이터베이스 연동) 
             
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

