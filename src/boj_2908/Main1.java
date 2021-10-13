package boj_2908;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

	/* ===================================================
	 * BOJ(백준) 7단계 - 문자열
	 * 
	 * <<boj_2908>>
	 *  숫자 뒤집기 (풀이 1 : 수학적 연산 활용)
	 *  https://www.acmicpc.net/problem/2908
	 *  
	 *  상근이의 동생 상수는 수학을 정말 못한다. 상수는 숫자를 읽는데 문제가 있다.
	 *  이렇게 수학을 못하는 상수를 위해서 상근이는 수의 크기를 비교하는 문제를 내주었다.
	 *  상근이는 세 자리 수 두 개를 칠판에 써주었다. 그 다음에 크기가 큰 수를 말해보라고 했다.
	 *  상수는 수를 다른 사람과 다르게 거꾸로 읽는다.
	 *  
	 *  예를 들어, 734와 893을 칠판에 적었다면, 상수는 이 수를 437과 398로 읽는다.
	 *  따라서, 상수는 두 수중 큰 수인 437을 큰 수라고 말할 것이다.
	 *  두 수가 주어졌을 때, 상수의 대답을 출력하는 프로그램을 작성하시오.
	 *  
	 *  (입력)
	 *   첫 줄에 영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열의 길이는 1,000,000을 넘지 않는다.
	 *   단어는 공백 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다.
	 *   또한 문자열은 공백으로 시작하거나 끝날 수 있다.
	 *  
	 *  (출력)
	 *   첫째 줄에 상근이가 칠판에 적은 두 수 A와 B가 주어진다. 두 수는 같지 않은 세 자리 수이며, 0이 포함되어 있지 않다.
	 * 
	 *   예제 입력1> 734 893
	 *   예제 출력1> 437
	 *  
	 *   예제 입력2> 221 231
	 *   예제 출력2> 132
	 *  
	 *   예제 입력3> 839 237 
	 *   예제 출력3> 938
	 *  
	 * ===================================================
	 * 
	 * 필요지식
	 * 
	 *  1. int 타입의 각 자리수 분리법 (1) 수학적 연산
	 *  
	 * ===================================================
	 * 
	 *  1. int 타입의 각 자리수 분리 (1) 수학적 연산
	 *  
	 *   - 정수의 자리수 : log10(값) + 1
	 *   - 일의 자리수 반환법 : 값%10
	 *   - 정수를 일의자리 제외하고 앞당기기 : 값/10
	 *   
	 * =================================================== 
	 */

public class Main1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
		String line = br.readLine().trim();
		br.close();
		
		String[] lineSplit = line.split(" +");
		
		int a = Integer.parseInt(lineSplit[0]);
		int b = Integer.parseInt(lineSplit[1]);

		int a_reverse = getReverseNumber(a); // a를 역순으로 한 값
		int b_reverse = getReverseNumber(b); // b를 역순으로 한 값

		int max = getMax(a_reverse, b_reverse); // 둘 중 큰 값
		
		BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out)); // 출력
		bwr.write(max+"");
		bwr.flush();
		bwr.close();
	}
	
	private static int getReverseNumber(int number) { // 숫자를 역순으로 한 값을 반환
		
		int[] numberSplit = getNumberSplit(number);
		
		int reverseNumber = 0;
		
		for(int i=0; i<numberSplit.length; i++) { // 분리 배열의 값을 순서대로 읽어서
			int exponent = numberSplit.length-1-i; 
			reverseNumber += numberSplit[i] * Math.pow(10,exponent); // 곱하는 지숫값을 역으로 하여 곱함
		}
		return reverseNumber;
	}

	private static int[] getNumberSplit(int number) {// number의 각 자리수를 분리하고, 배열에 아랫 자리부터 순서대로 저장
		
		int numberLength = (int)Math.log10(number) + 1; // number의 자리수
		int[] numberSplit = new int[numberLength];
		
		for (int i=0; i<numberSplit.length; i++) {
			final int DIVISOR = 10;
			numberSplit[i] = number%DIVISOR; // 분리 후 아랫자리부터 순서대로 저장
			number = number/DIVISOR;
		}
		return numberSplit;
	}

	private static int getMax(int a, int b) { // 두 값 중 큰 값을 반환
		int max = a;
		if (max < b) max = b;
		return max;
	}
}
