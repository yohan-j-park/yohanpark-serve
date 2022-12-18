package kr.jobtc.springboot.member;

public class GuestMember implements Member {

	public GuestMember() {
		System.out.println("가입하지 않은 회원관리입니다.");
	}
	
	@Override
	public void crud() {
		System.out.println("가입하지 않은 회원 CRUD 기능입니다.");
	}
	
}
