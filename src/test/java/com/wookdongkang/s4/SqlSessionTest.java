package com.wookdongkang.s4;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wookdongkang.s4.notice.NoticeDAO;
import com.wookdongkang.s4.notice.NoticeDTO;

import oracle.sql.DATE;

public class SqlSessionTest extends MyJunitTest {
	private Random random;

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

	@Test
	public void math() {
		random = new Random();
		Date date = new Date(21, 9, 3);

		int result = 0;

		for (int i = 35; i < 300; i++) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setNum(random.nextInt(300));
			noticeDTO.setTitle("t" + i);
			noticeDTO.setContents("c" + i);
			noticeDTO.setWriter("w" + i);
			noticeDTO.setRegdate(date);
			noticeDTO.setHits(0);
			result = noticeDAO.setInsert(noticeDTO);
		}
		assertEquals(0, result);
	}

}
