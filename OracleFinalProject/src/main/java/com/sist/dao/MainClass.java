package com.sist.dao;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("동/읍/명 입력:");
        String dong=scan.next(); //<input type=text> <input type=submit>
        
        ZipcodeDAO dao=new ZipcodeDAO();
        int count=dao.postFindCount(dong);
        
        if(count==0) // 검색된 결과가 없다
        {
        	System.out.println("검색된 결과가 없습니다!!");
        }
        else // 검색된 결과가 있다 
        {
        	System.out.println("검색결과 "+count+"건");
        	List<ZipcodeVO> list=dao.postFind(dong); 
        	for(ZipcodeVO vo:list) //<table>
        	{
        		System.out.println(vo.getZipcode()+" "
        				+vo.getAddress());
        	}
        	
        }
	}

}
