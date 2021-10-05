package boj_8393;

import java.util.Scanner;

	/* ===================================================
	 * BOJ(백준) 3단계 - for문
	 * 
	 * <<boj_8393>>
	 * 입력한 횟수만큼 두 수의 합 계산하기 (풀이 1 : for문)
	 * https://www.acmicpc.net/problem/8393
	 * 
	 * n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
	 *
	 * 입력>
	 *  첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.
	 * 
	 * 출력>
	 *  1부터 n까지 합을 출력한다.
	 * 
	 * (예제 입력) 3
	 * (예제 출력) 6
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

public class Main1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		
		printSum(n);
	}

	private static void printSum(int n) {
		int sum = 0; // 1부터 n까지의 정수의 합을 저장할 변수
		
		for (int i=1; i<=n; i++) {
			sum += i; // 1부터 n까지 sum에 그 값을 더 함
		}
		
		System.out.println(sum);
		return;
	}

}
