package com.wookdongkang.s4.board.notice;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wookdongkang.s4.board.BoardDTO;
import com.wookdongkang.s4.board.BoardFilesDTO;
import com.wookdongkang.s4.board.BoardService;
import com.wookdongkang.s4.util.FileManager;
import com.wookdongkang.s4.util.Pager;

@Service
public class NoticeService implements BoardService {
	@Autowired
	private NoticeDAO noticeDAO;
	@Autowired
	private ServletContext servletConetext;
	@Autowired
	private FileManager fileManger;

	public List<BoardFilesDTO> getFiles(BoardDTO boardDTO)throws Exception{
		return noticeDAO.getFiles(boardDTO);
	}
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		Long totalCount = noticeDAO.getCount(pager);
		pager.makeNum(totalCount);
		pager.makeRow();

		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
				
		noticeDAO.setHitUpdate(boardDTO);
		return noticeDAO.getSelect(boardDTO);
	}

	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		String realPath = servletConetext.getRealPath("/resources/upload/notice/");
		System.out.println(realPath);
		File file = new File(realPath);
		int result = noticeDAO.setInsert(boardDTO);
		
		
		for(MultipartFile multipartFile:files) {
			String fileName = fileManger.fileSave(multipartFile, file);
			BoardFilesDTO boardFilesDTO = new BoardFilesDTO();
			boardFilesDTO.setFileName(fileName);
			boardFilesDTO.setOriName(multipartFile.getOriginalFilename());
			boardFilesDTO.setNum(boardDTO.getNum());
			result = noticeDAO.setFile(boardFilesDTO);
		}
		
		

		return result;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		//Files Table에서 삭제할 파일명들 조회
		List<BoardFilesDTO> ar = noticeDAO.getFiles(boardDTO);
		
		//어느 폴더
		String realPath = servletConetext.getRealPath("/resources/upload/notice/");
		for(BoardFilesDTO boardFilesDTO: ar) {
			File file = new File(realPath, boardFilesDTO.getFileName());
			fileManger.fileDelete(file);
		}		
		
		noticeDAO.setDelete(boardDTO);
		
		return 0;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
