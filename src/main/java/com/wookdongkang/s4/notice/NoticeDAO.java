package com.wookdongkang.s4.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO {
	
	@Autowired
	private SqlSession session;
	private final String NAMESPACE = "com.wookdongkang.s4.notice.NoticeDAO.";
	
	public List<NoticeDTO> getList() {
		return session.selectList(NAMESPACE+"getList");
	}
	
	public NoticeDTO getSelect(NoticeDTO noticeDTO) {
		return session.selectOne(NAMESPACE+"getSelect", noticeDTO);
	}
	
	public int setInsert(NoticeDTO noticeDTO) {
		return session.insert(NAMESPACE+"setInsert", noticeDTO);
	}
	
	public int setDelete(NoticeDTO noticeDTO) {
		return session.delete(NAMESPACE+"setDelete", noticeDTO);
	}
}
