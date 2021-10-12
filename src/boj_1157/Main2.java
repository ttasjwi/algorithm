package boj_1157;

import java.util.*;

	/* ===================================================
	 * BOJ(백준) 7단계 - 문자열
	 * 
	 * <<boj_1157>>
	 *  입력 문자열에서 가장 많이 사용된 알파벳 반환하기 (풀이 2 : 문자를 key, 문자의 등장횟수를 value로 하는 Map 활용)
	 *  https://www.acmicpc.net/problem/1157
	 *  
	 *  알파벳 대소문자로 된 단어가 주어지면,
	 *  이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
	 *  단, 대문자와 소문자를 구분하지 않는다.
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
	 *  1. Map<K, V>
	 * 
	 * ===================================================
	 * 
	 *  1. Map<K, V>
	 *   - key와 value의 쌍을 Map.Entry 인터페이스를 구현한 Entry로 묶어서 저장
	 *   - key의 중복을 허용하지 않고, value의 중복을 허용함
	 *   - 순서가 정해지지 않음
	 *   
	 * ===================================================
	 *  
	 *  2. Map에 Iterator로 접근하기
	 *   - entrySet : Key, Value를 저장한 Map.Entry 객체들의 Set을 반환
	 *   - entrySet에 iterator 메서드를 사용하여 접근 Iterator 객체 생성.
	 *   - 이때 지네릭 타입 <Key, Value>를 지정해서 생성해야함
	 * 
	 * ===================================================  
	 */



public class Main2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine().toUpperCase(); // 입력한 문자열을 대문자로 저장함
		scanner.close();
		
		char maxCountChar = getMaxCountChar(str); // 가장 많이 입력된 문자를 반환함 
		System.out.println(maxCountChar);
	}

	private static char getMaxCountChar(String str) {
		
		Map<Character, Integer> charCounter = getCharCounter(str); // 문자열의 문자를 key로, 문자의 등장 횟수를 value로 한 Map 
		Iterator<Map.Entry<Character,Integer>> it = charCounter.entrySet().iterator(); // charCounter의 Entry에 접근
		
		char maxCountChar = ' '; // 가장 많이 출현한 문자
		int maxCount = 0; // 가장 많이 출현한 문자의 등장 횟수
		
		while(it.hasNext()) {
			Map.Entry<Character, Integer> entry = it.next();
			char ch = entry.getKey(); // 문자
			int count = entry.getValue(); // 문자의 등장 횟수 
			
			if (maxCount < count) { // 문자의 등장횟수가 현재 최댓값보다 클 경우 갱신
				maxCount = count; 
				maxCountChar = ch;
			} else if (maxCount == count) { // 문자의 등장횟수가 현재 최댓값과 같을 경우(중복일 경우) '?'로 갱신
				maxCountChar = '?';
			}
		}
		return maxCountChar;
	}

	private static HashMap<Character,Integer> getCharCounter(String str) {
		// 문자열의 문자를 key로, 문자의 등장 횟수를 value로 한 Map 
		HashMap<Character, Integer> charCounter = new HashMap<>();
		
		for (int i=0; i<str.length(); i++) { // 문자열의 각 문자에 순차적으로 접근
			Character key = str.charAt(i);
			
			if (charCounter.containsKey(key)) { // Map이 key를 가지고 있을 경우 등장횟수를 1 증가시켜 저장
				charCounter.put(key, charCounter.get(key)+1);
			} else {
				charCounter.put(key, 1); // Map이 key를 가지고 있지 않을 경우 신규 저장
			}
		}
		
		return charCounter;
	}

}
