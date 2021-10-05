package boj_2439;

import java.util.Scanner;

	/* ===================================================
	 * BOJ(백준) 3단계 - for문
	 * 
	 * <<boj_2439>>
	 * 오른쪽에서 시작하는 별 찍기(풀이 1 : 이중 for문)
	 * https://www.acmicpc.net/problem/2439
	 * 
	 * 첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
	 * 하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
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
	 *     *
	 *    **
	 *   ***
	 *  ****
	 * *****
	 * 
	 * ===================================================
	 * 
	 * [필요 지식]
	 * 
	 * 1. for문
	 * 2. for문 + if문
	 * 3. continue, break
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
	 * 2. for문 + 조건문
	 *  for문 안에 if문을  삽입할 수 있다.
	 *  조건에 따라 명령을 수행할 수 있게 할 수 있다.
	 *  
	 * ===================================================
	 *  
	 * 3. continue, break
	 * 
	 *  for문에서 continue : 현재 증감변수에서의 명령을 끝마치고 증감식에 따라 값을 증가, 다음 단계로 이동
	 *  for문에서 break : for문을 벗어남
	 *  
	 * ===================================================
	 */


class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		for (int i=1; i<=n; i++) {//1부터 n까지
			printReverseCharBar(i, n, '*');
		}
		
		scanner.close();
	}

	private static void printReverseCharBar(int length, int maxlength, char ch) {
		int startIndex = (maxlength-1) - (length-1); // bar가 시작될 index
		
		for(int i=0; i<maxlength; i++) {
			if(i<startIndex) {
				System.out.print(' ');  // 시작 index 전까지 공백출력
				continue;
			}
			System.out.print(ch); //시작 index부터는 지정문자 출력
		}
		System.out.println(); // 줄바꿈
		return;
	}
}
