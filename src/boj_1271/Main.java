package boj_1271;

	/* ==========================================================================================
	 * 백준 - Bronze5
	 * 
	 * <boj_1271>
	 * 큰 수의 연산 (BigInteger)
	 * https://www.acmicpc.net/problem/1271
	 * 
	 *  갑부 최백준 조교는 동전을 최소로 바꾸는데 성공했으나 김재홍 조교가 그 돈을 발견해서 최백준 조교에게 그 돈을 나누자고 따진다.
	 *  그 사실이 전 우주로 알려지자 우주에 있던 많은 생명체들이 자신들에게 돈을 분배해 달라고 당장 달려오기 시작했다.
	 *  프로토스 중앙 우주 정부의 정책인, ‘모든 지적 생명체는 동등하다’라는 규칙에 입각해서 돈을 똑같이 분배하고자 한다.
	 * 
	 *  한 생명체에게 얼마씩 돈을 줄 수 있는가?
	 *  또, 생명체들에게 동일하게 분배한 후 남는 돈은 얼마인가?
	 * 
	 *  (입력)
	 *  첫째 줄에는 최백준 조교가 가진 돈 n과 돈을 받으러 온 생명체의 수 m이 주어진다. (1 ≤ m ≤ n ≤ 101000, m과 n은 10진수 정수)
	 *  
	 *  (출력)
	 *  첫째 줄에 생명체 하나에게 돌아가는 돈의 양을 출력한다. 그리고 두 번째 줄에는 1원씩 분배할 수 없는 남는 돈을 출력한다.
	 * 
	 *  (예제 입력)
	 *   1000 100
	 *   
	 *  (예제 출력)
	 *   10
	 *   0
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
	 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer input = new StringTokenizer(br.readLine(), " ");
		br.close();
		
		BigInteger a = new BigInteger(input.nextToken()); // 입력 m의 범위가 1<=mㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴㄴ<=10^1000 이므로 BigInteger로 다뤄야함
		BigInteger b = new BigInteger(input.nextToken());
		
		// 계산
		BigInteger quotient = a.divide(b); // 몫
		BigInteger remainder = a.remainder(b); //나머지
		
		// 출력
		BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));
		bwr.write(quotient+"\n");
		bwr.write(remainder+"\n");
		bwr.flush();
		bwr.close();
	}

}