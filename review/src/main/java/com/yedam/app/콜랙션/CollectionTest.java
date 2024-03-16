package com.yedam.app.콜랙션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.yedam.app.EmpVO;

/*
 * List, Set, Map
 * list : 				, index	--> 순차적 목록. 제일 많이 씀.
 * set : 				, index	--> 중복값허용X
 * map : <key,value>	, key	--> 검색이 빠름
 */

public class CollectionTest {
	public static void main(String[] args) {
		// 중복값 제거
		List<Integer> list = Arrays.asList(3, 3, 10, 11, 14, 3);
		System.out.println(list);

		// list ==> set
		HashSet<Integer> set = new HashSet<>(list);
		System.out.println(set);

		// List<EmpVO>
		List<EmpVO> empList = new ArrayList<>();
		empList.add(new EmpVO("park", "bbb", 20000));
		empList.add(new EmpVO("choi", "aaa", 10000));
		empList.add(new EmpVO("kim", "ccc", 14000));
		empList.add(new EmpVO("park", "bbb", 20000));

		HashSet<EmpVO> empSet = new HashSet<>(empList);
		for (EmpVO vo : empSet) {
			System.out.println(vo.getFirstName());
		}

		// 필터링 : 급여가 15000 이상인 사원만 검색
		List<EmpVO> filterList = new ArrayList<>();
		for (EmpVO vo : empSet) {
			if (vo.getSalary() >= 15000) {
				filterList.add(vo);
			}
		}
		System.out.println(filterList.size());

		// ==> stream
		filterList = empSet.stream()
						.filter(vo -> vo.getSalary() >= 15000)
						.collect(Collectors.toList());
		System.out.println(filterList.get(0).getSalary());

		filterList = empSet.stream()
						.filter(vo -> vo.getLastName().contains("b"))
						.collect(Collectors.toList());
		System.out.println(filterList.get(0).getLastName());		
	}
}
