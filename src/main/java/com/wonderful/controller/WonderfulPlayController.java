package com.wonderful.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/wonderful/play")
public class WonderfulPlayController {

	@RequestMapping(value="/text",method=RequestMethod.POST)
	@ResponseBody
	public String play(HttpServletRequest request){
		System.out.println("wonderful play -> text");
		return "success";
	}
	
	@RequestMapping(value="/text",method=RequestMethod.GET)
	@ResponseBody
	public String playTest(HttpServletRequest request){
		System.out.println("wonderful play -> text test");
		return "success";
	}
}
