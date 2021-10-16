package boj_2920;

	/* ==========================================================================================
	 * 백준 - Bronze2
	 * 
	 * [Bronze2] boj_2920 증가, 감소 상태 (풀이 1 : 반복문, 조건문)
	 * https://www.acmicpc.net/problem/2920
	 * 
	 *  다장조는 c d e f g a b C, 총 8개 음으로 이루어져있다.
	 *  이 문제에서 8개 음은 다음과 같이 숫자로 바꾸어 표현한다. c는 1로, d는 2로, ..., C를 8로 바꾼다.
	 *  1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed 이다.
	 *  
	 *  연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.
	 * 
	 *  (입력)
	 *   첫째 줄에 8개 숫자가 주어진다. 이 숫자는 문제 설명에서 설명한 음이며, 1부터 8까지 숫자가 한 번씩 등장한다.
	 *  
	 *  (출력)
	 *   첫째 줄에 ascending, descending, mixed 중 하나를 출력한다.
	 *
	 *  (예제 입력 1)
	 *   1 2 3 4 5 6 7 8
	 *  
	 *  (예제 출력 1)
	 *   ascending 
	 *   
	 *  (예제 입력 2)
	 *   8 7 6 5 4 3 2 1
	 *   
	 *  (예제 출력 2)
	 *   descending
	 *  
	 *  (예제 입력 3)
	 *   8 1 7 2 6 3 5 4
	 *   
	 *  (예제 출력 3)
	 *   mixed
	 *  
	 * ==========================================================================================
	 * 
	 *  필요 지식
	 *   1. 함수의 증가
	 *   
	 * ==========================================================================================
	 * 
	 *  1. 함수의 증가, 감소
	 *   어떤 구간에서, 함수 f(x)의 정의역의 임의의 서로 다른 두 원소 x, y에 대해
	 *   a<b 일때, f(a)<f(b) 이면 이 함수는 이 구간에서 증가 상태에 있다.
	 *  
	 *   또, 어떤 구간에서 함수 f(x)의 정의역의 임의의 서로 다른 두 원소 x, y에 대해
	 *   a<b 일때, f(a)>f(b) 이면 이 함수는 이 구간에서 감소 상태에 있다.
	 *   
	 * ==========================================================================================
	 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1 {

	public static void main(String[] args) throws IOException {
		
		// 입력을 라인단위로 받음
		String intInput = getLine();
		
		// 입력받은 문자열을 구분자 " "을 기준으로 하여 정수 배열로 분리
		int[] intArr = intSplit(intInput," ");
		
		// int 배열의 증감 상태를 문자열로 반환
		String variation = getVariation(intArr);
		
		// 출력
		outPrint(variation);
	}
	
	// 라인단위로 문자를 입력받음
	private static String getLine() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		br.close();
		return line;
	}
	
	// 입력 문자열을 구분자로 쪼개고, 숫자로 파싱하여 배열에 저장
	private static int[] intSplit(String input, String delim) {
		StringTokenizer st = new StringTokenizer(input,delim);
		int[] intSplit = new int[st.countTokens()];
		
		for (int i=0; i<intSplit.length; i++) {
			intSplit[i] = Integer.parseInt(st.nextToken());
		}
		return intSplit;
	}
	
	// 숫자배열의 증감상태를 문자열로 반환
	private static String getVariation(int[] intArr) {
		String variation = "";
		
		if      (isAscending(intArr))  variation = "ascending";
		else if (isDescending(intArr)) variation = "descending";
		else                           variation = "mixed";
		
		return variation;
	}
	
	// 증가 상태니?
	private static boolean isAscending(int[] intArr) {
		for (int i=1; i<intArr.length; i++) {
			if(intArr[i-1]>intArr[i]) return false;
		}
		return true;
	}
	
	// 감소 상태니?
	private static boolean isDescending(int[] intArr) {
		for (int i=1; i<intArr.length; i++) {
			if(intArr[i-1]<intArr[i]) return false;
		}
		return true;
	}
	
	// 출력
	private static void outPrint(String variation) throws IOException {
		BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));
		bwr.write(variation);
		bwr.flush();
		bwr.close();
	}
}
