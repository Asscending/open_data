package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BoardVo {
	private int b_no;
	private int no;
	private String title;
	private String content;
	private int hit;
	private String b_date;
	private String name;
}
