package boj_1247;

	/* ==========================================================================================
	 * 백준 - Bronze3
	 * 
	 * [Bronze3] boj_1247 입력값들의 합의 부호들을 반환하기(반복문)
	 * https://www.acmicpc.net/problem/1247
	 * 
	 *  N개의 정수가 주어지면, 이 정수들의 합 S의 부호를 구하는 프로그램을 작성하시오.
	 * 
	 *  (입력)
	 *   총 3개의 테스트 셋이 주어진다.
	 *   각 테스트 셋의 첫째 줄에는 N(1 ≤ N ≤ 100,000)이 주어지고,
	 *   둘째 줄부터 N개의 줄에 걸쳐 각 정수가 주어진다. 주어지는 정수의 절댓값은 9223372036854775807보다 작거나 같다.
	 *  
	 *  (출력)
	 *   총 3개의 줄에 걸쳐 각 테스트 셋에 대해 N개의 정수들의 합 S의 부호를 출력한다. S=0이면 "0"을, S>0이면 "+"를, S<0이면 "-"를 출력하면 된다.
	 *
	 *  (예제 입력)
	 *   3
	 *   0
	 *   0
	 *   0
	 *   10
	 *   1
	 *   2
	 *   4
	 *   8
	 *   16
	 *   32
	 *   64
	 *   128
	 *   256
	 *   -512
	 *   6
	 *   9223372036854775807
	 *   9223372036854775806
	 *   9223372036854775805
	 *   -9223372036854775807
	 *   -9223372036854775806
	 *   -9223372036854775804
	 *  
	 *  (예제 출력)
	 *   0
	 *   -
	 *   +
	 *  
	 * ==========================================================================================
	 * 
	 *  필요 지식
	 *   1. 조건문, 반복문
	 *   
	 * ==========================================================================================
	 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		Prompt p = new Prompt();
		p.run();
		return;
	}
}

class Prompt {
	
	private final int NMB_OF_TESTCASE = 3;
	
	private boolean isUsed;
	
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private char[] resultArr = new char[NMB_OF_TESTCASE];
	private StringBuilder sb = new StringBuilder();
	
	void run() throws IOException {
		if (!isUsed) { // 이 클래스는 한번만 사용되도록 설정했다. run()을 제외한 나머지 멤버들은 접근제어자를 private로 지정함
			input();
			printResult();
			isUsed = true;
		}
		return;
	}
	
	// 입력
	private void input() throws IOException {
		
		for (int i=0; i<resultArr.length; i++) {
			BigInteger sum = getInputSum(); // 입력받은 정숫값들의 합을 반환한다.
			char result = getStatusCode(sum); // sum의 부호를 문자로 반환한다.
			resultArr[i] = result; // 부호를 resultArr에 저장한다.
		}
		br.close();
		return;
	}
	
	// 지정 횟수만큼 정수를 입력받고, 정수의 합을 BigInteger로 반환한다.
	private BigInteger getInputSum() throws IOException {
		int n = Integer.parseInt(br.readLine()); // 정수의 갯수
		BigInteger sum = BigInteger.ZERO;
		for (int j=0; j<n; j++) {
			sum = sum.add(new BigInteger(br.readLine())); // 합
		}
		return sum;
	}
	
	// 지정 BigInteger의 부호를 반환한다.
	private char getStatusCode(BigInteger bi) {
		char statusCode = ' ';
		
		int compareTo = bi.compareTo(BigInteger.ZERO);
		
		if (compareTo>0) return '+';
		if (compareTo==0) return '0';
		if (compareTo<0) return '-';
		
		return statusCode;
	}
	
	private void printResult() {
		for (char result : resultArr) {
			sb.append(result).append('\n'); // 각 result를 sb에 추가 후 줄바꿈한다.
		}
		System.out.println(sb.toString()); // result들을 출력한다.
		return;
	}
}