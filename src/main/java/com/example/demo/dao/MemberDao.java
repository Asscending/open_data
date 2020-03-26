package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.MemberManager;
import com.example.demo.vo.MemberVo;

@Repository
public class MemberDao {
	
	public List<MemberVo> listMember(){
		return MemberManager.listMember();
	}
	public int insertMember(MemberVo v) {
		return MemberManager.insertMember(v);
	}
	public int updateMember(MemberVo v) {
		return MemberManager.updateMember(v);
	}
	public int deleteMember(MemberVo v) {
		return MemberManager.deleteMember(v);
	}
}
