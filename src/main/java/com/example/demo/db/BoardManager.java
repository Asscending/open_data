package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;import org.apache.ibatis.javassist.bytecode.annotation.MemberValue;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.BoardVo;
import com.example.demo.vo.MemberVo;

public class BoardManager {
	public static SqlSessionFactory factory;
	
	static {
		try {
			Reader reader = 
					Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static List<BoardVo> listBoard() {
		SqlSession session = factory.openSession();
		List<BoardVo> list = session.selectList("board.listBoard");
		session.close();
		return list;
	}
	
	public static BoardVo detailBoard(BoardVo b) {
		SqlSession session = factory.openSession();
		BoardVo v = session.selectOne("board.detailBoard", b);
		session.close();
		return v;
	}
	
	public static List<BoardVo> viewBoard(){
		SqlSession session = factory.openSession();
		List<BoardVo> list = session.selectList("board.viewBoard");
		session.close();
		return list;
	}
	
	
	public static int nextNo() {
		SqlSession session = factory.openSession();
		int no = session.selectOne("board.nextNo");
		session.close();
		return no;
	}
	
	public static int insertBoard(BoardVo v) {
		SqlSession session = factory.openSession();
		int re = session.insert("board.insertBoard", v);
		session.commit();
		session.close();
		return re;
	}
	

	
	public static int updateBoard(BoardVo v) {
		SqlSession session = factory.openSession();
		int re = session.update("board.boardMember", v);
		session.commit();
		session.close();
		return re;
	}
	
	public static int deleteBoard(BoardVo v) {
		SqlSession session = factory.openSession();
		int re = session.delete("board.boardManager", v);
		session.commit();
		session.close();
		return re;
	}
}






















