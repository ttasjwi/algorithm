package boj_10871;

import java.util.*;

	/* ===================================================
	 * BOJ(백준) 3단계 - for문
	 * 
	 * <<boj_10871>>
	 * 값을 입력받아서 특정한 값보다 작은 수만 출력하기(풀이 2 : 배열, 향상된 for문 활용 )
	 * https://www.acmicpc.net/problem/10871
	 * 
	 * 정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.
	 * 
	 * 입력>
	 * 첫째 줄에 N과 X가 주어진다. (1 ≤ N, X ≤ 10,000)
	 * 둘째 줄에 수열 A를 이루는 정수 N개가 주어진다. 주어지는 정수는 모두 1보다 크거나 같고, 10,000보다 작거나 같은 정수이다.
	 * 
	 * 출력>
	 * X보다 작은 수를 입력받은 순서대로 공백으로 구분해 출력한다. X보다 작은 수는 적어도 하나 존재한다.
	 * 
	 * (예제 입력)
	 *	10 5
	 *  1 10 4 9 2 3 8 5 7 6
	 *  
	 * (예제 출력)
	 *  1 4 2 3
	 * 
	 * ===================================================
	 * 
	 * [필요 지식]
	 * 
	 * 1. for문
	 * 2. 배열
	 * 3. 향상된 for문 (JDK 1.5~)
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
	 * 2. 배열
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
	 * 3. 향상된 for문
	 *  for ( 타입변수명 : 배열 또는 컬렉션) { //반복할 문장 }
	 *   : 배열의 첫번째 인덱스부터 순서대로 각 요소에 접근함. 대신 수정은 불가능
	 *   
	 * =================================================== 
	 */

public class Main2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt(); // 입력받을 숫자의 갯수
		int x = scanner.nextInt(); // x 미만의 숫자만 출력
		
		int[] numArr = new int[n];
		
		inputNumberToArray(scanner, numArr);
		scanner.close();
		
		printUnderX(x, numArr);
		
	}

	private static void printUnderX(int x, int[] numArr) {
		for (int number : numArr) { // numArr의 각 요소에 순서대로 접근하여 그 값을 number에 대입
			if (number < x) {
				System.out.print(number+" ");
			}
		}
	}

	private static void inputNumberToArray(Scanner scanner, int[] numArr) {
		for (int i=0; i<numArr.length; i++) {
			numArr[i] = scanner.nextInt();
		}
	}
}
