package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.conn.*;
// JDBC => DBCP => ORM(Mybatis , JPA)
// JSP => MVC => Spring
public class MusicDAO {
   private Connection conn;
   private PreparedStatement ps;
   private DBConnection dbConn=DBConnection.newInstance();
   
   // 기능 처리 
   public List<MusicVO> musicListData(int cno)
   {
	   List<MusicVO> list=new ArrayList<MusicVO>();
	   try
	   {
		   conn=dbConn.getConnection();
		   String sql="SELECT mno,cno,poster,title,album,state,idcrement,singer "
				     +"FROM music "
				     +"WHERE cno=? "
				     +"ORDER BY mno ASC";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1,cno);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   MusicVO vo=new MusicVO();
			   vo.setMno(rs.getInt(1));
			   vo.setCno(rs.getInt(2));
			   vo.setPoster(rs.getString(3));
			   vo.setTitle(rs.getString(4));
			   vo.setAlbum(rs.getString(5));
			   vo.setState(rs.getString(6));
			   vo.setIdcrement(rs.getInt(7));
			   vo.setSinger(rs.getString(8));
			   list.add(vo);
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   dbConn.disConnection(ps);
	   }
	   return list;
   }
   
}
