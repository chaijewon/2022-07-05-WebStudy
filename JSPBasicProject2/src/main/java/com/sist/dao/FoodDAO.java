package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.conn.*;
public class FoodDAO {
  private Connection conn;
  private PreparedStatement ps;
  private DBConnection dbconn=DBConnection.newInstance();
  // 기능 
  public List<CategoryVO> categoryListData()
  {
	  List<CategoryVO> list=new ArrayList<CategoryVO>();
	  try 
	  {
		 conn=dbconn.getConnection();
		 String sql="SELECT /*+ INDEX_ASC(food_category PK_FOOD_CATEGORY)*/ "
		 		   + "cno,title,subject,poster "
				   +"FROM food_category";
		/* String sql="SELECT /*+ INDEX_ASC(food_category PK_FOOD_CATEGORY)  cno,title,subject,poster "
				   +"FROM food_category";*/
		 ps=conn.prepareStatement(sql);
		 ResultSet rs=ps.executeQuery();
		 while(rs.next())
		 {
			 CategoryVO vo=new CategoryVO();
			 vo.setCno(rs.getInt(1));
			 vo.setTitle(rs.getString(2));
			 vo.setSubject(rs.getString(3));
			 vo.setPoster(rs.getString(4));
			 list.add(vo);
		 }
         rs.close();				   
	  } catch (Exception e) 
	  {
		 e.printStackTrace();
	  }
	  finally
	  {
		  dbconn.disConnection(ps);
	  }
	  return list;
	  
  }
}
