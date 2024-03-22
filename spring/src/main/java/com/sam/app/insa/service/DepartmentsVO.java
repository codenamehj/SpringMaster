package com.sam.app.insa.service;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentsVO {
	private String departmentId;
	private String departmentName;
	private String managerId;
	private String locationId;

}
