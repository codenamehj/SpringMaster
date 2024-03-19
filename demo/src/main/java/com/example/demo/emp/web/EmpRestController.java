package com.example.demo.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;
import com.example.demo.emp.service.EmpService;

import common.Paging;

@RestController // 이걸 쓰면 @ResponseBody가 필요 없음.
//@Controller
public class EmpRestController {

	@Autowired
	EmpService service;

	// 리스트 페이지 이동. model 필요X
	@RequestMapping("/empMng")
	public ModelAndView empMng() { // @RestController 사용 시 ModelAndView로 페이지 이동.
		ModelAndView mv = new ModelAndView("empMng");
		return mv;
	}

	// 사원 리스트 데이터
	@GetMapping("/ajax/empList")
//	@ResponseBody // <-- ajsx에서는 필수 		vo -> json string
	public Map<String, Object> empList(EmpVO vo, SearchVO svo, Paging pvo) {
//		pvo.setPageSize(3);
//		pvo.setPageUnit(5);
		svo.setStart(pvo.getFirst());
		svo.setEnd(pvo.getLast());
		Map<String, Object> map = service.getEmpList(vo, svo);
		pvo.setTotalRecord((Long) map.get("count"));
		map.put("paging", pvo);

		return map;
	}

	@PostMapping("/ajax/emp")
	public EmpVO save(@RequestBody EmpVO vo) {
		System.out.println(vo);
		service.insertEmp(vo);
		return vo;
	}

	@GetMapping("/ajax/emp/{empId}")
	public EmpVO info(@PathVariable int empId) {
		return service.getEmpInfo(empId);
	}
	
	@GetMapping("/ajax/empStat")
	public List<Map<String,Object>> stat() {
		return service.getStat();
	}
}
