package com.yedam.app;

import java.util.Date;
import java.util.Objects;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmpVO {

	@Override
	public int hashCode() {
		return Objects.hash(this.firstName, this.lastName);
	}

	private int employeeId;
	final private String firstName;
	final private String lastName;
	private String email;
	private Date hireDate;
	private Integer salary;
	private String jobId;
	private String departmentId;
	private String managerId;
	private String phone;

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public Integer getSalary() {
		return this.salary;
	}

	public EmpVO(String firstName, String lastName, Integer salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	@Override
	public boolean equals(Object obj) {
		EmpVO vo = (EmpVO) obj; // 부모 자식간 형변환 가능
		return this.firstName.equals(vo.getFirstName()) && this.lastName.equals(vo.getLastName());
	}
}
