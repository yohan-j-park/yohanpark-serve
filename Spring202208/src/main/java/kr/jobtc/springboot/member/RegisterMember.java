package kr.jobtc.springboot.member;

public class RegisterMember implements Member{
	
	
	public RegisterMember() {
		System.out.println("가입 된 회원 관리입니다.");
	}

	@Override
	public void crud() {
		System.out.println("가입 된 회원 CRUD 기능입니다.");
	}
	 
}
