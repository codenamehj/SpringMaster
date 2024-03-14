package com.example.demo.emp.web;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;
import com.example.demo.emp.mapper.EmpMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller // 컨테이너 빈 등록 + 사용자 요청처리 할 수 있는 커맨드 핸들러 변환
public class EmpController {

	final EmpMapper mapper; // 의존성 주입(DI : Dependency Injection)

	// 등록페이지 이동
	@GetMapping("/emp/insert")
	public void insert() {

	}

	// 등록처리 --> photo employees 테이블에 photo 컬럼 추가
	@PostMapping("/insert")
	public String insert(@ModelAttribute("emp") EmpVO vo, MultipartFile photoFile)
			throws IllegalStateException, IOException {
		System.out.println(vo);
		if (photoFile != null) {
			// 파일 생성
			File file = new File("d:/upload", photoFile.getOriginalFilename());
			// 파일 저장
			photoFile.transferTo(file);
			vo.setPhoto(photoFile.getOriginalFilename());
		}
		mapper.insertEmp(vo);
		return "redirect:/emp/list";
	}

	// 수정페이지 이동
	@GetMapping("/emp/update/{employeeId}")
	public String update(@PathVariable("employeeId") int employeeId, Model model) {
		model.addAttribute("empInfo", mapper.getEmpInfo(employeeId));
		return "emp/update";
	}

	// 수정처리
	@PostMapping("/update")
	public String updateInfo(@ModelAttribute("emp") EmpVO vo, MultipartFile photoFile)
			throws IllegalStateException, IOException {
		System.out.println(vo);
		if (photoFile != null) {
			// 파일 생성
			File file = new File("d:/upload", photoFile.getOriginalFilename());
			// 파일 저장
			photoFile.transferTo(file);
			vo.setPhoto(photoFile.getOriginalFilename());
		}
		mapper.updateEmp(vo);
		return "redirect:/emp/list";
	}
	
	// 삭제처리
	@RequestMapping("/emp/delete")
	public String delete(@RequestParam(name = "employeeId") int employeeId) {
		mapper.deleteEmp(employeeId);
		return "redirect:/emp/list";
	}

	// 상세조회 페이지 이동
	@GetMapping("/emp/info/{employeeId}")
	public String info(@PathVariable("employeeId") int employeeId, Model model) {
		model.addAttribute("empInfo", mapper.getEmpInfo(employeeId));
		return "emp/info";
	}

	// 목록페이지 이동
	@RequestMapping("/emp/list")
	public String empList(Model model, EmpVO vo, SearchVO svo) {
		model.addAttribute("empList", mapper.getEmpList(vo, svo));
		return "emp/list";
	}
}
