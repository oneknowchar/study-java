package io.member.impl;

import java.util.ArrayList;
import java.util.List;

import io.member.Member;
import io.member.MemberRepository;

public class MemoryMemberRepository implements MemberRepository {

	private final List<Member> members = new ArrayList<>();

	@Override
	public void add(Member member) {
		members.add(member);

	}

	@Override
	public List<Member> findAll() {
		return members;
	}

	@Override
	public boolean removeMember(String id) {
		boolean flag = false;
		
		for(int i = 0; i < members.size(); i++) {
			Member findMember = members.get(i);
			
			if(findMember.getId().equals(id)) {
				members.remove(i);
				flag = true;
				break;
			}
		}
		
		return flag;
	}

}
 