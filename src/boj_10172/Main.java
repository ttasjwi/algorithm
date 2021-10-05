package boj_10172;

	/* ===================================================
	 * BOJ(백준) 1단계 : 입출력과 사칙연산
	 * 
	 * <boj_10172 : Escape Sequence>
	 * 
	 * https://www.acmicpc.net/problem/10172
	 * 아래 예제와 같이 개를 출력하시오.
	 * 
	 *	|\_/|
	 *	|q p|   /}
	 *	( 0 )"""\
	 *	|"^"`    |
	 *	||_/=\\__|
	 *
	 * ===================================================
	 * 
	 * [Escape-Sequence]
	 *  백슬래시( \ ) 뒤에 한 문자나 숫자 조합이 오는 문자 조합을 "이스케이프 시퀀스"라고 합니다.
	 *  줄 바꿈 문자, 작은따옴표, 또는 문자 상수의 다른 특정 문자를 나타내려면 이스케이프 시퀀스를 사용해야 합니다.
	 *  (https://docs.microsoft.com/ko-kr/cpp/c-language/escape-sequences?view=msvc-160)
	 *   
	 * - \n : 개행(줄바꿈)
	 * - \\ : 백슬래시 '\'
	 * - \' : 홑따옴표
	 * - \" : 쌍따옴표
	 * - \t : 탭문자
	 * - 그 외
	 * 	
	 */	


public class Main {

	public static void main(String[] args) {
		System.out.println("|\\_/|"); // 역슬래시는 Escape-Sequence에 사용되므로 문자열 취급할 때는 두번 입력해야한다.
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\"); // 큰 따옴표 "는 문자열의 열고 닫음을 구분해주는 역할을 하므로, 문자 취급하려면 Escape-Sequence \"를 사용해야한다.
		System.out.println("|\"^\"`    |");
		System.out.println("||_/=\\\\__|");
	}

}
