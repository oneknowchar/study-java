package io.member;

import java.util.List;
import java.util.Scanner;

import io.member.impl.FileMemberRepository;
import io.member.impl.MemoryMemberRepository;

public class MemberConsoleMain {
	private static final MemberRepository respository = new FileMemberRepository();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("1.회원등록  2.회원조회  3.회원탈퇴  4.종료");
			System.out.print("선택 : ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // new Line 제거

			switch (choice) {
			case 1: {
				registermember(scanner);
				break;
			}
			case 2: {
				displayMembers();
				break;
			}
			case 3: {
				removeMember(scanner);
				break;
			}
			case 4: {
				System.out.println("종료.....");
				return;
			}
			default: {
				System.out.println("다시 입력해주세요");
			}
			}
		}
	}

	private static void registermember(Scanner scanner) {
		System.out.print("ID : ");
		String id = scanner.nextLine();
		System.out.print("Name : ");
		String name = scanner.nextLine();
		System.out.print("age : ");
		int age = scanner.nextInt();
		scanner.nextLine();

		Member member = new Member(id, name, age);

		respository.add(member);
	}

	private static void displayMembers() {
		List<Member> members = respository.findAll();
		
		if(members.size() == 0 ) {
			System.out.println("회원을 등록해 주세요!");
		}else {
			members.stream().forEach(
					member -> System.out.println(member)
			);
		}
	}
	
	private static void removeMember(Scanner scanner) {
		System.out.print("삭제할 ID : ");
		String id = scanner.nextLine();
		respository.removeMember(id);
	}
}
