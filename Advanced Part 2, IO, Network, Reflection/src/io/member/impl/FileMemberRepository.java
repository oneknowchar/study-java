package io.member.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.member.Member;
import io.member.MemberRepository;

public class FileMemberRepository implements MemberRepository{
	private static final String FILE_PATH = "temp/member-txt.dat";
	
	@Override
	public void add(Member member) {
		try (
				FileWriter fw = new FileWriter(FILE_PATH, StandardCharsets.UTF_8, true);
				BufferedWriter bw = new BufferedWriter(fw);
			){
			bw.write(member.toString());
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Member> findAll() {
		List<Member> members = new ArrayList<>();
		
		try (
				FileReader fr = new FileReader(FILE_PATH, StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(fr);	
			){
			String line = "";
			while((line = br.readLine()) != null) {
				String[] dataSet = line.replace("Member [", "").replace("]", "").split(", ");	//[id=1, name=1, age=1]
				
				Map<String, String> dataMap = new HashMap<>();
				
				for(String entry : dataSet) {
					String[] keyValue = entry.split("=");
					dataMap.put(keyValue[0], keyValue[1]);
				}
				
				members.add(new Member(dataMap.get("id"), dataMap.get("name"), Integer.valueOf(dataMap.get("age"))));
			}
		} catch (IOException e) {
			//파일이 없는 경우 신규 생성
			try (FileWriter fw = new FileWriter(FILE_PATH, StandardCharsets.UTF_8, false)){
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return members;
	}

	@Override
	public boolean removeMember(String id) {
		List<Member> members = findAll();
		boolean flag = false;
		File oldFile = new File(FILE_PATH);
		
		if(oldFile.delete()) {
			for(int i = 0; i < members.size(); i++) {
				Member thisMember = members.get(i);
				if(thisMember.getId().equals(id)) {
					//동일한 아이디의 회원을 찾은 경우 
					flag = true;
					continue;
				} else {
					//회원 새로 저장 
					add(thisMember);
				}
			}
		}else {
			//파일 삭제에 실패
			System.out.println("WARNING: 가입한 회원이 없습니다.");
			return flag;
		}
		
		if(!flag) {
			System.out.println("일치하는 회원 번호가 없습니다.");
		}else {
			System.out.println("회원 번호 " + id + "님을 탈퇴 처리하였습니다.");
		}
		
		return flag;
	}
}
