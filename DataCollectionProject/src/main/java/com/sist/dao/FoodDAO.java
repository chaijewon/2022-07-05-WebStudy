package com.sist.dao;
import java.util.*;
import java.sql.*;
public class FoodDAO {
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
		public FoodDAO() // 멤버변수의 초기화 => 시작과 동시에 등록 (드라이버 , 서버연결)
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
		public void categoryInsert(FoodGategoryVO vo)
		{
			try
			{
				getConnection();
				// Sequence => 서버쿼리 사용 => 자동 증가 번호 만들기 
				String sql="INSERT INTO food_category "
						  +"VALUES((SELECT NVL(MAX(cno)+1,1) FROM food_category),"
						  +"?,?,?,?)";
				ps=conn.prepareStatement(sql);
				ps.setString(1, vo.getTitle());
				ps.setString(2, vo.getSubject());
				ps.setString(3, vo.getPoster());
				ps.setString(4, vo.getLink());
				
				ps.executeUpdate();
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
			finally
			{
				disConnection();
			}
		}
		public List<FoodGategoryVO> foodCategoryInfoData()
		{
			List<FoodGategoryVO> list=new ArrayList<FoodGategoryVO>();
			try
			{
				getConnection();
				String sql="SELECT cno,link,title "
						  +"FROM food_category "
						  +"ORDER BY cno ASC";
				ps=conn.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					FoodGategoryVO vo=new FoodGategoryVO();
					vo.setCno(rs.getInt(1));
					vo.setLink(rs.getString(2));
					vo.setTitle(rs.getString(3));
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








