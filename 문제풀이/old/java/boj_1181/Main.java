package boj_1181;

	/* ==========================================================================================
	 * 
	 * 백준 - Silver5
	 * 
	 * [Silver5] boj_1181 입력 단어들을 정렬하기(Comparator 구현)
	 * https://www.acmicpc.net/problem/1181
	 * 
	 *  알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
	 *  1. 길이가 짧은 것부터
	 *  2. 길이가 같으면 사전 순으로
	 * 
	 *  (입력)
	 *   첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000)
	 *   둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다.
	 *   주어지는 문자열의 길이는 50을 넘지 않는다.
	 *  
	 *  (출력)
	 *   조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
	 *
	 *  (예제 입력)
	 *   13
	 *   but
	 *   i
	 *   wont
	 *   hesitate
	 *   no
	 *   more
	 *   no
	 *   more
	 *   it
	 *   cannot
	 *   wait
	 *   im
	 *   yours
	 *  
	 *  (예제 출력)
	 *   i
	 *   im
	 *   it
	 *   no
	 *   but
	 *   more
	 *   wait
	 *   wont
	 *   yours
	 *   cannot
	 *   hesitate
	 *  
	 * ==========================================================================================
	 * 
	 *  필요 지식
	 *  
	 *   1. Comparable 인터페이스 구현
	 *   2. Comparator 인터페이스 구현
	 *   3. 정렬 방법
	 *   
	 * ==========================================================================================
	 * 
	 *   1. Comparable 인터페이스 구현
	 *   기본 정렬 기준을 구현하는데 사용
	 *   java.lang에 있음 (별도로 import 필요 없음)
	 *  
	 *   int compareTo(Object o)
	 *  
	 *   2. Comparator 인터페이스 구현
	 *   기본 정렬 기준 외에 다른 기준으로 정렬하고자 할 때 사용
	 *   java.util에 있음
	 *  
	 *   int compare(Object o1, Object o2)
	 *   boolean equals(Object obj)
	 * 
	 *   3. 정렬 방법
	 *   
	 *   - 정렬을 위해서는 정렬 대상이 필요하고 정렬 기준이 필요하다.
	 *   - sort(Object[] arr) : 기본 정렬 기준 Comparable의 구현에 의한 정렬. 비교대상들이 Comparable 인터페이스를 구현해야한다.
	 *   - sort(Object[] arr, Comparator cp) : 별도의 정렬 기준 Comparator의 구현에 의한 정렬. 비교대상들이 Comparator 인터페이스를 구현해야한다.
	 *   - 각각의 정렬 기준에 존재하는 compareTo, compare을 기준으로 하여 두 객체끼리 비교하여  1,0,-1을 반환받고 이를 통한 자리바꿈
	 *  
	 * ==========================================================================================
	 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		Prompt p = new Prompt();
		p.run();
	}

}

class Prompt {
	
	void run() throws IOException {
		
		Set<String> wordSet = inputTreeSet(new MyComparator()); // 입력
		printlnCollection(wordSet); // 출력
	}
	
	// 사용자로부터 문자열을 입력을 받아 지정 기준에 따라 TreeSet에 저장한다.
	TreeSet<String> inputTreeSet(Comparator<String> cmp) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		TreeSet<String> treeSet = new TreeSet<String>(cmp);
		
		for (int i=0; i<n; i++) {treeSet.add(br.readLine());}
		br.close();
		
		return treeSet;
	}
	
	
	// 컬렉션의 모든 요소들을 매 줄마다 줄을 바꿔서 출력 (toString())
	private <E> void  printlnCollection(Collection<E> collection) { 
		StringBuilder sb = new StringBuilder();
		
		for (E e : collection) {sb.append(e).append('\n');}
		System.out.println(sb.toString());
		return;
	}
}

class MyComparator implements Comparator<String>{

	@Override
	public int compare(String str1, String str2) {
		if (str1.length()==str2.length()) return str1.compareTo(str2);
		
		return str1.length()-str2.length();
	}
}
