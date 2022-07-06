package com.sist.dao;
// 오라클에 있는 데이터 읽기 ===> 웹 
import java.util.*;

import oracle.jdbc.OracleTypes;

import java.sql.*;
public class StudentDAO {
    private Connection conn;
    private CallableStatement cs;
    private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
    public StudentDAO()
    {
    	try
    	{
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    	}catch(Exception ex) {}
    }
    public void getConnection()
    {
    	try
    	{
    		conn=DriverManager.getConnection(URL,"hr","happy");
    	}catch(Exception ex) {}
    }
    public void disConnection()
    {
    	try
    	{
    		if(cs!=null) cs.close();
    		if(conn!=null) conn.close();
    	}catch(Exception ex){}
    }
    public List<StudentVO> stdListData()
    {
    	List<StudentVO> list=new ArrayList<StudentVO>();
    	try
    	{
    		getConnection();
    		String sql="{CALL studentListData(?)}";
    		cs=conn.prepareCall(sql);
    		cs.registerOutParameter(1, OracleTypes.CURSOR);
    		cs.executeQuery();
    		ResultSet rs=(ResultSet)cs.getObject(1);
    		while(rs.next())
    		{
    			StudentVO vo=new StudentVO();
    			vo.setHakbun(rs.getInt(1));
    			vo.setName(rs.getString(2));
    			vo.setKor(rs.getInt(3));
    			vo.setEng(rs.getInt(4));
    			vo.setMath(rs.getInt(5));
    			
    			list.add(vo);
    		}
    		rs.close();
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    	finally
    	{
    		disConnection();
    	}
    	return list;
    }
}





