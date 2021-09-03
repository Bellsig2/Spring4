package com.wookdongkang.s4.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/notice/*")
@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("noticeList")
	public ModelAndView list(ModelAndView modelAndView) {
		List<NoticeDTO> ar = noticeService.getList();
		modelAndView.setViewName("./notice/noticeList"); // ?
		modelAndView.addObject("list", ar);
		return modelAndView;
	}
	
	@RequestMapping("noticeSelect")
	public void select(Model model, NoticeDTO noticeDTO) {
		noticeDTO = noticeService.getSelect(noticeDTO);
		model.addAttribute("num", noticeDTO);
	}
	
	@RequestMapping(value="noticeInsert", method = RequestMethod.GET)
	public void insert() {
		
	}
	
	@RequestMapping(value = "noticeInsert", method = RequestMethod.POST)
	public String insert(NoticeDTO noticeDTO) {
		int result = noticeService.setInsert(noticeDTO);
		return "redirect:./noticeList";
	}
	
	@RequestMapping("noticeDelete")
	public String delete(NoticeDTO noticeDTO) {
		noticeService.setDelete(noticeDTO);
		return "redirect:./noticeList";
	}
}
