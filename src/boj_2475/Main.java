package boj_2475;

	/* ==========================================================================================
	 * 백준 - Bronze5
	 * 
	 * [Bronze5] boj_2475 입력받은 값들의 제곱합을 10으로 나눈 나머지 (반복문)
	 * https://www.acmicpc.net/problem/2475	
	 * 
	 *  컴퓨터를 제조하는 회사인 KOI 전자에서는 제조하는 컴퓨터마다 6자리의 고유번호를 매긴다.
	 *  고유번호의 처음 5자리에는 00000부터 99999까지의 수 중 하나가 주어지며 6번째 자리에는 검증수가 들어간다.
	 *  검증수는 고유번호의 처음 5자리에 들어가는 5개의 숫자를 각각 제곱한 수의 합을 10으로 나눈 나머지이다.
	 *  
	 *  예를 들어 고유번호의 처음 5자리의 숫자들이 04256이면,
	 *  각 숫자를 제곱한 수들의 합 0+16+4+25+36 = 81 을 10으로 나눈 나머지인 1이 검증수이다.
	 * 
	 *  (입력)
	 *   첫째 줄에 고유번호의 처음 5자리의 숫자들이 빈칸을 사이에 두고 하나씩 주어진다.
	 *  
	 *  (출력)
	 *   첫째 줄에 검증수를 출력한다.
	 *
	 *  (예제 입력)
	 *   0 4 2 5 6
	 *  
	 *  (예제 출력)
	 *   1	
	 *  
	 * ==========================================================================================
	 * 
	 *  필요 지식
	 *   1. 반복문
	 *   
	 * ==========================================================================================
	 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		// 입력을 라인으로 받음
		String input = getInput();
		
		// 입력받은 숫자들을 파싱하여 배열에 저장
		int[] intArr = toIntArr(input, " ");
		
		// 검증수
		int verification = getVerification(intArr);
		
		// 출력
		outPrint(verification);
	}
	
	// 입력
	private static String getInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		br.close();
		return input;
	}

	// 문자열의 숫자들을 파싱하여 배열에 저장
	private static int[] toIntArr(String input, String delim) {
		StringTokenizer st = new StringTokenizer(input,delim);
		int[] intArr = new int[st.countTokens()];
		
		for (int i=0; i<intArr.length; i++) {
			intArr[i] = Integer.parseInt(st.nextToken());
		}
		return intArr;
	}
	
	// int 배열을 통해 검증수 반환
	private static int getVerification(int[] intArr) {
		int verification = 0;
		for (int i=0; i<intArr.length; i++) {
			verification += Math.pow(intArr[i], 2);
		}
		verification %= 10;
		return verification;
	}
	
	// 숫자 출력
	private static void outPrint(int verification) throws IOException {
		BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));
		bwr.write(String.valueOf(verification));
		bwr.flush();
		bwr.close();
	}
}
