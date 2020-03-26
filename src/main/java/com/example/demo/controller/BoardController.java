package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.BoardDao;
import com.google.gson.Gson;

@RestController
public class BoardController {

	@Autowired
	BoardDao dao;

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}
	
	//리스트
	@RequestMapping(value = "/listBoard", produces = "application/json;charset=utf8")
	public String listBoard() {
		String str = "";
		Gson gson = new Gson();
		str = gson.toJson(dao.viewBoard());
		return str;
	}
	
}
