package boj_9498;

import java.util.Scanner;
import java.text.ChoiceFormat;

	/* ===================================================
	 * BOJ(백준) 2단계 - if문
	 * 
	 * <<boj_9498>>
	 * 시험점수 입력받아 조건에 맞게 등급 출력 (풀이 2 : ChoiceFormat 활용)
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
	 * 1. ChoiceFormat
	 * 
	 * ===================================================
	 * 
	 * 1. ChoiceFormat
	 * 특정 범위에 속하는 값을 원하는 문자열로 변환
	 * 
	 *  1) 생성자
	 *   - ChoiceFormat(double[] limits, String[] formats)
	 *       limits : 범위 지정. 오름차순으로 정렬되어있어야함. 각 limits은 범위의 경계값.
	 *       Formats : 범위에 따라 반환될 문자열 포맷
	 *  
	 *   - ChoiceFormat(String newPattern)
	 *       newPattern : 범위를 문자열로 지정함.  |를 통해 구분
	 *       # : 이상
	 *       < : 초과
	 *       예 ) 60<D|70<C|80<B|90<A
	 * 
	 *  2) 형식화
	 *    ChoiceFormat 객체.format(long number)
	 *    입력된 long 값들을 객체의 limits, formats에 따라 String으로 반환
	 *   
	 */

public class Main2 {

	static void printGrade(int score) {
		String pattern = "0#F|60#D|70#C|80#B|90#A"; // 포맷화할 패턴. (범위 지정 및 형식화 패턴)
		ChoiceFormat form = new ChoiceFormat(pattern); // 포맷 객체 생성
		String grade = form.format(score); // 포맷에 맞게 문자열 반환
		System.out.println(grade); // 출력
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt(); // 점수를 입력받아 score에 저장
		scanner.close();
		
		printGrade(score); // score를 등급으로 출력
	}

}