package boj_2338;

	/* ==========================================================================================
	 * 백준 - Bronze5
	 * 
	 * [Bronze5] boj_2338 큰 수의 연산 (BigInteger)
	 * https://www.acmicpc.net/problem/2338
	 * 
	 *  두 수 A, B를 입력받아, A+B, A-B, A×B를 구하는 프로그램을 작성하시오.
	 * 
	 *  (입력)
	 *   첫째 줄에 A가, 둘째 줄에 B가 주어진다. 각각의 수는 10진수로 1,000자리를 넘지 않으며 양수와 음수가 모두 주어질 수 있다.
	 *  
	 *  (출력)
	 *   첫째 줄에 A+B, 둘째 줄에 A-B, 셋째 줄에 A×B를 출력한다.
	 *   각각을 출력할 때, 답이 0인 경우를 제외하고는 0으로 시작하게 해서는 안 된다(1을 01로 출력하면 안 된다는 의미).
	 * 
	 *  (예제 입력)
	 *   1
	 *   -1
	 *   
	 *  (예제 출력)
	 *   0
	 *   2
	 *   -1
	 *  
	 * ==========================================================================================
	 * 
	 *  필요 지식
	 *   1. BigInteger
	 *   
	 * ==========================================================================================
	 * 
	 *  1. BigInteger
	 *  
	 *   
	 *   1) BigInteger의 도입
	 *   
	 *    java에서 기본형 정수 데이터의 저장 가능 범위는
	 *   
	 *     byte  : 8  bit (1byte) -> -2^7 ~ 2^7-1 (-128 ~ +127)
	 *     short : 16 bit (2byte) -> -2^15 ~ 2^15-1 (-32768 ~ +32767)
	 *     int   : 32 bit (4byte) -> -2^31 ~ 2^31-1 (-2,147,483,648 ~ +2,147,483,647)
	 *     long  : 64 bit (8byte) -> -2^63 ~ 2^63-1 (-9,223,372,036,854,775,808 ~ +9,223,372,036,854,775,807 : 약 10^19)
	 *    
	 *    와 같다.
	 *   
	 *    결국 기본형 데이터에로는 결국 19자리 정도의 값까지를 저장할 수 있는게 한계다.
	 *    이 보다 큰 값을 다루기 위해서는 별도의 방법이 필요한데, 이에 쓰기 좋은 것이 BigInteger이다.
	 *    BigInteger는 내부적으로 int배열을 사용하여 값을 다루기 때문에 long보다 큰 타입의 값을 다룰 수 있다.
	 *   
	 *   2) 생성
	 *    - BigInteger(String number) : 문자열로 생성
	 *    - BigInteger(String number, int radix) : 문자열을 radix 진수로 해석하여 Integer 객체 생성
	 *    - BigInteger.valueOf(long num ...) : 숫자로 객체 생성
	 *    
	 *   3) 다른 타입으로 반환
	 *    - String toString() : 문자열로 변환
	 *    - String toString(int radix) : radix진수의 문자열로 반환
	 *    - byte[] toByteArray : byte배열로 반환
	 *   
	 *    - Number에서 상속받은 메서드
	 *     * int intValue()
	 *     * long longValue()
	 *     * float floatValue()
	 *     * double doubleValue()
	 *     
	 *    - Exact가 붙은 것들 : 기본형 변환 결과가 저장 가능 범위에 속하지 않을 경우 ArithmeticException 발생
	 *     * byte byteValueExact()
	 *     * int intValueExact()
	 *     * long longValueExact()
	 *   
	 * ==========================================================================================
	 * 
	 *  2. BigInteger의 연산  
	 *   
	 *   - BigInteger add(BigInteger val) : 덧셈
	 *   - BigInteger subtract(BigInteger val) : 뺄셈
	 *   - BigInteger multiply(BigInteger val) : 곱셈
	 *   - BigInteger divide(BigInteger val) : 나눗셈 (몫)
	 *   - BigInteger remainder(BigInteger val) : 나머지
	 *   - BigInteger mod(BigInteger val) : 나머지 (나누는 값이 음수일 경우 ArithmeticException 발생)
	 *   
	 * ==========================================================================================
	 *   
	 *  3. 비트 연산 메서드
	 *   
	 *   int        bitCount()      : 2진수 표현시 1의 개수 반환 (음수일 때는 0의 개수)
	 *   int        bitLength()     : 2진수로 표현시 값을 표현하는데 필요한 bit수
	 *   boolean    testBit(int n)  : 우측에서 n+1번째 bit가 1이면 true, 0이면 false
	 *   BigInteger setBit(int n)   : 우측에서 n+1번째 비트를 1로 변경
	 *   BigInteger clearBit(int n) : 우측에서 n+1번째 bit를 0으로 변경
	 *   BigInteger flipBit(int n)  : 우측에서 n+1번째 bit를 전환 (1->0, 0->1)
	 *   
	 *   활용례> 어떤 BigInteger 값이 짝수인지 파악할 때 testBit(0)을 사용하면, 맨 끝 비트가 1이면 true -> 홀수, 0이면 false-> 짝수
	 *    
	 * ==========================================================================================
	 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger a = new BigInteger(br.readLine());
		BigInteger b = new BigInteger(br.readLine());
		br.close();
		
		// 계산
		BigInteger add = a.add(b); // 합
		BigInteger subtract = a.subtract(b); // 차
		BigInteger multiply = a.multiply(b); // 곱
		
		// 출력
		BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));
		bwr.write(add+"\n");
		bwr.write(subtract+"\n");
		bwr.write(multiply+"\n");
		bwr.flush();
		bwr.close();
	}

}
