package com.example.demo.customer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder			// AllArgs랑 세트
@AllArgsConstructor	// Builder랑 세트
@Entity // 필수. 테이블과 링크될 클래스. @Setter는 불가.
public class Customer {
	
	@Id // Primary Key임을 나타냄.
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // Sequence 생성.
	private Long id;
	
	@Column(length = 20, nullable = false) // 선언하지 않아도 Column. But 추가 옵션이 필요할 경우 사용.
	private String name;
	private String phone;
	
}
