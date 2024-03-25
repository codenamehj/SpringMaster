package com.sam.app.insa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sam.app.insa.service.DepartmentsService;

@Controller
public class DepartmentsController {

	@Autowired //������ ����
	DepartmentsService departmentsService;
	
	@GetMapping("/getDepartmentsList") //url //get ��� request �ص� ��. �� �ܿ� post�� ����
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/insa/departmentsList");
		mv.addObject("list", departmentsService.getList());
		
		return mv; //ȭ�鿡 �������� �������� ���ϵ�.
	}
}
