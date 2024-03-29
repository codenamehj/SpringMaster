package com.example.demo.emp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.emp.mapper.EmpMapper;

@SpringBootTest
public class EmpMapperTest {
	@Autowired
	EmpMapper mapper;

	@Test
	public void 사원통계() {
		List<Map<String, Object>> list = mapper.getStat();
		// for departmentId cnt 만 출력
		for (Map<String, Object> map : list) {
			System.out.println(map.get("name") + " : " + map.get("cnt"));
		}
//		System.out.println(list);
		;
	}

	@Test
	public void 사원삭제() {
		int result = mapper.deleteEmp(211);
		System.out.println("삭제건수 = " + result);
	}

	@Test
	public void 사원등록() {
		// vo 객체 생성
		// 값을 담고
		// 필수입력 EMPLOYEE_ID, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID
		EmpVO vo = EmpVO.builder()
//				.employeeId(211)
				.lastName("Jessie").email("jessie211@naver.com").hireDate(new Date()).jobId("IT_PROG").build();

		int result = mapper.insertEmp(vo);

		// 등록된 사번을 조회
		System.out.println("등록된 사번 : " + vo.getEmployeeId());
		System.out.println("등록건수 = " + result);
	}

	@Test
	public void 사원전체조회() {
		EmpVO vo = new EmpVO();
		SearchVO svo = new SearchVO();
//		vo.setDepartmentId("50");
//		vo.setFirstName("Kevin");
//		vo.setManagerId("103");
//		vo.setEmployeeIds(new int[] { 100, 101, 102 });
//		vo.setStart(1);
//		vo.setEnd(100);
		svo.setEmployeeIds(new int[] { 100, 101, 102 });
		List<EmpVO> list = mapper.getEmpList(vo, svo);
		// for employeeId, firstName 출력
		for (EmpVO empVO : list) {
			System.out.println(empVO.employeeId + " : " + empVO.firstName);
		}
		System.out.println("결과는 " + list.size());

	}
//		assertEquals(list);

	@Test
	public void 사원단건조회() {
		int employeeId = 100;
		EmpVO vo = mapper.getEmpInfo(employeeId);
		System.out.println(vo);
//		assertEqual(employeeId, vo.getEmployeeId());
	}
}
