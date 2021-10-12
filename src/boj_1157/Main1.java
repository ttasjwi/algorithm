package boj_1157;

import java.util.*;

	/* ===================================================
	 * BOJ(백준) 7단계 - 문자열
	 * 
	 * <<boj_1157>>
	 *  입력 문자열에서 가장 많이 사용된 알파벳 반환하기 (풀이 1 : 문자의 갯수를 저장하는 배열 활용)
	 *  https://www.acmicpc.net/problem/1157
	 *  
	 *  알파벳 대소문자로 된 단어가 주어지면,
	 *  이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
	 *  단, 대문자와 소문자를 구분하지 않는다.
	 *  
	 *  
	 *  (입력)
	 *   첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
	 *  
	 *  (출력)
	 *   첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다.
	 *   단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
	 * 
	 *  예제 입력1> Mississipi
	 *  예제 출력1> ?
	 *  
	 *  예제 입력2> zZa
	 *  예제 출력2> Z
	 *  
	 *  예제 입력3> z
	 *  예제 출력3> Z
	 *  
 	 *  예제 입력4> baaa
	 *  예제 출력4> A
	 *  
	 * ===================================================
	 * 
	 * 필요지식
	 * 
	 *  1. 문자열을 전부 대문자/소문자로 바꾸기
	 * 
	 * ===================================================
	 * 
	 *  1. 문자열을 전부 대문자/소문자로 바꾸기
	 *   - toUpperCase() : 문자열을 대문자로
	 *   - toLowerCase() : 문자열을 소문자로
	 *   
	 * ===================================================
	 *   
	 */


public class Main1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine().toUpperCase(); // 입력한 문자열을 대문자로 저장함
		scanner.close();
		
		char maxCountChar = getMaxCountChar(str); // 가장 많이 입력된 문자를 반환함 
		System.out.println(maxCountChar);
	}

	private static char getMaxCountChar(String str) {
		int[] charCounter = countChar(str); // 문자열에서 a,b,c,... 의 개수를 세서 저장한 배열

		char maxCountChar = ' '; // 가장 많이 사용된 문자
		int maxCount = 0; // 가장 큰 빈도값
		
		for (int i=0; i<charCounter.length; i++) {
			if (maxCount < charCounter[i]) { // 가장 많이 사용된 문자일 경우 갱신
				maxCountChar = (char)(i+'A'); 
				maxCount = charCounter[i];
			} else if (maxCount == charCounter[i]) { // 동일한 횟수만큼 사용된 문자일 경우 '?'로 갱신
				maxCountChar = '?';
			}
		}
		return maxCountChar;
	}

	private static int[] countChar(String str) { // 지정 문자열에서 사용된 각 문자들의 사용횟수를 배열로 반환함
		final int alphabetCount = 26;
		int[] counter = new int[alphabetCount];
		
		for (int i=0; i<str.length(); i++) { // 문자열의 각 인덱스에 순차적으로 접근
			char ch = str.charAt(i);
			int index = ch - 'A';
			counter[index] ++; // 해당 문자의 인덱스가 가리키는 값을 증가
		}
		
		return counter;
	}
	
}
