package com.tstory.joalog.member.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("MemberDAO")
public class MemberDAOImpl implements MemberDAO{
	
	@Inject
	private SqlSessionTemplate sqlSession;	

	@Override
	public boolean insert(Member member) {
		try {
			sqlSession.insert("member.insert", member);
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Member get(String id) throws Exception {
		Member member = sqlSession.selectOne("member.getMemeberInfo", id);
		if (member == null){
			throw new Exception("ERROR_NOT_EXIST_MEMBER");
		}
		return member;
	}
	@Override
	public Member update(Member member) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void delete(String id) {
		sqlSession.delete("member.delete", id);
	}
	@Override
	public Member list(int page, int ListNum) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updatePW(Member member) {
		sqlSession.update("member.updatePW", member);
	}
	
	public void isManager(String id) throws Exception {
		String manager=null;
		try {
			manager = sqlSession.selectOne("member.isManager", id);
		} catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		if (manager == null) {
			throw new Exception("ERROR_NOT_MANAGER");
		}
	}

	@Override
	public Member nickNameDupleCheck(String nickName) throws Exception {
		Member mem = sqlSession.selectOne("member.findNick", nickName);
		if (mem == null) {
			throw new Exception("ERROR_NOT_EXIST_NICKNAME");
		}
		return mem;
	}	

	
}
