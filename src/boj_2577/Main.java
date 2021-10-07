package boj_2577;

import java.util.Scanner;

	/* ===================================================
	 * BOJ(백준) 5단계 - 1차원 배열
	 * 
	 * <<boj_2577>>
	 *  각 숫자가 몇 번 나왔는지 저장하기 위해 일차원 배열을 만드는 문제 (1차원 배열)
	 *  https://www.acmicpc.net/problem/2577
	 * 
	 *  세 개의 자연수 A, B, C가 주어질 때
	 *  A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
	 * 
	 *  예를 들어 A = 150, B = 266, C = 427 이라면 A × B × C = 150 × 266 × 427 = 17037300 이 되고,
	 *  계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.
	 * 
	 * 입력>
	 *  첫째 줄에 A, 둘째 줄에 B, 셋째 줄에 C가 주어진다. A, B, C는 모두 100보다 크거나 같고, 1,000보다 작은 자연수이다.
	 * 
	 * 출력>
	 *  첫째 줄에는 A × B × C의 결과에 0 이 몇 번 쓰였는지 출력한다.
	 *  마찬가지로 둘째 줄부터 열 번째 줄까지 A × B × C의 결과에 1부터 9까지의 숫자가 각각 몇 번 쓰였는지 차례로 한 줄에 하나씩 출력한다.
	 *  
	 * (예제 입력) 
	 *  150
	 *  266
	 *  427
	 *  
	 * (예제 출력)
	 *  3
	 *  1
	 *  0
	 *  2
	 *  0
	 *  0
	 *  0
	 *  2
	 *  0
	 *  0
	 * 
	 * ===================================================
	 * 
	 * [필요 지식]
	 * 
	 * 1. 배열
	 * 
	 * ===================================================
	 * 
	 * 1. 배열
	 *  같은 타입의 여러 변수를 하나의 묶으로 다루는 것
	 *  
	 *   1) 생성
	 *    타입[] 변수이름;
	 *    변수이름 = new 타입[길이];
	 *   
	 *   2) 배열의 각 요소
	 *    배열이름[0], 배열이름[1], 배열이름[2], ... , 배열이름[길이-1] : 배열의 각 요소
	 *    
	 *   3) 배열의 초기화
	 *    배열이름[index] = 값;
	 *  
	 * ===================================================
	 * 
	 */

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		scanner.close();

		String[] numberSplit = String.valueOf(a*b*c).split(""); // 곱을 문자열로 변환후 ""로 분리하여 배열에 저장 
		
		int[] counter = new int[10]; // 결과값의 각 숫자의 등장 횟수를 저장하는 배열
		
		for (String number : numberSplit) {
			int j = Integer.parseInt(number); // numberSplit에 저장된 숫자 문자열을 파싱
			counter[j]++; // 파싱한 결과에 해당하는 counter의 index에 저장된 값을 1 증가
		}
		
		for (int count : counter) {
			System.out.println(count);
		}
	}
}