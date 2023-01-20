package boj_2675;

import java.util.Scanner;

	/* ===================================================
	 * BOJ(백준) 7단계 - 문자열
	 * 
	 * <<boj_2675>>
	 *  입력 문자열의 각 문자를 R회씩 반복시킨 문자열 출력 (StringBuffer 활용)
	 *  https://www.acmicpc.net/problem/2675
	 *  
	 *  문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
	 *  즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다.
	 *  S에는 QR Code "alphanumeric" 문자만 들어있다.
	 *  QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.
	 *  
	 *  (입력)
	 *   첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다.
	 *   각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다.
	 *   S의 길이는 적어도 1이며, 20글자를 넘지 않는다. 
	 *  
	 *  (출력)
	 *   각 테스트 케이스에 대해 P를 출력한다.
	 * 
	 *  예제 입력>
	 *   2
	 *   3 ABC
	 *   5 /HTP
	 *   
	 *  예제 출력>
	 *   AAABBBCCC
	 *   /////HHHHHTTTTTPPPPP
	 *  
	 * ===================================================
	 * 
	 * 필요지식
	 * 
	 *  1. StringBuffer 클래스란?
	 *  2. StringBuffer의 주요 메서드
	 *  3. StringBuffer의 비교
	 * 
	 * ===================================================
	 * 
	 *  1. StringBuffer
	 *   
	 *   1) StringBuffer 클래스란?
	 *   
	 *   - String 클래스는 생성 후  수정 불가능
	 *   - StringBuffer는 문자열을 추가, 변경 가능함
	 *   
	 *   2) StringBuffer의 생성자
	 *    - StringBuffer() :  버퍼의 capacity를 16으로 초기화하여 생성
	 *    - StringBuffer(int length) : 버퍼의 capacity를 length로 초기화하여 생성
	 *    - StringBuffer(String str) : 버퍼에 str을 저장, 버퍼의 capacity를 str.length() + 16으로 초기화 
	 *   
	 * ===================================================
	 *  
	 *  2. StringBuffer의 주요 메서드
	 *   
	 *   1) append : 버퍼의 뒤에 문자열 추가. 추가작업을 진행하고 반환함. 반환타입이 StringBuffer
	 *   
	 *   - StringBuffer append(기본형데이터) : 입력한 값을 문자열로 변환하여 인스턴스가 저장하고 있는 문자열의 뒤에 덧붙임
	 *   - StringBuffer append(인스턴스) : 입력한 인스턴스의 toString()메서드를 호출하여 문자열의 뒤에 덧붙임
	 *   
	 *   2) deleteCharAt : 버퍼에서 지정 인덱스의 문자 제거
	 *    - StringBuffer deleteCharAt(int index) : 지정한 index에 위치한 문자를 지운다. 그리고 뒤에 문자가 있으면 앞으로 당김. 그 후 결과를 반환
	 *    - StringBuffer delete(int fromIndex, int toIndex) : from 이상  to 미만에 위치한 문자 제거 후 문자 앞당김. 그리고 결과 반환
	 *   
	 *   3) insert : 문자데이터 삽입
	 *    - StringBuffer insert(int index, 데이터타입) : 지정 인덱스에 문자열 삽입(뒤의 내용은 뒤로 밀어버림) 후 반환
	 *   
	 *   4) replace : 문자열 대체
	 *    - StringBuffer replace(int fromIndex, int toIndex, String str) : from이상 to 미만에 위치한 문자들을 지정 문자열로 싹 바꾸고 뒷부분을 밀어버림. 결과물 반환
	 *    
	 *   5) capacity : 버퍼의 크기
	 *    - int capacity() : 버퍼의 크기를 반환
	 *   
	 *   6) length : 저장 문자열의 길이
	 *    - int length() : 저장 문자열의 길이 반환
	 *   
	 *   7) toString : 문자열 반환
	 *    - String toString() : 버퍼에 저장된 문자열을 String으로 반환
	 *    
	 * ===================================================   
	 * 
	 *  3. StringBuffer의 비교
	 *   StringBuffer 클래스는 equals 메서드가 오버라이드 되어있지 않아서 주소값을 비교한 후 서로 같은지의 여부를 반환한다.
	 *    -> toString()을 통하여 문자열을 반환받고 이들끼리를 비교하자.
	 *     
	 * ===================================================   
	 */


public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int testCaseNumber = scanner.nextInt(); // 테스트케이스의 갯수 및 개행문자 제거
		scanner.nextLine();
		
		for (int i=0; i< testCaseNumber; i++) { // 테스트 케이스의 갯수만큼 반복
			
			int repetition = scanner.nextInt(); // 반복 횟수
			String source = scanner.next(); // 문자열
			scanner.nextLine(); // 개행문자 제거
			
			String repetitionStr = getRepetitionStr(source, repetition); // 문자열의 각 철자를 repetition회 반복한 문자를 반환
			System.out.println(repetitionStr);
		}
		scanner.close();
	}

	private static String getRepetitionStr(String str, int repetition) {
		StringBuffer buff = new StringBuffer();
		
		for (int i=0; i<str.length(); i++) {
			buffAppend(str, i, buff, repetition); // str의 i인덱스에 위치한 문자를 buff에 repetiton회 추가
		}
		
		String repetitionStr = buff.toString(); // 버퍼에 저장된 문자열을 String으로 반환
		return repetitionStr;
	}

	private static void buffAppend(String source, int index, StringBuffer buff, int repetition) {
		// 원본 소스의 index에 위치한 문자를 버퍼에 repetiton회 추가
		
		for (int i=0; i<repetition; i++) {
			buff.append(source.charAt(index)); 
		}
	}

}
