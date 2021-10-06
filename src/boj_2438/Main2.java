package boj_2438;

import java.util.*;

	/* ===================================================
	 * BOJ(백준) 3단계 - for문
	 * 
	 * <<boj_2438>>
	 * 밑으로 갈 수록 길어지는 별 찍기(풀이 2 : for문 + Arrays.fill 활용)
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
	 * 2. Arrays.fill(arr, element)
	 *  - 배열 arr의 각 요소를 element로 채운다.
	 *  
	 * ===================================================
	 */


class Main2 {

	static void printCharBar(int length, char ch) { // 지정 길이만큼 ch 출력
		char[] arr = new char[length];
		Arrays.fill(arr, ch); // 배열의 모든 요소를 지정 문자로 가득 채움
		String charBar = new String(arr); // arr로 문자열 생성

		System.out.println(charBar); // 문자열 출력
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();

		for (int i=1; i<=n; i++) {
			printCharBar(i, '*');
		}
	}
}