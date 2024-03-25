package com.dbal.app.book.model;



import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookVO {
	private Integer bookNo;
	private String bookName;
	private String bookCoverimg;
	private Date bookDate;
	private Integer bookPrice;
	private String bookPublisher;
	private String bookInfo;
	
	private Integer rentNo;
	private Integer rentPrice;
	private Date rentDate;
	private String rentStatus;
	
}
