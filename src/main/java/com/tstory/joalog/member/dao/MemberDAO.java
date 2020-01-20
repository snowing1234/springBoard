package com.tstory.joalog.member.dao;

public interface MemberDAO {
	
	public boolean insert(Member member);
	public Member get(String id) throws Exception;
	public Member update(Member member);
	public void delete(String id);
	public Member list(int page, int listNum);
	public void updatePW(Member member);
	
	public Member nickNameDupleCheck(String nickName) throws Exception;
}
