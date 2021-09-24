package com.wookdongkang.s4.board.notice;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wookdongkang.s4.board.BoardDTO;
import com.wookdongkang.s4.board.BoardFilesDTO;
import com.wookdongkang.s4.board.CommentsDTO;
import com.wookdongkang.s4.util.Pager;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;

	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}

	@GetMapping("down")
	public ModelAndView fileDown(BoardFilesDTO boardFilesDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", boardFilesDTO);
		mv.setViewName("fileDown");
		return mv;
	}

	@GetMapping("select")
	public ModelAndView getSelect(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getSelect(boardDTO);
		List<BoardFilesDTO> ar = noticeService.getFiles(boardDTO);
		/* List<CommentsDTO> comments = noticeService.getCommentsList(null) */
		/* mv.addObject("comments", comments); */
		/* mv.addObject("fileList",ar); */
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/select");
		return mv;
	}

	@GetMapping("insert")
	public String setInsert() throws Exception {
		System.out.println("test");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/insert");
		return "board/insert";
	}

	@PostMapping("insert")
	public ModelAndView setInsert(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		for (MultipartFile name : files) {
			System.out.println(name.getOriginalFilename());
		}

		ModelAndView mv = new ModelAndView();
		int result = noticeService.setInsert(boardDTO, files);
		mv.setViewName("redirect:./list");

		return mv;
	}

	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/list");

		List<BoardDTO> ar = noticeService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);

		return mv;
	}

	@GetMapping("delete")
	public ModelAndView setDelete(BoardDTO boardDTO) throws Exception {
		int result = noticeService.setDelete(boardDTO);
		ModelAndView mv = new ModelAndView();
		String message = "Delete Success";
		if (result > 0) {
			message = "Delete Success";
		}
		mv.addObject("msg", message);
		mv.addObject("url", "./list");

		mv.setViewName("common/result");

		return mv;
	}

	@PostMapping("comment")
	public ModelAndView comment(CommentsDTO commentsDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		commentsDTO.setBoard("N");
		int result = noticeService.setComments(commentsDTO);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}

	@GetMapping("getCommentList")
	public ModelAndView getCommentsList(CommentsDTO commentsDTO, Pager pager)throws Exception {
		commentsDTO.setBoard("N");
		List<CommentsDTO> ar = noticeService.getCommentList(commentsDTO, pager);
		ModelAndView mv = new ModelAndView();
		mv.addObject("comments", ar);
		mv.addObject("pager", pager);
		mv.setViewName("common/ajaxList");
		return mv;
	}
	
	@PostMapping("commentDel")
	public ModelAndView commentDel(CommentsDTO commentsDTO) throws Exception {
		int result = noticeService.delComments(commentsDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		return mv;
	}
	
	

	  @PostMapping("commentUpdate") 
	  public ModelAndView updateComment(CommentsDTO commentsDTO) {
		  ModelAndView modelAndView = new ModelAndView();
		  int result = noticeService.updateComments(commentsDTO);
		  modelAndView.setViewName("common/ajaxResult");
		  modelAndView.addObject("result", result);
		  return modelAndView;
	  }
	
}