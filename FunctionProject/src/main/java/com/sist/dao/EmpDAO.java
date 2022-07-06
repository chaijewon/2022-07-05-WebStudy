package com.sist.dao;
import java.util.*;
import java.sql.*;
public class EmpDAO {
    private Connection conn;
    private PreparedStatement ps;
    // CallableStatement cs; ==> Procedure 
    private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
    // 드라이버 
    public EmpDAO()
    {
    	try
    	{
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    	}catch(Exception ex){}
    }
    // 
    // 연결 
    public void getConnection()
    {
    	try
    	{
    		conn=DriverManager.getConnection(URL,"hr","happy");
    	}catch(Exception ex){}
    }
    // 닫기
    public void disConnection()
    {
    	try
    	{
    		if(ps!=null) ps.close();
    		if(conn!=null) conn.close();
    	}catch(Exception ex){}
    }
    // 기능 => JOIN
    public List<EmpVO> empListData1()
    {
    	List<EmpVO> list=new ArrayList<EmpVO>();
    	try
    	{
    		getConnection();
    		String sql="SELECT empno,ename,job,hiredate,sal,dname,loc,grade "
    				  +"FROM emp,dept,salgrade "
    				  +"WHERE emp.deptno=dept.deptno "
    				  +"AND sal BETWEEN losal AND hisal";
    		ps=conn.prepareStatement(sql);
    		ResultSet rs=ps.executeQuery();
    		while(rs.next())
    		{
    			EmpVO vo=new EmpVO();
    			vo.setEmpno(rs.getInt(1));
    			vo.setEname(rs.getString(2));
    			vo.setJob(rs.getString(3));
    			vo.setHiredate(rs.getDate(4));
    			vo.setSal(rs.getInt(5));
    			vo.setDname(rs.getString(6));
    			vo.setLoc(rs.getString(7));
    			vo.setGrade(rs.getInt(8));
    			
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
    // Function이용
    public List<EmpVO> empListData2()
    {
    	List<EmpVO> list=new ArrayList<EmpVO>();
    	try
    	{
    		getConnection();
    		String sql="SELECT empno,ename,job,hiredate,sal,"
    				  +"getDname(deptno),getLoc(deptno),getGrade(sal) "
    				  +"FROM emp";
    		ps=conn.prepareStatement(sql);
    		ResultSet rs=ps.executeQuery();
    		while(rs.next())
    		{
    			EmpVO vo=new EmpVO();
    			vo.setEmpno(rs.getInt(1));
    			vo.setEname(rs.getString(2));
    			vo.setJob(rs.getString(3));
    			vo.setHiredate(rs.getDate(4));
    			vo.setSal(rs.getInt(5));
    			vo.setDname(rs.getString(6));
    			vo.setLoc(rs.getString(7));
    			vo.setGrade(rs.getInt(8));
    			
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









