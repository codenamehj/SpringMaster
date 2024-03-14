package com.example.demo.di;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Component
@Data
@RequiredArgsConstructor
@Scope("prototype") // singleton(기본값), prototype, request, session
public class Restaurant {
//	@Setter(onMethod_ = { @Autowired }) // Setter 주입
	final private Chef chef; // 생성자 주입
}
