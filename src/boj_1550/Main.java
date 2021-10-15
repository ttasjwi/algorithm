package boj_1550;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

	/* ==========================================================================================
	 * 백준 - Bronze5
	 * 
	 * [Bronze5] boj_1550 진법 변환 (Integer)
	 * https://www.acmicpc.net/problem/1550
	 * 
	 *  16진수 수를 입력받아서 10진수로 출력하는 프로그램을 작성하시오.
	 * 
	 *  (입력)
	 *  첫째 줄에 16진수 수가 주어진다. 이 수의 최대 길이는 6글자이다.
	 *  16진수 수는 0~9와 A~F로 이루어져 있고, A~F는 10~15를 뜻한다. 또, 이 수는 음이 아닌 정수이다.
	 *  
	 *  (출력)
	 *  첫째 줄에 입력으로 주어진 16진수 수를 10진수로 변환해 출력한다.
	 * 
	 *  (예제 입력)
	 *   A
	 *   
	 *  (예제 출력)
	 *   10
	 *  
	 * ==========================================================================================
	 * 
	 *  필요 지식
	 *   1. 래퍼클래스
	 *   
	 * ==========================================================================================
	 * 
	 *  1. 래퍼클래스
	 *  
	 *   1) Number 클래스
	 *    모든 Wrpper 클래스는 Number 클래스의 자손이다.
	 *    Number 클래스는 abstract 클래스로서,
	 *    abstract 메서드 intValue, longValue, floatValue, doubleValue, ... 을 가지고 있다.
	 *   
	 *    ~Value 메서드들은 각각의 래퍼 클래스에서를 오버라이드되어있어서
	 *    각 객체에 저장된 값을 ~Value 메서드를 호출함으로서 원하는 타입의 기본형 데이터로 반환할 수 있다.
	 * 
	 *   2) 문자열로 된 숫자를 기본형 데이터로 파싱하기
	 * 	   여기서는 int 타입만을 예시를 들어 설명함
	 * 
	 * 	   - Integer("숫자").intValue() : Integer 객체를 생성하여, intValue()를 통해 value를 int 타입으로 반환 
	 *     - Integer.parseInt("숫자", 진수) : Integer 클래스의 static 메서드 parseInt()를 통해 int 타입으로 반환. 진수 생략 시 10진법 숫자로 간주하고 파싱 
	 *     - Integer.valueOf("숫자", 진수) : 본래 래퍼클래스로 반환하지만, 사용처에서 int로 사용할 경우 컴파일러가 자동으로 int 타입으로 변환 해준다. (언박싱)
	 *  
	 *   3) 문자열로 된 숫자를 래퍼 클래스 객체로 반환하기]
	 *     - Integer.valueOf("숫자") : 문자열을 숫자로 변환하여 value로 저장한 Integer 객체를 반환함
	 *     - 기본형 데이터를 사용처에서 Integer로 사용할 경우 컴파일러가 알아서 Integer로 변환함 (오토박싱)
	 * 
	 *   4) 오토박싱, 언박싱
	 *     - 기본형 데이터, 래퍼클래스의 객체를 각각 반대로(기본형데이터를 객체로, 래퍼클래스를 기본형 데이터로) 사용하려 할 때
	 *       컴파일 할 때 컴파일러가 알아서 반대로 바꾸는 코드를 작성해줌. (JDK 1.5부터)
	 *    
	 * ==========================================================================================
	 */


public class Main {

	public static void main(String[] args) throws IOException {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strNmb = br.readLine();
		br.close();
		
		// 계산
		int number = Integer.parseInt(strNmb, 16); // 입력받은 16진수 문자열을 int타입 값(10진수)로 파싱
		
		// 출력
		BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));
		bwr.write(String.valueOf(number));
		bwr.flush();
		bwr.close();
	}

}
