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
<link rel="stylesheet" href="../css/table.css">
<style type="text/css">
.container{
   width: 960px;
}
.table_content{
   margin: 0px auto;
}
h1{
  text-align: center;
}
</style>
</head>
<body>
   <div class="container">
    <h1>지니뮤직</h1>
    <table width=700 class="table_content">
      <tr>
        <th>순위</th>
        <th></th>
        <th></th>
        <th>곡명</th>
        <th>가수명</th>
        <th>앨범</th>
      </tr>
      <%
          for(MusicVO vo:list)
          {
      %>
             <tr>
              <td><%=vo.getMno() %></td>
              <td>
                <%
                   String s="";
                   if(vo.getState().equals("상승"))
                   {
                	   s="<font color=red>▲</font>&nbsp;"+vo.getIdcrement();
                   }
                   else if(vo.getState().equals("하강"))
                   {
                	   s="<font color=blue>▼</font>&nbsp;"+vo.getIdcrement();
                   }
                   else
                   {
                	   s="-";
                   }
                %>
                <%=s %>
              </td>
              <td>
               <img src="<%=vo.getPoster() %>" width=30 height="30">
              </td>
              <td><%=vo.getTitle() %></td>
              <td><%=vo.getSinger()%></td>
              <td><%=vo.getAlbum() %></td>
             </tr>
      <%
          }
      %>
    </table>
  </div>
</body>
</html>


