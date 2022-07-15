package com.sist.conn;
import java.sql.*;
public class DBConnection {
  private Connection conn;
  private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
  private static DBConnection dbconn;
  // 드라이버 등록 
  public DBConnection()
  {
	  try
	  {
		  Class.forName("oracle.jdbc.driver.OracleDriver");
	  }catch(Exception ex){}
  }
  // 싱글턴 
  public static DBConnection newInstance()
  {
	  if(dbconn==null)
		  dbconn=new DBConnection();
	  return dbconn;
  }
  // 연결
  public Connection getConnection()
  {
	  try
	  {
		  conn=DriverManager.getConnection(URL,"hr","happy");
	  }catch(Exception ex){}
	  
	  return conn;
  }
  // 해제 
  public void disConnection(PreparedStatement ps)
  {
	  try
	  {
		  if(ps!=null) ps.close();
		  if(conn!=null) conn.close();
	  }catch(Exception ex){}
  }
}








