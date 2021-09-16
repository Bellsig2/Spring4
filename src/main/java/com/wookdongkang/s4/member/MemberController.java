package com.wookdongkang.s4.member;

import java.io.Console;
import java.lang.reflect.Parameter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@GetMapping("idCheck")
	public ModelAndView getIdcheck(MemberDTO memberDTO, HttpServletRequest httpServletRequest) throws Exception {
		memberDTO = memberService.getIdCheck(memberDTO);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/idCheck");
		modelAndView.addObject("member", memberDTO);
		System.out.println("id 중복 체크");
		return modelAndView;

	}

	@GetMapping("check")
	public ModelAndView check() throws Exception {
		ModelAndView andView = new ModelAndView();
		andView.setViewName("member/check");
		return andView;
	}

	@GetMapping("join")
	public void join() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/join");
	}

	@PostMapping("join")
	public ModelAndView join(MemberDTO memberDTO, MultipartFile photo, HttpSession httpSession) throws Exception {
		
		String original = photo.getOriginalFilename();
		System.out.println("Original : "+original);
		System.out.println("Name : "+photo.getName());
		
		ModelAndView modelAndView = new ModelAndView();
		int result = memberService.setJoin(memberDTO, photo, httpSession);
		String message = "회원가입 실패";
		if(result>0) {
			message = "화원가입 성공";
		}
		modelAndView.addObject("msg", message);
		modelAndView.addObject("url", "../");
		modelAndView.setViewName("common/result");
		
		return modelAndView;
	}

	@GetMapping("login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/login");
		return modelAndView;
	}

	@PostMapping("login")
	public ModelAndView login(MemberDTO memberDTO, HttpSession session) throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		memberDTO = memberService.getLogin(memberDTO);
		if (memberDTO != null) {
			System.out.println("로그인 성공");
			session.setAttribute("member", memberDTO);
		} else {
			System.out.println("로그인 실패");
		}

		modelAndView.setViewName("redirect:../");
		

		return modelAndView;
	}

	@GetMapping("delete")
	public ModelAndView delete(MemberDTO memberDTO) {
		MemberFilesDTO memberFilesDTO = new MemberFilesDTO();
		memberFilesDTO.setId(memberDTO.getId());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:../");
		memberService.setDelete(memberDTO, memberFilesDTO);
		return modelAndView;
	}

	@GetMapping("logout")
	public ModelAndView logout(HttpSession session) {
		// 1.
		session.removeAttribute("member");
		// 2.
		session.invalidate();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:../");
		return modelAndView;
	}

	@GetMapping("mypage")
	public ModelAndView myPage(HttpSession httpSession) {
		MemberFilesDTO memberFilesDTO = new MemberFilesDTO();
		MemberDTO memberDTO = (MemberDTO) httpSession.getAttribute("member");
		String result = memberDTO.getId();
		memberFilesDTO.setId(result);
		memberFilesDTO = memberService.getSelectFiles(memberFilesDTO);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/mypage");
		/* modelAndView.addObject("file", memberFilesDTO); */
		return modelAndView;
	}
	
	/*
	 * @PostMapping("update") public ModelAndView setUpdate(MemberDTO memberDTO,
	 * HttpSession session) { MemberDTO sessionDTO = (MemberDTO)
	 * session.getAttribute("member"); memberDTO.setId(sessionDTO.getId());
	 * 
	 * }
	 */
}
