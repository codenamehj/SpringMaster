package com.example.demo.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;
import com.example.demo.emp.mapper.EmpMapper;

import common.Paging;

@RestController // 이걸 쓰면 @ResponseBody가 필요 없음.
//@Controller
public class EmpRestController {
	
	@Autowired EmpMapper mapper;
	
	// 리스트 페이지 이동. model 필요X
	@RequestMapping("/empMng")
	public ModelAndView empMng() { // @RestController 사용 시 ModelAndView로 페이지 이동.
		ModelAndView mv = new ModelAndView("empMng");
		return mv;
	}
	
	// 사원 리스트 데이터
	@GetMapping("/ajax/empList")
//	@ResponseBody // <-- ajsx에서는 필수 		vo -> json string
	public  List<EmpVO> empList(EmpVO vo, SearchVO svo, Paging pvo){
		svo.setStart(pvo.getFirst());
		svo.setEnd(pvo.getLast());
		return mapper.getEmpList(vo, svo);
	}
	
	@PostMapping("/ajax/emp")
	public EmpVO save(@RequestBody EmpVO vo) {
		System.out.println(vo);
		mapper.insertEmp(vo);
		return vo;
	}
	
	@GetMapping("/ajax/emp/{empId}")
	public EmpVO info(@PathVariable int empId) {
		return mapper.getEmpInfo(empId);
	}
}
