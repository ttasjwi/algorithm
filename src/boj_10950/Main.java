package boj_10950;

import java.util.Scanner;

	/* ===================================================
	 * BOJ(백준) 3단계 - for문
	 * 
	 * <<boj_10950>>
	 * 입력한 횟수만큼 두 수의 합 계산하기 (for문)
	 * https://www.acmicpc.net/problem/10950
	 * 
	 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
	 * 
	 * (예제 입력)
	 *	5
	 *	1 1
	 *	2 3
	 *	3 4
	 *	9 8
	 *	5 2
	 *
	 * (예제 출력)
	 *    2
	 *    5
	 *    7
	 *    17
	 *    7
	 * 
	 * ===================================================
	 * 
	 * [필요 지식]
	 * 
	 * 1.for문
	 * 
	 * ===================================================
	 * 
	 * 1. for문
	 *  for(초기화; 조건식; 증감식) { 조건이 참일 때 수행될 문장 }
	 *   - 초기화 : 반복문에 사용될 변수를 초기화. 처음에 한 번만 수행
	 *   - 조건식 : 조건식이 참이면 반복을 계속, 거짓이면 반복을 중단하고 for문을 벗어남
	 *   - 증감식 : 반복문을 제어하는 변수의 값을 증가 또는 감소
	 *  
	 * ===================================================
	 */

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt(); // 반복 횟수 입력
		
		for (int i=1; i<=t; i++) { // 반복 횟수만큼 입력을 받고, 결과를 출력
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			System.out.println(a+b);
		}
		
		scanner.close();
	}

}
