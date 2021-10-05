package boj_2588;

import java.util.Scanner;

	/* ===================================================
	 * BOJ(백준) 1단계 : 입출력과 사칙연산
	 * 
	 * <<boj_2588>>
	 * 정숫값을 입력받아 세자리 수의 세로 곱셈의 과정을 라인별로 출력
	 * https://www.acmicpc.net/problem/2588
	 * 
	 * (세 자리 수) × (세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.
	 *    472 --- (1)
	 *  * 385 --- (2)
	 *  --------------
	 *   2360 --- (3)
	 *  3776  --- (4)
	 * 1416   --- (5)
	 * ---------------
	 * 181720 --- (6)
	 * 
	 * (1)과 (2)위치에 들어갈 세 자리 자연수가 주어질 때 (3), (4), (5), (6)위치에 들어갈 값을 구하는 프로그램을 작성하시오.  
	 * 세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.
	 * 
	 * 입력 : 첫째 줄에 (1)의 위치에 들어갈 세 자리 자연수가, 둘째 줄에 (2)의 위치에 들어갈 세자리 자연수가 주어진다.
	 * 출력 : 첫째 줄부터 넷째 줄까지 차례대로 (3), (4), (5), (6)에 들어갈 값을 출력한다.
	 *       
	 * (예제 입력)
	 *  472
	 *  385
	 *  
	 * (예제 출력)
	 *	2360
	 *	3776
	 *	1416
	 *	181720
	 * 
	 * ===================================================
	 * 
	 * [필요 지식]
	 * 
	 * 1. Integer.parseInt() : 숫자 문자열을 int 타입으로 반환
	 * 2. String의 split 메서드 : 문자열을 구분자로 분리 후 배열 저장
	 * 
	 * ===================================================
	 * 
	 * 1. Integer.parseInt(String str)
	 *  숫자로 된 문자열을 입력받았을 때 이를 int 타입으로 반환함
	 * 
	 * (cf)
	 *  Integer.valueOf(String str) : 숫자로 된 문자열을 입력받았을 때 이를 Integer 객체로 반환
	 *  
	 * ===================================================
	 * 
	 * 2. String의 split 메서드 : 문자열을 구분자로 분리 후 배열 저장
	 *  String 클래스의 인스턴스 메서드 split(String regex)는 해당 인스턴스에 저장된 문자열을 지정된 분리자(regex)로 문자열을 나누어 배열에 담아 반환한다.
	 *  
	 *  (cf) String 클래스의 static 메서드 join(String regex, CharSequence elements, ...)는 지정된 구분자로 원하는 Charsequence 요소들을 결합해서 출력한다. (문자열 배열만 입력시 해당 요소들 전체)
	 * 
	 * ===================================================
	 *   
	 */


public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str_a = scanner.nextLine(); // 입력값을 라인단위로 문자로 받음
		String str_b = scanner.nextLine();
		scanner.close();
		
		int a = Integer.parseInt(str_a);
		int b = Integer.parseInt(str_b);
		
		String[] split_b = str_b.split(""); //str_b를 구분자 없이 끊어서 배열에 저장
		
		int b100 = Integer.parseInt(split_b[0]); // b의 백의자리 숫자
		int b10 = Integer.parseInt(split_b[1]); // b의 십의자리 숫자
		int b1 = Integer.parseInt(split_b[2]); // b의 일의자리 숫자
		
		int result1 = a * b1; // a, b의 일의 자리 숫자의 곱
		int result2 = a * b10; // a, b의  십의 자리 숫자의 곱
		int result3 = a * b100; // a, b의 백의 자리 숫자의 곱
		int result = a * b;
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result);
	}

}
