package com.example.demo.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;
import com.example.demo.emp.mapper.EmpMapper;

import common.Paging;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller // 컨테이너 빈 등록 + 사용자 요청처리 할 수 있는 커맨드 핸들러 변환
public class EmpController {

	final EmpMapper mapper; // 의존성 주입(DI : Dependency Injection)

//	@RequestMapping("/update")
//	@ResponseBody	   //↗request.getParameter
//	public String update(@RequestParam List<String> hobby) {
//		System.out.println(hobby);
//		return "true";
//	}

	@RequestMapping("/empResult")
	public String result() {
		return "result";
	}

	@GetMapping("/info/{empId}")
	public String info(@PathVariable int empId, Model model) {
		model.addAttribute("emp", mapper.getEmpInfo(empId));
		return "empInfo";
	}
	
	@GetMapping("/update/{empId}")
	public String update(@PathVariable int empId) {
		System.out.println(empId);
		return "index";
	}

	@GetMapping("/delete")
	public String delete(int employeeId, String name) {
		System.out.println(employeeId + name);
		return "index";
	}

	@RequestMapping("/empList")
	public String empList(Model model, EmpVO vo, SearchVO svo, Paging pvo) {
//		model.addAttribute("companyName", "<i><font color='green'>예담주식회사</font></i>");
		// 페이징 처리
		pvo.setPageUnit(5); // 데이터 수
		pvo.setPageSize(3); // 페이지 번호 수
		svo.setStart(pvo.getFirst());
		svo.setEnd(pvo.getLast());
		pvo.setTotalRecord(mapper.getCount(vo, svo));
		model.addAttribute("paging", pvo);
		
		// 목록 조회
		model.addAttribute("empList", mapper.getEmpList(vo, svo));
		return "empList";
	}

	@PostMapping("/insert3")
	public String insert3(EmpVO vo, RedirectAttributes rttr) {
		System.out.println("등록 : " + vo);
		rttr.addAttribute("insertResult", "성공");
		rttr.addFlashAttribute("flashResult", "한번만 사용가능");
		return "redirect:empResult";
	}

	@RequestMapping("/ajaxEmp")
	@ResponseBody
	public List<EmpVO> ajaxEmp() {
		return mapper.getEmpList(null, null);
	}

	@PostMapping("/insert2")
	public ResponseEntity<EmpVO> insert2(EmpVO vo) {
		return new ResponseEntity<>(vo, HttpStatus.OK);
	}

	@PostMapping("/insert")
//	@ResponseBody
	public ModelAndView insert(@ModelAttribute("emp") EmpVO vo) {
		System.out.println(vo);
//		mapper.insertEmp(vo);
		// 커맨드 객체는 model에 추가
//		model.addAttribute("empVO", vo);
//		model.addAttribute("insertResult", "success");

		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("insertResult", "success");
		mv.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		return mv;
	}

	@GetMapping("/")
	public String test() {
		return "index"; // "/template(기본값-동적 컨텐츠)/index.html"
	}
}
