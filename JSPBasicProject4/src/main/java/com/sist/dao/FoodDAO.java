package com.sist.dao;
import java.util.*;

import com.sist.conn.DBConnection;

import java.sql.*;
public class FoodDAO {
    private Connection conn;
    private PreparedStatement ps;
    DBConnection dbconn=DBConnection.newInstance();
    
    public List<CategoryVO> categoryData(int no)
    {
    	List<CategoryVO> list=new ArrayList<CategoryVO>();
    	int start=0;
    	int end=0;
    	if(no==1)
    	{
    		start=1;
    		end=12;
    	}
    	else if(no==2)
    	{
    		start=13;
    		end=18;
    	}
    	else if(no==3)
    	{
    		start=19;
    		end=30;
    	}
    	
    	try
    	{
    	    conn=dbconn.getConnection();
    	    String sql="SELECT cno,title,subject,poster "
    	    		  +"FROM food_category "
    	    		  +"WHERE cno BETWEEN ? AND ?";
    	    ps=conn.prepareStatement(sql);
    	    ps.setInt(1, start);
    	    ps.setInt(2, end);
    	    
    	    ResultSet rs=ps.executeQuery();// record
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
    public CategoryVO category_info(int cno)
    {
    	CategoryVO vo=new CategoryVO();
    	try
    	{
    		conn=dbconn.getConnection();
    		String sql="SELECT title,subject "
    				  +"FROM food_category "
    				  +"WHERE cno=?";
    		ps=conn.prepareStatement(sql);
    		ps.setInt(1, cno);
    		ResultSet rs=ps.executeQuery();
    		rs.next();
    		vo.setTitle(rs.getString(1));
    		vo.setSubject(rs.getString(2));
    		rs.close();
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    	finally
    	{
    		dbconn.disConnection(ps);
    	}
    	return vo;
    }
    public List<FoodVO> food_category(int cno)
    {
    	List<FoodVO> list=new ArrayList<FoodVO>();
    	try
    	{
    			conn=dbconn.getConnection();
    			String sql="SELECT fno,name,poster,address,type,tel,score "
    					  +"FROM food_house "
    					  +"WHERE cno=?";
    			ps=conn.prepareStatement(sql);
    			ps.setInt(1, cno);
    			ResultSet rs=ps.executeQuery();
    			while(rs.next())
    			{
    				FoodVO vo=new FoodVO();
    				vo.setFno(rs.getInt(1));
    				vo.setName(rs.getString(2));
    				vo.setPoster(rs.getString(3));
    				vo.setAddress(rs.getString(4));
    				vo.setType(rs.getString(5));
    				vo.setTel(rs.getString(6));
    				vo.setScore(rs.getDouble(7));
    				
    				list.add(vo);
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
}











