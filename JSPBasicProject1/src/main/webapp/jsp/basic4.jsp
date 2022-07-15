<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
    MusicDAO dao=new MusicDAO();
    List<MusicVO> list=dao.musicListData(1);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <center>
    <h1>지니뮤직</h1>
    <table width=700 border=1>
      <tr>
        <th>순위</th>
        <th></th>
        <th></th>
        <th>곡명</th>
        <th>가수명</th>
        <th>앨범</th>
      </tr>
    </table>
  </center>
</body>
</html>