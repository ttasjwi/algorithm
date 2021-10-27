package boj_10757;

	/* ==========================================================================================
	 * 백준 - Bronze5
	 * 
	 * [Bronze5] boj_10757 큰 수의 합산 (A+B)
	 * https://www.acmicpc.net/problem/10757
	 * 
	 *  두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
	 * 
	 *  (입력)
	 *   첫째 줄에 A와 B가 주어진다. (0 < A,B < 10^10000)
	 *  
	 *  (출력)
	 *   첫째 줄에 A+B를 출력한다.
	 *
	 *  (예제 입력)
	 *   9223372036854775807 9223372036854775808
	 *  
	 *  (예제 출력)
	 *   18446744073709551615
	 *  
	 * ==========================================================================================
	 * 
	 *  필요 지식
	 *   1. 큰 수를 다룰 때는 BigInteger를 쓰자...
	 *     long : 8바이트 = 64비트 : -2^63 ~ 2^63-1 (- 9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807)
	 *   
	 * ==========================================================================================
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
		Prompt p = new Prompt();
		p.run();
	}

}

class Prompt {
	
	void run() throws IOException {
		
		String input = getInput(); // 입력
		BigInteger[] argsArr = split(input," "); // BigInteger 배열로 분리
				
		BigInteger sum = getSum(argsArr); // 분리된 BigInteger들을 합산
		
		print(sum); // 출력
	}

	// 사용자로부터 라인단위로 입력을 받는다
	private String getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		br.close();
		return input;
	}
	
	// 지정 문자열을 구분자를 통해 분리
	private BigInteger[] split(String input, String delim) {
		// input을 분리
			StringTokenizer st = new StringTokenizer(input,delim);
			BigInteger[] biArr = new BigInteger[st.countTokens()];
			
			for (int i=0; i<biArr.length; i++) {
				biArr[i] = new BigInteger(st.nextToken());
			}
			
			return biArr;
	}
	
	// 지정 BigInteger들을 합산
	private BigInteger getSum(BigInteger ...bigIntegers) {
		BigInteger sum = BigInteger.ZERO;
		
		for (BigInteger bi : bigIntegers) {
			sum = sum.add(bi);
		}
		
		return sum;
	}
	
	// 지정 객체의 toString() 메서드를 호출하여 출력
	private void print(Object o) throws IOException {
		BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));
		bwr.write(o.toString());
		bwr.flush();
		bwr.close();
	}
}
