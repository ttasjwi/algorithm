package boj_11654;

import java.util.Scanner;

	/* ===================================================
	 * BOJ(백준) 7단계 - 문자열
	 * 
	 * <<boj_11654>>
	 *  입력받은 문자를 AsciiCode로 반환받기
	 *  https://www.acmicpc.net/problem/11654
	 *  
	 *  알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.
	 * 
	 *  (입력) 알파벳 소문자, 대문자, 숫자 0-9 중 하나가 첫째 줄에 주어진다.
	 *  (출력) 입력으로 주어진 글자의 아스키 코드 값을 출력한다.
	 *  
	 *  (예제입력1) A
	 *  (예제출력1) 65
	 *  
	 *  (예제입력2) C
	 *  (예제출력2) 67
	 *  
	 *  (예제입력3) 0
	 *  (예제출력3) 48
	 *  
	 *  (예제입력4) 9
	 *  (예제출력4) 57
	 *  
	 *  (예제입력5) a
	 *  (예제입력5) 97
	 *  
	 *  (예제입력6) z
	 *  (예제입력6) 122
	 * 
	 * ===================================================
	 * 
	 * 필요지식
	 * 
	 * 1. 데이터
	 * 2. 기본형 데이터 타입
	 * 3. 문자 데이터
	 * 
	 * ===================================================
	 * 
	 * 1. 데이터
	 *  
	 *  1bit : 0 또는 1의 정보를 저장하는 데이터의 최소 단위
	 *  1byte : 8bit. 컴퓨터는 바이트 단위로 데이터를 읽고 쓰는 작업을 함.
	 *  
	 * 2. 기본형 데이터 타입
	 *  - 논리형 : boolean (1byte)
	 *  - 문자형 : char (2byte)
	 *  - 정수형 : byte (1byte) - short(2byte) - int(4byte) - long(8byte)
	 *  - 실수형 : float(4byte) - double(8byte)
	 * 
	 * 3. 문자형 데이터 char
	 *  - 2byte(=16bit) -> 자리의 2진수로 표현할 수 있는 정수의 개수인 65536개(0~65535)의 코드를 사용 가능.
	 *  - 65535를 넘어서는 코드의 문자들은 int를 통해 취급해야함
	 *  
	 *  - ASCII CODE
	 *   : 정보 교환을 위한 미국 표준 코드 (American Standard Code for Information Interchange)
	 *   : 7bit -> 2^7 = 128개의 문자집합
	 *   : char에서는 ASCII CODE에 해당하는 문자들이 0~127에 할당되어 있음
	 *   : 알파벳 소문자, 대문자, 숫자 0-9는 ASCII Code에 속해있음
	 *   
	 * ================================================
	 *   
	 */

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int assciiCode = (int) scanner.nextLine().charAt(0); // 문자 반환값을 int로 형변환(문제에서는 asciicode에 해당하는 문자만 입력하는 것으로 가정함)
		scanner.close();
		
		System.out.println(assciiCode);
	}

}
