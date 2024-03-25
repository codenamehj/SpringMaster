package com.sam.app.insa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sam.app.insa.service.DepartmentsService;

@Controller
public class DepartmentsController {

	@Autowired //의존성 주입
	DepartmentsService departmentsService;
	
	@GetMapping("/getDepartmentsList") //url //get 대신 request 해도 됨. 그 외에 post도 있음
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/insa/departmentsList");
		mv.addObject("list", departmentsService.getList());
		
		return mv; //화면에 보여지는 페이지가 리턴됨.
	}
}
