package boj_15733;

	/* ==========================================================================================
	 * 백준 - Bronze5
	 * 
	 * [Bronze5] boj_15733 "I'm Sexy" 출력 (단순 출력)
	 * https://www.acmicpc.net/problem/15733
	 * 
	 *  당신은 지금 코딩을 하고있다. 그럼 당신은 어떤 사람인가.
	 * 
	 *  (입력)
	 *   없다.
	 *  
	 *  (출력)
	 *   “I'm Sexy”를 출력한다.
	 * 
	 *  (예제 입력)
	 *   
	 *  (예제 출력)
	 *   I'm Sexy
	 *  
	 * ==========================================================================================
	 * 
	 *  필요 지식
	 *   1. 출력문
	 *   
	 * ==========================================================================================
	 * 
	 *  1. 출력문
	 *   - 표준 출력문 : System.out.println()
	 *   - BufferedWriter
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

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));
		bwr.write("I'm Sexy");
		bwr.flush();
		bwr.close();
	}

}
