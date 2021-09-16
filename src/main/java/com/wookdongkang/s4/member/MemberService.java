package com.wookdongkang.s4.member;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private ServletContext servletContext;

	public MemberDTO getIdCheck(MemberDTO memberDTO) throws Exception {
		return memberDAO.getIdCheck(memberDTO);
	}

	public MemberDTO getLogin(MemberDTO memberDTO) throws Exception {
		return memberDAO.getLogin(memberDTO);
	}

	public int setJoin(MemberDTO memberDTO, MultipartFile photo, HttpSession httpSession) throws Exception {
		int result = memberDAO.setJoin(memberDTO);
		if(photo.getOriginalFilename()!=null) {
			
		// 1. 어느 폴더에 저장
		// 2. application(ServletContext) 객체로 저장할 실제 경로 구하기
		ServletContext sContext = httpSession.getServletContext();
		String realPath = sContext.getRealPath("/resources/upload/member/");
		System.out.println("RealPath :" +realPath);
		
		// 3. 폴더 확인
		File file = new File(realPath);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		//4. 파일 저장
		String fileName = UUID.randomUUID().toString();
		fileName = fileName +  "_" + photo.getOriginalFilename();
		System.out.println(fileName);
		
		file = new File(file, fileName);
		
		//5. 폴더에 파일을 저장
		//1) MultipartFile의 transferTo 메서드 사용
		/* photo.transferTo(file); */
		
		
		//2) Spring의 API FileCopyUtils의 copy 메서드 사용
		FileCopyUtils.copy(photo.getBytes(), file);
		
		MemberFilesDTO memberFilesDTO = new MemberFilesDTO();
		memberFilesDTO.setFilename(fileName);
		memberFilesDTO.setOriname(photo.getOriginalFilename());
		memberFilesDTO.setId(memberDTO.getId());
		result = memberDAO.setFileInsert(memberFilesDTO);
		}
		
		return result;
	
	}

	public int setDelete(MemberDTO memberDTO, MemberFilesDTO memberFilesDTO) {
		//1. 어느 폴더
		String realPath = servletContext.getRealPath("resoulces/upload/member");
		//2. 어느 파일
		memberFilesDTO = memberDAO.getSelectFiles(memberFilesDTO);
		
		//3. 파일 삭제
		File file = new File(realPath, memberFilesDTO.getFilename());
		file.delete();
		
		return memberDAO.setDelete(memberDTO);
	}

	public int setUpdate(MemberDTO memberDTO) {
		return memberDAO.setUpdate(memberDTO);
	}
	
	public MemberFilesDTO getSelectFiles(MemberFilesDTO memberFilesDTO) {
		return memberDAO.getSelectFiles(memberFilesDTO);
	}
}
