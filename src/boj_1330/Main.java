package boj_1330;

import java.util.*;

	/* ===================================================
	 * BOJ(백준) 2단계 - if문
	 * 
	 * <<boj_1330>>
	 * 정수 두 개를 입력받고 입력값의 대소를 비교하여 비교 결과에 따라 부등호 출력
	 * https://www.acmicpc.net/problem/1330
	 * 
	 * 두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.
	 * 
	 * 입력> 첫째 줄에 A와 B가 주어진다. A와 B는 공백 한 칸으로 구분되어져 있다.
	 * 출력> 첫째 줄에 다음 세 가지 중 하나를 출력한다.
	 *  - A가 B보다 큰 경우에는 '>'를 출력한다.
	 *  - A가 B보다 작은 경우에는 '<'를 출력한다.
	 *  - A와 B가 같은 경우에는 '=='를 출력한다.
	 *       
	 * 제한>
	 *  -10,000 ≤ A, B ≤ 10,000
	 *  
	 * (예제 입력1) 1 2
	 * (예제 출력1) <

	 * (예제 입력2) 10 2
	 * (예제 출력2) >
	 * 
	 * (예제 입력3) 5 5
	 * (예제 출력3) ==
	 * 
	 * 
	 * ===================================================
	 * 
	 * [필요 지식]
	 * 
	 * 1.if문
	 * 
	 * ===================================================
	 * 
	 * 1. if문
	 *  if (조건) {조건이 참일 때 수행할 내용}
	 *  else if (그 외의 조건) {조건이 참일 때 수행할 내용}
	 *  else {그 외의 모든 경우에 대하여 수행할 내용}
	 *  
	 *  - 조건에 boolean 타입의 변수를 입력해도 됨.
	 *  
	 * ===================================================
	 * 
	 * 2. String의 split 메서드 : 문자열을 구분자로 분리 후 배열 저장
	 *  String 클래스의 인스턴스 메서드 split(String regex)는 해당 인스턴스에 저장된 문자열을 지정된 분리자(regex)로 문자열을 나누어 배열에 담아 반환한다.
	 *  
	 *  (cf) String 클래스의 static 메서드 join(String regex, CharSequence elements, ...)는 지정된 구분자로 원하는 Charsequence 요소들을 결합해서 출력한다. (문자열 배열만 입력시 해당 요소들 전체)
	 * 
	 * ===================================================
	 *   
	 */

public class Main {
	
	static void printResult(int a, int b) {
		
		String result = ""; // 디폴트
		
		if (a<b)      result = "<"; // 조건에 따라 result에 새로운 문자열 저장
		else if (a>b) result = ">";
		else          result = "==";

		System.out.println(result); // result 출력
		return;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		scanner.close();
		
		printResult(a,b); // 비교 결과를 부등호로 출력
	}

}
