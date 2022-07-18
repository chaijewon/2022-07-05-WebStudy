<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <center>
     <h1>개인정보</h1>
     <form method="post" action="output.jsp">
     <table birder=1 width=350>
       <tr>
        <td width=30%>이름</td>
        <td width=70%>
          <input type=text name=name size=15>
        </td>
       </tr>
       <tr>
        <td width=30%>성별</td>
        <td width=70%>
          <%-- 전송 => value --%>
          <input type=radio name=sex value="남자" checked>남자
          <input type=radio name=sex value="여자">여자
        </td>
       </tr>
       <tr>
        <td width=30%>직위</td>
        <td width=70%>
          <%--
              <option value="aaa">부장</option>
              
              <option value="name">이름</option>
              <option value="subject">제목</option>
              <option value="content">내용</option>
           --%>
          <select name=job>
            <option>부장</option>
            <option>과장</option>
            <option>대리</option>
            <option>사원</option>
          </select>
        </td>
       </tr>
       <tr>
        <td width=30%>소개</td>
        <td width=70%>
          <textarea rows="5" cols="20" name=content></textarea>
        </td>
       </tr>
       <tr>
        <td width=30%>취미</td>
        <td width=70%>
          <input type="checkbox" value="운동" name="hobby">운동
          <input type="checkbox" value="등산" name="hobby">등산
          <input type="checkbox" value="여행" name="hobby">여행
          <input type="checkbox" value="게임" name="hobby">게임
          <input type="checkbox" value="낚시" name="hobby">낚시
        </td>
       </tr>
       <tr>
         <td align="center" colspan="2">
           <!-- <input type=submit value="전송"> -->
           <button>전송</button>
         </td>
       </tr>
     </table>
     </form>
   </center>
</body>
</html>