package com.sist.dao;
import java.sql.*;
import java.util.*;
// JSP => DBCP 
// 프로젝트 => MyBatis

import com.sist.vo.BoardVO;
public class BoardDAO {
   private Connection conn;// 연결 
   private PreparedStatement ps;// SQL문장 송수신 
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   // 드라이버 등록 
   public BoardDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	   }catch(Exception ex){}
   }
   // 연결 
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
	   }catch(Exception ex)
	   {
		   System.out.println("getConnection():에러");
		   ex.printStackTrace();
	   }
	   
   }
   // 해제 
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex)
	   {
		   System.out.println("disConnection():에러");
		   ex.printStackTrace();
	   }
   }
   // 기능 
   // 1-1 목록 출력 (인라인뷰) 
   public List<BoardVO> boardListData(int page)
   {
	   List<BoardVO> list=new ArrayList<BoardVO>();
	   try
	   {
		   // /*+ ~~
		   // --+
		   getConnection();
		   String sql="SELECT no,subject,name,regdate,hit,num "
				     +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
				     +"FROM (SELECT /*+ INDEX_DESC(freeboard fb_no_pk)*/ no,subject,name,regdate,hit "
				     +"FROM freeboard)) "
				     +"WHERE num BETWEEN ? AND ?";
		   ps=conn.prepareStatement(sql);
		   // ?에 값을 채운다 
		   int rowSize=10;
		   int start=(page*rowSize)-(rowSize-1);
		   int end=page*rowSize;
		   ps.setInt(1, start);
		   ps.setInt(2, end);
		   // String s=new Date()
		   // 실행 
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   BoardVO vo=new BoardVO();
			   vo.setNo(rs.getInt(1));
			   vo.setSubject(rs.getString(2));
			   vo.setName(rs.getString(3));
			   vo.setRegdate(rs.getDate(4));
			   vo.setHit(rs.getInt(5));
			   
			   list.add(vo);
		   }
		   rs.close();
		   
	   }catch(Exception ex)
	   {
		   System.out.println("boardListData:에러");
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
	   return list;
   }
   // 1-2 총페이지 (CEIL)
   public int boardTotal()
   {
	   int total=0;
	   try
	   {
		   getConnection();
		   String sql="SELECT CEIL(COUNT(*)/10.0) FROM freeboard";
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   total=rs.getInt(1);
		   rs.close();
	   }catch(Exception ex)
	   {
		   System.out.println("boardTotal:에러");
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
	   return total;
   }
   // 상세보기 
   // 수정 , 삭제 
   // 새글 => 회원가입 , 장바구니 , 예매 ...
   public void boardInsert(BoardVO vo)
   {
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO freeboard(no,name,subject,content,pwd) "
				      +"VALUES((SELECT NVL(MAX(no)+1,1) FROM freeboard),?,?,?,?)";
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, vo.getName());
		   ps.setString(2, vo.getSubject());
		   ps.setString(3, vo.getContent());
		   ps.setString(4, vo.getPwd());
		   
		   ps.executeUpdate();
	   }catch(Exception ex)
	   {
		   System.out.println("boardInsert:에러");
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   // 찾기 
   
}







