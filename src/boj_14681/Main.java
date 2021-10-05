package boj_14681;

import java.util.Scanner;

	/* ===================================================
	 * BOJ(백준) 2단계 - if문
	 * 
	 * <<boj_14681>>
	 * 점의 x,y 좌표를 입력받아 점이 위치한 사분면 출력하기
	 * https://www.acmicpc.net/problem/14681
	 * 
	 * 흔한 수학 문제 중 하나는 주어진 점이 어느 사분면에 속하는지 알아내는 것이다. 사분면은 아래 그림처럼 1부터 4까지 번호를 갖는다. "Quadrant n"은 "제n사분면"이라는 뜻이다.
	 * 예를 들어, 좌표가 (12, 5)인 점 A는 x좌표와 y좌표가 모두 양수이므로 제1사분면에 속한다. 점 B는 x좌표가 음수이고 y좌표가 양수이므로 제2사분면에 속한다.
	 * 점의 좌표를 입력받아 그 점이 어느 사분면에 속하는지 알아내는 프로그램을 작성하시오. 단, x좌표와 y좌표는 모두 양수나 음수라고 가정한다.
	 *  
	 * (예제 입력 1)
	 * 12
	 * 5
	 * 
	 * (예제 출력 1)
	 * 1
	 * 
	 * (예제 입력 2)
	 * 9
	 * -13
	 * (예제 출력 2)
	 * 4
	 * 
	 * ===================================================
	 * 
	 * [필요 지식]
	 * 
	 * 1. if문
	 * 2. 조건식 연결
	 * 
	 * ===================================================
	 * 
	 * 1. if문
	 *  if (조건) {조건이 참일 때 수행할 내용}
	 *  else if (그 외의 조건) {조건이 참일 때 수행할 내용}
	 *  else {그 외의 모든 경우에 대하여 수행할 내용}
	 *  
	 *  - 조건에 boolean 타입의 변수를 입력해도 됨.
	 *  
	 * 2. 조건식 연결
	 *  && : and (교집합)
	 *  || : or (합집합)
	 *   
	 */


public class Main {

	static void printQuadrant(int x, int y) {
		
		String quadrant = ""; // 사분면
		
		if (x>0 && y>0) quadrant = "1"; // 제 1 사분면
		else if (x<0 && y>0) quadrant = "2"; // 제 2 사분면
		else if (x<0 && y<0) quadrant = "3"; // 제 3 사분면
		else if (x>0 && y<0) quadrant = "4"; // 제 4 사분면
		
		System.out.println(quadrant); // 사분면 출력
		return;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		
		scanner.close();
		
		printQuadrant(x,y);

	}

}