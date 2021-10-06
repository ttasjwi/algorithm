package boj_10952;

import java.util.Scanner;

	/* ===================================================
	 * BOJ(백준) 4단계 - while문
	 * 
	 * <<boj_10952>>
	 * 특정 명령이 입력되기 전까지 두 입력값의 합을 계속 출력하기 (while문)
	 * https://www.acmicpc.net/problem/10952
	 * 
	 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
	 * 
	 * 입력>
	 *  입력은 여러 개의 테스트 케이스로 이루어져 있다.
	 *  각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
	 *  입력의 마지막에는 0 두 개가 들어온다.
	 * 
	 * 출력>
	 *  각 테스트 케이스마다 A+B를 출력한다.
	 * 
	 * (예제 입력)
	 *  1 1
	 *  2 3
	 *  3 4
	 *  9 8
	 *  5 2
	 *  0 0
	 *
	 * (예제 출력)
	 *  2
	 *  5
	 *  7
	 *  17
	 *  7
	 * 
	 * ===================================================
	 * 
	 * [필요 지식]
	 * 
	 * 1. while문
	 * 
	 * ===================================================
	 * 
	 * 1. while문
	 *  - while(조건식) { // 조건의 결과가 참(true)인 동안, 반복될 문장 }
	 *  
	 *  - while문의 break : while문을 탈출한다.
	 *  - while문의 continue : 조건식으로 이동
	 *  
	 * ===================================================
	 * 
	 */


public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) { // 무한 반복문
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			if (a==0&&b==0) break; // a,b가 0일 때 while문 탈출
			
			System.out.println(a+b); // a+b 출력
		}
		scanner.close();
	}

}
