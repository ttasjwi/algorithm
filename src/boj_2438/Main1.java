package boj_2438;

import java.util.*;

	/* ===================================================
	 * BOJ(백준) 3단계 - for문
	 * 
	 * <<boj_2438>>
	 * 밑으로 갈 수록 길어지는 별 찍기(풀이 1 : 이중 for문)
	 * https://www.acmicpc.net/problem/2438
	 * 
	 * 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
	 * 
	 * 입력>
	 * 첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
	 * 
	 * 출력>
	 * 첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
	 * 
	 * (예제 입력)
	 *	5
	 *
	 * (예제 출력)
	 *  *
	 *  **
	 *  ***
	 *  ****
	 *  *****
	 * 
	 * ===================================================
	 * 
	 * [필요 지식]
	 * 
	 * 1.for문
	 * 2.이중 for문
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
	 * 
	 * 2. 이중 for문
	 *  for문 안에 또 다시 for문을  삽입할 수 있다.
	 *  for문에 종속된 for문이므로, 바깥의 변수명을 사용할 수 없다.
	 *  
	 * ===================================================
	 */


class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		for (int i=1; i<=n; i++) {//1부터 n까지
			printCharBar(i, '*');
		}
		
		scanner.close();
	}

	private static void printCharBar(int length, char ch) {
		for (int i=1; i<=length; i++) {
			System.out.print(ch); // '*'을 값만큼 출력
			if(i==length) System.out.println();
		}
		return;
	}
}