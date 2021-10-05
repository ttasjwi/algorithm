package boj_2753;

import java.util.Scanner;

	/* ===================================================
	 * BOJ(백준) 2단계 - if문
	 * 
	 * <<boj_2753>>
	 * 연도를 입력받아 윤년, 평년 여부 반환
	 * https://www.acmicpc.net/problem/2753
	 * 
	 * 연도가 주어졌을 때, 윤년이면 1, 아니면 0을 출력하는 프로그램을 작성하시오.
	 * 윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때이다.
	 * 예를 들어, 2012년은 4의 배수이면서 100의 배수가 아니라서 윤년이다. 1900년은 100의 배수이고 400의 배수는 아니기 때문에 윤년이 아니다. 하지만, 2000년은 400의 배수이기 때문에 윤년이다.
	 * 
	 * 입력> 첫째 줄에 연도가 주어진다. 연도는 1보다 크거나 같고, 4000보다 작거나 같은 자연수이다.
	 * 출력> 첫째 줄에 윤년이면 1, 아니면 0을 출력한다.
	 *  
	 * (예제 입력 1) 2000
	 * (예제 출력 1) 1
	 * 
	 * (예제 입력 2) 1999
	 * (예제 출력 2) 0
	 * 
	 * ===================================================
	 * 
	 * [필요 지식]
	 * 
	 * 1. if문
	 * 2. 조건식 연결
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
	 * 2. 조건식 연결
	 *  && : and (교집합)
	 *  || : or (합집합)
	 *   
	 */


public class Main {

	static boolean isLeapYear(int year) {
		return year%4==0&&year%100!=0||year%400==0;
		// 4의 배수이고 100의 배수아니거나 400의 배수
	}
	
	static void printLeapYear (int year) {
		int result = -1;
		
		if (isLeapYear(year)) {
			result = 1; // 윤년이면 1
		} else {
			result = 0; // 평년이면 0 반환
		}
		
		System.out.println(result);
		return;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int year = scanner.nextInt();
		scanner.close();
		
		printLeapYear(year);
	}

}
