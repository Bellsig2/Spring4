package com.wookdongkang.s4;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wookdongkang.s4.notice.NoticeDAO;
import com.wookdongkang.s4.notice.NoticeDTO;

public class SqlSessionTest extends MyJunitTest {
	
	@Autowired
	private NoticeDAO noticeDAO; 
		
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void test() {
		assertNotNull(sqlSession);
	}
	
	@Test
	public void list() {
		List<NoticeDTO> list = noticeDAO.getList();
	}
	
	@Test
	public void select() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(2);
		noticeDTO = noticeDAO.getSelect(noticeDTO);
		assertNotNull(noticeDTO);
	}

}
