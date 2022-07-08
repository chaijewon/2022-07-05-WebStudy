package com.sist.dao;
// 사용자 요청을 받아서 => 오라클 연결 => 결과값을 가지고 오는 역할 
import java.sql.*;  // 오라클 연결 => 모든 데이터베이스 연결이 가능 
import java.util.*; // Collection 
/*
 *   1. 드라이버 등록 
 *   2. 오라클 연결 
 *   3. 오라클 연결 해제 
 *   4. 기능 수행 ==> 요구사항 
 *   ---------------------- 
 *      => 1) 목록 출력 ==> 페이지 나눠기 (인라인뷰) 
 *         2) 장르별 처리 ==> WHERE  
 *         3) 검색 => 찾기 ==> LIKE 
 *         
 */
public class MusicDAO {
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
	public MusicDAO() // 멤버변수의 초기화 => 시작과 동시에 등록 (드라이버 , 서버연결)
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
	// 기능 
	// 1. 목록 출력 ==> 페이지 나누기 (핵심) 
	/*
	 *    1. 자바 
	 *    2. 오라클 (*********) ==> 인라인뷰 
	 *    === View : 한개이상의 테이블 참조해서 만든 가상 테이블 
	 *               => 테이블과 동일하게 사용이 가능 
	 *               => DML(INSERT,UPDATE,DELETE) => 실제 참조하는 테이블에 저장 
	 *                  READ ONLY 
	 *               => 종류 ========> SQL문장을 저장하고 나중에 필요시에 재사용 
	 *                  뷰에 저장되는 ==> 실제 데이터 저장이 아니고 SQL문장을 저장하고 있다
	 *                                 보안 , SQL문장을 단순화 
	 *                  1) 단일뷰 : 테이블 한개 연결 => 필요한 데이터만 모아서 사용 
	 *                  2) 복합뷰 : 2개이상의 테이블 => JOIN,SubQuery 
	 *                  3) 인라인뷰 (********) => SELECT 이용한다 
	 *                     => rownum : INSERT시마다 지정되는 ROW의 번호 
	 *                        ------- 단점 => Top-N (처음부터 , 중간(X))
	 *                => 사용 방식 
	 *                CREATE OR REPLACE VIEW view_name
	 *                AS
	 *                  SELECT ~~
	 *                
	 *                ==> 오리클 기록상에 남아 있지 않는다 (한번 사용)
	 *                SELECT ~~
	 *                FROM (SELECT ~~)
	 */
	public List<MusicVO> musicListData(int cno,int page)
	{
		// cno => 장르별 페이지 나누기 
		List<MusicVO> list=new ArrayList<MusicVO>();
		try
		{
			// 무조건 사용이 가능 
			// 1. 오라클 연결 
			getConnection();
			// 2. SQL문장을 만들고 전송 => 오라클 
			String sql="SELECT mno,cno,poster,title,singer,album,idcrement,state,num "
					  +"FROM (SELECT mno,cno,poster,title,singer,album,idcrement,state,rownum as num "
					  +"FROM (SELECT mno,cno,poster,title,singer,album,idcrement,state "
					  +"FROM music "
					  +"WHERE cno=? "
					  +"ORDER BY mno ASC)) "
					  +"WHERE num BETWEEN ? AND ?";
			ps=conn.prepareStatement(sql);
			// ?에 값을 채운다 
			int rowSize=10;
			int start=(rowSize*page)-(rowSize-1); // rownum => 1번부터 
			//  1  , 11 , 21 , 31...
			int end=rowSize*page;
			
			ps.setInt(1, cno);
			ps.setInt(2, start);
			ps.setInt(3, end);
			
			// 실행요청 => 결과값 받기
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				MusicVO vo=new MusicVO();
				vo.setMno(rs.getInt(1));
				vo.setCno(rs.getInt(2));
				vo.setPoster(rs.getString(3));
				vo.setTitle(rs.getString(4));
				vo.setSinger(rs.getString(5));
				vo.setAlbum(rs.getString(6));
				vo.setIdcrement(rs.getInt(7));
				vo.setState(rs.getString(8));
				
				list.add(vo); // 페이지에 출력 갯수만 모아서 웹으로 한번에 전송 
			}
			rs.close();
			
		}catch(Exception ex) 
		{
			ex.printStackTrace(); 
			/*
			 *   에러 메세지 
			 *   getMessage() : 에러 메세지만 출력 
			 *   printStackTrace() : 실행된 과정을 보여준다 (에러부분을 추출)
			 */
		}
		finally
		{
			// 닫기 => 정상,비정상 => try , catch와 상관없이 무조건 수행 
			disConnection(); // 반복 제거 
			// 메소드 => 기능 (재사용) , 반복을 제거 
		}
		return list;
	}
	// 총페이지 가지고 오기 
	public int musicTotalPage(int cno)
	{
		int total=0;
		try
		{
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/10.0) "
					  +"FROM music "
					  +"WHERE cno=?";
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, cno);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return total;
	}
}









