package com.wookdongkang.s4.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession session;
	private final String NAMEPSACE = "com.wookdongkang.s4.member.MemberDAO.";
	
	public MemberDTO getIdCheck(MemberDTO memberDTO) {
		return session.selectOne(NAMEPSACE+"getIdCheck", memberDTO);
	}
	
	public MemberDTO getLogin(MemberDTO memberDTO) {
		return session.selectOne(NAMEPSACE+"getLogin", memberDTO);
	}
	
	public int setJoin(MemberDTO memberDTO) {
		return session.insert(NAMEPSACE+"setJoin", memberDTO);
	}
	
	public int setDelete(MemberDTO memberDTO) {
		return session.delete(NAMEPSACE+"setDelete", memberDTO);
	}
	
	public int setUpdate(MemberDTO memberDTO) {
		return session.update(NAMEPSACE+"setUpdate", memberDTO);
	}
	
	public int setFileInsert(MemberFilesDTO memberFilesDTO) {
		return session.insert(NAMEPSACE+"setFileInsert", memberFilesDTO);
	}
	
	public MemberFilesDTO getSelectFiles(MemberFilesDTO memberFilesDTO) {
		return session.selectOne(NAMEPSACE+"getSelectFiles", memberFilesDTO);
	}
	     
}
