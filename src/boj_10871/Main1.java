package boj_10871;

import java.util.Scanner;

	/* ===================================================
	 * BOJ(백준) 3단계 - for문
	 * 
	 * <<boj_10871>>
	 * 값을 입력받아서 특정한 값보다 작은 수만 출력하기(풀이 1 : for문, StringBuffer 활용 )
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
	 * 2. StringBuffer
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
	 * 2. StringBuffer
	 *  StringBuffer 클래스는 문자열 편집을 위한 Buffer를 가지고 있다.
	 *   
	 *   1) 생성
	 *    StringBuffer() : 버퍼의 크기를 16으로 초기화하여 생성
	 *    StringBuffer(int length) : 버퍼의 크기를 length로 초기화하여 생성한다.
	 *    StringBuffer(String s)는 버퍼의 크기를 s.length+16으로 초기화하여 생성한다.
	 *   
	 *   2) 문자열 추가
	 *    append(String s) : 해당하는 문자열을 뒤에 추가해주고, 그 결과를 반환한다.
	 *    append(인스턴스) : 입력한 인스턴스의 toString()메서드를 호출하여 문자열의 뒤에 덧붙임
	 *    
	 *    
	 * ===================================================
	 */


public class Main1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt(); // 입력받을 숫자의 갯수
		int x = scanner.nextInt(); // x 미만의 숫자만 출력
		
		StringBuffer buff = new StringBuffer(); // 조건에 맞는 값을 문자열로 저장할 버퍼
		
		for (int i=0; i<n; i++) {
			int input = scanner.nextInt();
			if (input < x) {
				buff.append(String.valueOf(input)).append(" ");
			}
		}
		
		scanner.close();
		System.out.println(buff); //buff.toString()을 호출
		
		}
		
}
