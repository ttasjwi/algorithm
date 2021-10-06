package boj_1110;

import java.util.*;

	/* ===================================================
	 * BOJ(백준) 4단계 - while문
	 * 
	 * <<boj_1110>>
	 * 원래 수로 돌아올 때까지 연산을 반복하고, 그 횟수를 반환하기 (do-while문)
	 * https://www.acmicpc.net/problem/1110
	 * 
	 *  0보다 크거나 같고, 99보다 작거나 같은 정수가 주어질 때 다음과 같은 연산을 할 수 있다. 먼저 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고, 각 자리의 숫자를 더한다. 그 다음, 주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면 새로운 수를 만들 수 있다. 다음 예를 보자.
	 *  26부터 시작한다. 2+6 = 8이다. 새로운 수는 68이다. 6+8 = 14이다. 새로운 수는 84이다. 8+4 = 12이다. 새로운 수는 42이다. 4+2 = 6이다. 새로운 수는 26이다.
	 *  위의 예는 4번만에 원래 수로 돌아올 수 있다. 따라서 26의 사이클의 길이는 4이다.
	 *  N이 주어졌을 때, N의 사이클의 길이를 구하는 프로그램을 작성하시오.
	 * 
	 * 입력>
	 *  첫째 줄에 N이 주어진다. N은 0보다 크거나 같고, 99보다 작거나 같은 정수이다.
	 * 
	 * 출력>
	 *  첫째 줄에 N의 사이클 길이를 출력한다.
	 * 
	 * (예제 입력 1) 26
	 * (예제 출력 1) 4
	 *  
	 * (예제 입력 2) 55
	 * (예제 출력 2) 3
	 * 
	 * (예제 입력 3) 1
	 * (예제 출력 3) 60  
	 * 
	 * (예제 입력 4) 0
	 * (예제 출력 4) 1  
	 * 
	 * ===================================================
	 * 
	 * [필요 지식]
	 * 
	 * 1. do-while문
	 * 
	 * ===================================================
	 * 
	 * 1. do-while문
	 * 
	 *  do {
	 *     // 조건의 결과가 참(true)일 때 수행될 문장 (처음 한 번은 무조건 실행)
	 *  } while(조건문);
	 *  
	 *  - while문과 달리, do문은 조건과 관계없이 일단 do문 안의 내용이 무조건 1회 실행됨
	 *  
	 * ===================================================
	 * 
	 */


public class Main {

	private static int getCycle(int input) {
		
		int[] original = numberSplit(input); // 입력받은 숫자를 십의자리, 일의 자리를 쪼개 배열에 저장
		int[] replacement = Arrays.copyOf(original, original.length); // 사이클이 증가할 때마다 변화할 배열을 생성 및 초기화
		int cycle = 0; // 사이클이 진행된 횟수
		
		do {
			int sum = (replacement[0] + replacement[1]); // 각 자리 숫자를 합친 값
			
			replacement[0] = replacement[1]; // 기존의 일의 자리 숫자를 십의 자리 숫자로 이동
			replacement[1] = numberSplit(sum)[1]; // 두 숫자를 합친 값의 일의 자리 숫자를 새로운 일의 자리로 변경
			
			cycle ++; // cycle 증가
			
		} while(!Arrays.equals(original, replacement)); // original과 replacement가 같아질 때까지 반복
			
		return cycle;
	}

	private static int[] numberSplit(int input) {
		int[] split = new int[2];
		
			split[0] = input/10; // 두자리 숫자를 10으로 나눈 몫 (십의 자리 숫자)
			split[1] = input%10; // 두자리 숫자를 10으로 나눈 나머지 (일의 자리 숫자)
			
		return split;
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt(); // 정숫값을 입력받는다.
		scanner.close();
		
		int cycle = getCycle(input); // 입력값으로 '더하기 사이클' 반환
		System.out.println(cycle);
		
	}

}
