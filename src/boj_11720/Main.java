package boj_11720;

import java.util.Scanner;

	/* ===================================================
	 * BOJ(백준) 7단계 - 문자열
	 * 
	 * <<boj_11720>>
	 *  입력받은 숫자 문자열을 분리/파싱하여, 각 자리수 합을 구하기
	 *  https://www.acmicpc.net/problem/11720
	 *  
	 *  N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
	 * 
	 *  (입력) 첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
	 *  (출력) 입력으로 주어진 숫자 N개의 합을 출력한다.
	 *  
	 *  (예제입력1)
	 *   1
	 *   1
	 *  (예제출력1)
	 *   1
	 *  
	 *  (예제입력2)
	 *   5
	 *   54321
	 *   
	 *  (예제출력2)
	 *   15
	 *  
	 *  (예제입력3)
	 *   25
	 *   7000000000000000000000000
	 *  (예제출력3)
	 *   7
	 *  
	 *  (예제입력4)
	 *   11
	 *   10987654321
	 *   
	 *  (예제출력4)
	 *   46
	 * 
	 * ===================================================
	 * 
	 * 필요지식
	 * 
	 *  1. 문자열 분리
	 *  2. 숫자 문자열 파싱하기 (Integer.parseInt, Integer.valueOf)
	 *  3. 오토박싱, 오토언박싱 (JDK 1.5 이후)
	 * 
	 * ===================================================
	 * 
	 *  1. 문자열 분리
	 *  
	 *  - String의 메서드 split(String regex) : 정규식 또는 특정 문자열을 기준으로 문자열을 쪼개 배열에 저장
	 *  - String의 메서드 charAt(int index) : 문자열의 index번 인덱스에 위치한 문자를 char로 분리
	 *  - String의 메서드 substring (int fromIndex, int toIndex) : from 이상 to 미만 인덱스에 위치한 문자열을 분리
	 *  
	 * ===================================================
	 * 
	 *  2. 숫자 문자열 파싱하기 (Integer.parseInt, Integer.valueOf)
	 *   - Integer.parseInt(String numberString) : 숫자로 된 문자열을 Int 타입으로 반환
	 *   - Integer.valueOf(String numberString) : 숫자로 된 문자열을 Integer 타입으로 반환
	 *  
	 * ===================================================
	 * 
	 *  3. 오토박싱, 오토 언박싱 (JDK 1.5  이후)
	 *   - 오토박싱 : 기본형데이터의 값을 래퍼클래스의 객체로 다루고 싶을 때는 1.5 이전에는 형변환을 거쳐야했지만, 1.5 이후에는 컴파일러가 자동으로 형변환을 해준다.
	 *   - 오토언박싱 : 래퍼클래스의 객체를 기본형 데이터로 다룰 때에는 1.5 이전에 형변환을 거쳐야 했지만, 1.5이후에는 컴파일러가 자동으로 형변환을 해준다.
	 *   
	 * ===================================================
	 *   
	 */


class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int length = scanner.nextInt(); // 입력받을 숫자의 자릿수
		scanner.nextLine(); // 개행문자 제거
		
		String[] number_Str = scanner.nextLine().split(""); // 숫자 문자열을 라인으로 읽어 저장
		scanner.close();
		
		int sum = getSum(number_Str, length); // length만큼 number_Str의 각 자리수 합을 구하여 반환함
		System.out.println(sum);
	}

	private static int getSum(String[] number_Str, int length) {
		int sum = 0;
		
		for (int i=0; i<length; i++) {
			sum += Integer.parseInt(number_Str[i]); // 숫자 문자열의 각자리마다 파싱 후, 그 값을 합에 더 함
		}
		
		return sum;
	}

}
