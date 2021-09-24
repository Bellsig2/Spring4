package com.wookdongkang.s4.ajaxTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ajax/*")
public class AjaxTestContoller {
	
	@GetMapping("t1")
	public ModelAndView v1(Integer num) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("t1 test");
		modelAndView.setViewName("common/ajaxResult");
		modelAndView.addObject("result", "iu");
		return modelAndView;
		}
}
