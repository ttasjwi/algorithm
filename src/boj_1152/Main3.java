package boj_1152;

import java.util.Scanner;

	/* ===================================================
	 * BOJ(백준) 7단계 - 문자열
	 * 
	 * <<boj_1152>>
	 *  입력 문장에 속한 단어의 갯수 (풀이 3 : Scanner의 useDelimiter 활용)
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
	 *  2. Scanner
	 *  
	 * ===================================================
	 * 
	 *  1. String trim()
	 *   - 문자열의 양 끝의 공백을 제거
	 *   
	 * ===================================================
	 * 
	 *  2. Scanner
	 *   입력소스로부터 문자 데이터를 읽어오는 목적으로 사용되는 클래스
	 * 
	 *    [생성자]
	 *     - Scanner(System.in) : 사용자의 입력으로부터 값을 버퍼에 저장
	 *     - Scanner(String source) : 문자열 source에 저장된 값을 버퍼에 저장
	 *     - Scanner(File source) : 파일 source에 저장된 값을 버퍼에 저장
	 *     - Scanner(InputStream source)
	 * 
	 * ===================================================
	 * 
	 *  3. Scanner(System.in) 사용 시 주의점
	 *  
	 *   1) 사용자의 입력
	 *   
	 *   2) 사용자가 입력 한값을 버퍼에 저장. 이 때 공백, 탭문자, 개행자(\n) 등도 버퍼에 저장된다.
	 *   
	 *   3) next(), nextInt() 메서드는
	 *      버퍼에서 다음 공백, 탭문자, 개행자를 기점으로 앞부분까지만 가져와서(버퍼에서 해당부분은 지워짐) 반환한다.
	 *      
	 *   4) nextLine() 메서드는 다음 개행자(\n)까지 가져와서(버퍼에서 해당부분은 지워짐)
	 *      개행자 앞부분까지를 반환한다.
	 *    
	 *   5) 이런 점에서 next(), nextInt() 등에 이어서 nextLine() 등을 같이 쓸 때는 주의해야하는데,
	 *      nextLine()을 한번 사용해서 버퍼를 비우도록 해야함.
	 * 
	 *   6) 타입이 맞지 않는 입력값을 받았을 경우 inputMismatchException이 발생하므로 예외처리를 하는 것이 좋다.
	 * 
	 * ===================================================
	 * 
	 *  4. Scanner의 UseDelimiter 메서드
	 *   - Scanner useDelimiter(Pattern pattern) : Pattern 객체에 저장된 패턴(정규식)을 구분자로 한 Scanner 반환
	 *   - Scanner useDelimiter(String pattern) : 문자열로 된 패턴(정규식)을 구분자로 한 Scanner 생성
	 *   
	 * =================================================== 
	 *   
	 *  5. Scanner의 메서드
	 *   - hasNextLine(), hasNext() , hasNextInt(), hasNextDouble,... : 다음 토큰의 존재 여부를 boolean으로 반환
	 *   - nextLine(), next(), nextInt(), nextDouble() : 토큰을 반환
	 *   
	 * ===================================================
	 * 
	 *  6. Scanner의 자원반환
	 *   Scanner를 사용 후 자원을 반환하기 위해 close()를 사용해야함
	 *   try-with-resources문을 사용하면 자원반환이 보장됨
	 * 
	 * =================================================== 
	 */


public class Main3 {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		
		String str = sc1.nextLine().trim(); // 문자열을 라인단위로 입력받아 저장 후 양 끝의 공백을 제거
		sc1.close();
		
		int count = getNumberOfWord(str); // 문자열에서 공백으로 구분한 단어의 개수
		System.out.println(count);
	}

	private static int getNumberOfWord(String str) {
		int count = 0;
		if ("".equals(str)) return count; // 공백을 입력했을 경우 0 반환
		
		try (Scanner sc2 = new Scanner(str).useDelimiter(" +")) { // try문 종료시 자동 close()를 보장함
			while (sc2.hasNext()) {
				sc2.next();
				count ++;
			}
		} 
		
		return count;
	}

}
