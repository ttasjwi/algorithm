package boj_9498;

import java.util.Scanner;

	/* ===================================================
	 * BOJ(백준) 2단계 - if문
	 * 
	 * <<boj_9498>>
	 * 시험점수 입력받아 조건에 맞게 등급 출력 (풀이 1 : if문)
	 * https://www.acmicpc.net/problem/9498
	 * 
	 * 시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.
	 * 
	 * 입력> 첫째 줄에 시험 점수가 주어진다. 시험 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
	 * 출력> 시험 성적을 출력한다.
	 *  
	 * (예제 입력) 100
	 * (예제 출력) A
	 * 
	 * ===================================================
	 * 
	 * [필요 지식]
	 * 
	 * 1.if문
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
	 */

public class Main1 {

	static void printGrade(int score) {
		String grade = "F"; // 디폴트
		
		if      (60<=score&&score<70)   grade = "D";
		else if (70<=score&&score<80)   grade = "C";
		else if (80<=score&&score<90)   grade = "B";
		else if (90<=score&&score<=100) grade = "A";
		
		System.out.println(grade);
		return;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt(); // 점수를 입력받아 score에 저장
		scanner.close();
		
		printGrade(score); // score를 등급으로 출력
	}

}