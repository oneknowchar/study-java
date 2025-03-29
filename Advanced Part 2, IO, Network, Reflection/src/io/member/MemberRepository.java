package io.member;

import java.util.List;

public interface MemberRepository {
	void add(Member member);
	
	List<Member> findAll();
	
	boolean removeMember(String id);
}
 