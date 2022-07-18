<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.sql.*,com.sist.conn.*"%>
<%!
     private Connection conn;
     private PreparedStatement ps;
     private DBConnection dbconn=DBConnection.newInstance();
     public List<String> getEnameData()
     {
    	 List<String> list=new ArrayList<String>();
    	 try
    	 {
    		 conn=dbconn.getConnection();
    		 String sql="SELECT ename FROM emp";
    		 ps=conn.prepareStatement(sql);
    		 ResultSet rs=ps.executeQuery();
    		 while(rs.next())
    		 {
    			 list.add(rs.getString(1));
    		 }
    		 rs.close();
    	 }catch(Exception ex)
    	 {
    		 ex.printStackTrace();
    	 }
    	 finally
    	 {
    		 dbconn.disConnection(ps);
    	 }
    	 
    	 return list;
     }
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
       List<String> list=getEnameData();
   %>
   <ul>
     <%
        for(String name:list)
        {
     %>
            <li><%= name %></li>
     <%
        }
     %>
   </ul>
</body>
</html>