package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.BoardManager;
import com.example.demo.vo.BoardVo;

@Repository
public class BoardDao {
	
	public List<BoardVo> listBoard(){
		return BoardManager.listBoard();
	}
	public List<BoardVo> viewBoard(){
		return BoardManager.viewBoard();
	}
	
	public BoardVo detailBoard(BoardVo v) {
		return BoardManager.detailBoard(v);
	}
	
	public int nextNo() {
		return BoardManager.nextNo();
	}
	
	public int insertBoard(BoardVo v) {
		return BoardManager.insertBoard(v);
	}
	
	public int updateBoard(BoardVo v) {
		return BoardManager.updateBoard(v);
	}
	
	public int deleteBoard(BoardVo v) {
		return BoardManager.deleteBoard(v);
	}
	
}
