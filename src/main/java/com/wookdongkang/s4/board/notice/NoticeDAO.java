package com.wookdongkang.s4.board.notice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.wookdongkang.s4.board.BoardDAO;
import com.wookdongkang.s4.board.BoardDTO;
import com.wookdongkang.s4.board.BoardFilesDTO;
import com.wookdongkang.s4.board.CommentsDTO;
import com.wookdongkang.s4.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.wookdongkang.s4.board.notice.NoticeDAO.";
	
	public int updateComments(CommentsDTO commentsDTO) {
		return sqlSession.update(NAMESPACE+"updateComments", commentsDTO);
	}

	public Long getCommentCount(CommentsDTO commentsDTO) {
		return sqlSession.selectOne(NAMESPACE + "getCommentCount", commentsDTO);
	}

	public List<BoardFilesDTO> getFiles(BoardDTO boardDTO) {
		return sqlSession.selectList(NAMESPACE + "getFiles", boardDTO);
	}

	public List<CommentsDTO> getCommentList(Map<String, Object> map) {
		return sqlSession.selectList(NAMESPACE + "getCommentList", map);
	}

	public int setComment(CommentsDTO commentsDTO) {
		return sqlSession.insert(NAMESPACE + "setComment", commentsDTO);
	}

	public int delComments(CommentsDTO commentsDTO) {
		return sqlSession.delete(NAMESPACE + "delComments", commentsDTO);
	}

	@Override
	public Long getCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + "getCount", pager);
	}

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + "getList", pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + "getSelect", boardDTO);
	}

	@Override
	public int setHitUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE + "setHitUpdate", boardDTO);
	}

	@Override
	public int setFile(BoardFilesDTO boardFilesDTO) {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE + "setFile", boardFilesDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE + "setInsert", boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE + "setDelete", boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boradDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
