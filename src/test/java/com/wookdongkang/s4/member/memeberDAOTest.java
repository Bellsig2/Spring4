package com.wookdongkang.s4.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wookdongkang.s4.MyJunitTest;

public class memeberDAOTest extends MyJunitTest {
	
	@Autowired
	private MemberDAO memberDAO;

	@Test
	public void getIdCheckTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("T2");
		memberDTO = memberDAO.getIdCheck(memberDTO);
		assertNotNull(memberDTO);
	}

}
