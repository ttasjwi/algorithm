package boj_3052;

import java.util.Scanner;

	/* ===================================================
	 * BOJ(백준) 5단계 - 1차원 배열
	 * 
	 * <<boj_3052>>
	 *  숫자들의 나머지를 계산하고 서로 다른 값의 갯수 세기 (풀이 1 : 배열에 값을 추가하고, 이전 index까지의 값을 반복문으로 조회하여 중복되지 않을 경우 값을 증가)
	 *  https://www.acmicpc.net/problem/3052
	 * 
	 *  두 자연수 A와 B가 있을 때, A%B는 A를 B로 나눈 나머지 이다.
	 *  예를 들어, 7, 14, 27, 38을 3으로 나눈 나머지는 1, 2, 0, 2이다. 
	 *  
	 *  수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다.
	 *  그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.
	 * 
	 * 입력>
	 *  첫째 줄부터 열번째 줄 까지 숫자가 한 줄에 하나씩 주어진다. 이 숫자는 1,000보다 작거나 같고, 음이 아닌 정수이다.
	 * 
	 * 출력>
	 *  첫째 줄에, 42로 나누었을 때, 서로 다른 나머지가 몇 개 있는지 출력한다.
	 *  
	 * (예제 입력) 
	 *   1
	 *   2
	 *   3
	 *   4
	 *   5
	 *   6
	 *   7
	 *   8
	 *   9
	 *   10
	 *  
	 * (예제 출력)
	 *   10
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

public class Main1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		final int N = 10;
		final int DIVISOR = 42; // 나누는 수 (제수)

		int[] remainderArr = new int[N];
		int count = 0;
		
		for(int i=0; i<N; i++) {
			remainderArr[i] = scanner.nextInt()%DIVISOR; // 나머지 저장
			if (!hasRepitition(remainderArr, i)) count ++; // 중복이 아니면 count 증가
		}

		scanner.close();
		System.out.println(count);
	}

	private static boolean hasRepitition(int[] remainderArr, int i) {

		for (int j=0; j<i; j++) { //이전 index까지 중복이 있는지 조회 하여, 중복이면 true를 반환
			if (remainderArr[j] == remainderArr[i]) return true;
		}
		
		return false;		
	}
	
}