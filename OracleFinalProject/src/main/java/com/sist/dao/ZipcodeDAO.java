package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class ZipcodeDAO {
	// 오라클 연결 클래스 
		private Connection conn;
		// 오라클 SQL문장 전송 => 결과값 읽기
		private PreparedStatement ps;
		/*
		 * PreparedStatement : SQL문장 
		 * CallableStatement : PL/SQL => Procedure 
		 * ==> 실행 요청 
		 *     executeQuery =====> 결과값을 받는다 ==> SELECT
		 *     executeUpdate ====> 실행 요청 ==> COMMIT포함 => INSERT,UPDATE,DELETE
		 * ==> 한개의 메소드(기능)에서 SQL문장이 한개이상일 수 있다 
		 *     예) 
		 *          게시판 상세보기 => 1.조회수 증가 , 2. 내용 읽기 
		 *          답변 ==> 5개 SQL , 삭제 ==> 7개 SQL 
		 *          
		 *     => 댓글 , 묻고 답하기 , 답변(실시간 상담) , 공지 , 회원
		 *        -------------------------------------------- 사이트 필수 항목 
		 */
		// 오라클 주소 
		private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
		
		// 드라이버 설정 ==> ojdbc8.jar 
		// 18c,21c ==> ojdbc8.jar 
		public ZipcodeDAO() // 멤버변수의 초기화 => 시작과 동시에 등록 (드라이버 , 서버연결)
		{
			// 한번 수행 => 기능 
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// 리플렉션 ==> 스프링 => 메모리 할당 , 메소드 호출 , 변수의 초기값 주입 
			}catch(Exception ex){}
		}
		// 오라클 연결 ==> sqlplus
		public void getConnection()
		{
			try
			{
				conn=DriverManager.getConnection(URL,"hr","happy");
			}catch(Exception ex){}
		}
		// 오라클 닫기 
		public void disConnection()
		{
			try
			{
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			}catch(Exception ex){}
		}
		///  필수 조건 
		
		// 1. 우편번호 검색 ==> LIKE , NVL
		public List<ZipcodeVO> postFind(String dong)
		{
		   List<ZipcodeVO> list=new ArrayList<ZipcodeVO>();
		   try
		   {
			   // 1. 연결 
			   getConnection();
			   // 2. SQL문장 제작 
			   String sql="SELECT zipcode,sido,gugun,dong,NVL(bunji,' ') "
					     +"FROM zipcode "
					     +"WHERE dong LIKE '%'||?||'%'";
			             // MySQL => CONCAT('%',?,'%') 
			   // 3. 오라클 전송 
			   ps=conn.prepareStatement(sql);
			   // 4. ?에 값을 채운다 
			   ps.setString(1, dong);
			   // 5. 실행후 결과값 받기 
			   ResultSet rs=ps.executeQuery();
			   // 6. rs에 있는 값을 List로 이동 
			   while(rs.next())//처음 위치부터 
			   {
				   ZipcodeVO vo=new ZipcodeVO();
				   vo.setZipcode(rs.getString(1));
				   vo.setSido(rs.getString(2));
				   vo.setGugun(rs.getString(3));
				   vo.setDong(rs.getString(4));
				   vo.setBunji(rs.getString(5));
				   
				   list.add(vo);// 검색된 모든 결과값을 모아서 전송 
			   }
			   rs.close();
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   // 닫기 
			   disConnection();
		   }
		   return list;
		}
		// 2. 검색 수 출력 ==> COUNT
		public int postFindCount(String dong)
		{
			int count=0;
			try
			{
				// 1. 연결 
				getConnection();
				// 2. SQL문장 
				String sql="SELECT COUNT(*) "
						  +"FROM zipcode "
						  +"WHERE dong LIKE '%'||?||'%'";
				// WHERE REGEXP_LIKE(dong,?)
				// 3. SQL문장 전송 
				ps=conn.prepareStatement(sql);
				// 4. ?에 값을 채운다 
				ps.setString(1, dong);
				// 5. 실행후 결과값을 읽어 온다 
				ResultSet rs=ps.executeQuery();
				// 6. rs의 위치 변경 
				rs.next();
				// 7. 값을 받는다 
				count=rs.getInt(1);
				rs.close();
				
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
			finally
			{
				disConnection();
			}
			return count;
		}
		
}













