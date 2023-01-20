package boj_1152;

import java.util.Scanner;
import java.util.StringTokenizer;

	/* ===================================================
	 * BOJ(백준) 7단계 - 문자열
	 * 
	 * <<boj_1152>>
	 *  입력 문장에 속한 단어의 갯수 (풀이 2 : StringTokenizer)
	 *  https://www.acmicpc.net/problem/1152
	 *  
	 *  영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열에는 몇 개의 단어가 있을까?
	 *  이를 구하는 프로그램을 작성하시오. 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.
	 *  
	 *  (입력)
	 *   첫 줄에 영어 대소문자와 공백으로 이루어진 문자열이 주어진다. 이 문자열의 길이는 1,000,000을 넘지 않는다.
	 *   단어는 공백 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다.
	 *   또한 문자열은 공백으로 시작하거나 끝날 수 있다.
	 *  
	 *  (출력)
	 *   첫째 줄에 단어의 개수를 출력한다.
	 * 
	 *  예제 입력1> The Curious Case of Benjamin Button
	 *  예제 출력1> 6
	 *  
	 *  예제 입력2>  The first character is a blank
	 *  예제 출력2> 6
	 *  
	 *  예제 입력3> The last character is a blank 
	 *  예제 출력3> 6
	 *  
	 * ===================================================
	 * 
	 * 필요지식
	 * 
	 *  1. String trim()
	 *  2. StringTokenizer
	 *  3. 구분자로 문자열을 쪼개는 방법들
	 *  
	 * ===================================================
	 * 
	 *  1. String trim()
	 *   - 문자열의 양 끝의 공백을 제거
	 *   
	 * ===================================================
	 * 
	 *  2. StringTokenizer
	 *   문자열을 구분자를 기준으로 여러 개의 Token으로 잘라내여 활용하는 클래스
	 *   다른 방법과 달리 정규식을 사용하지 않고 사용하는 차별점이 있음
	 * 
	 *   다만, 구분자를 하나씩 인식한다는 점이 한계.
	 *   두 글자 이상의 복잡한 구분자로 나누거나 복잡한 형식에 맞춰 쪼갤 때는 정규식을 사용할 필요가 있다.
	 *   (예를 들어 ",.#+"을 구분자로 지정하면 "," "." "#" "+" 각각의 문자들이 구분자로 취급됨.)
	 * 
	 *    1) 생성자
	 *  	StringTokenizer (String str, String delim) : 문자열 지정, 구분자 지정
	 *      StringTokenizer (String str, String delim, boolean returnDelims) : true일 때 구분자도 토큰으로 간주 
	 *      
	 *    2) 메서드
	 *  	int countTokens() : 전체 토큰의 수 반환
	 *  	boolean hasMoreTokens() : 토큰이 남아있는지를 boolean으로 반환 
	 * 		String nextToken() : 다음 토큰을 반환
	 * 
	 * ===================================================
	 * 
	 *  3. 구분자로 문자열을 쪼개는 방법들
	 *   - String 객체.split(String regex) : 문자열을 regex로 쪼개서 배열로 반환
	 *   - Scanner 객체.useDelimiter(String pattern) : Scanner 객체의 내용을 pattern을 구분자로 한 Scanner 객체 반환
	 * 
	 * ===================================================
	 */


public class Main2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String str = scanner.nextLine().trim(); // 문자열을 라인단위로 입력받아 저장 후 양 끝의 공백을 제거
		scanner.close();
		
		int count = getNumberOfWord(str); // 문자열에서 공백으로 구분한 단어의 개수
		System.out.println(count);
	}

	private static int getNumberOfWord(String str) {
		StringTokenizer st = new StringTokenizer(str, " "); // " "로 토큰을 나누는 StringTokenizer
		return st.countTokens(); // 전체 토큰의 수를 반환
	}
	
}