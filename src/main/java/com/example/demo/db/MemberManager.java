package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;import org.apache.ibatis.javassist.bytecode.annotation.MemberValue;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.MemberVo;

public class MemberManager {
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
	
	public static List<MemberVo> listMember() {
		SqlSession session = factory.openSession();
		List<MemberVo> list = session.selectList("member.listMember");
		session.close();
		return list;
	}
	
	public static int insertMember(MemberVo v) {
		SqlSession session = factory.openSession();
		int re = session.insert("member.insertMember", v);
		session.commit();
		session.close();
		return re;
	}
	
	public static int updateMember(MemberVo v) {
		SqlSession session = factory.openSession();
		int re = session.update("member.updateMember", v);
		session.commit();
		session.close();
		return re;
	}
	
	public static int deleteMember(MemberVo v) {
		SqlSession session = factory.openSession();
		int re = session.delete("member.deleteMember", v);
		session.commit();
		session.close();
		return re;
	}
}






















