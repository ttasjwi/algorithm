package boj_10951;

import java.util.Scanner;

	/* ===================================================
	 * BOJ(백준) 4단계 - while문
	 * 
	 * <<boj_10951>>
	 * 두 입력값의 합을 계속 출력하기 (무한 while문, EOF 처리)
	 * https://www.acmicpc.net/problem/10951
	 * 
	 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
	 * 
	 * 입력>
	 *  입력은 여러 개의 테스트 케이스로 이루어져 있다.
	 *  각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
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
	 * 2. EOF(End of File)
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
	 * 2. EOF (End of File)
	 *  파일의 끝
	 *  무한 반복문에서 탈출 조건이 없을 경우 EOF가 존재할 수 없게 됨.
	 *  적어도 특정 상황에서 종료가 발생하도록 해야한다.
	 * 
	 * ===================================================
	 */

class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNextInt()) {
			// true를 작성하면 EOF가 없어짐.
			// 읽어올 int가 없는 상황에 종료되도록 하여 적어도 특정 조건에서 프로그램이 종료되도록 EOF처리
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			System.out.println(a+b);
		}
		
		scanner.close();
	}

}
