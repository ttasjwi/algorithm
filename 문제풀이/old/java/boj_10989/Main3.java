package boj_10989;

	/* ==========================================================================================
	 * 백준 - Silver5
	 * 
	 * [Silver5] boj_10989 입력 정수들을 정렬해서 출력하기 (풀이 3 : 등장 횟수를 TreeMap 카운터에 기록 - 시간초과)
	 * https://www.acmicpc.net/problem/10989
	 * 
	 *  N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
	 * 
	 *  (입력)
	 *   첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다.
	 *   둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
	 *  
	 *  (출력)
	 *   첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
	 *
	 *  (예제 입력)
	 *   10
	 *   5
	 *   2
	 *   3
	 *   1
	 *   4
	 *   2
	 *   3
	 *   5
	 *   1
	 *   7
	 *  
	 *  (예제 출력)
	 *   1
	 *   1
	 *   2
	 *   2
	 *   3
	 *   3
	 *   4
	 *   5
	 *   5
	 *   7
	 *   
	 * ==========================================================================================
	 * 
	 *  필요 지식
	 *   1. TreeMap을 통한 정렬
	 *   
	 * ==========================================================================================
	 * 
	 *  1. TreeMap을 통한 정렬
	 *   TreeMap은 기본생성자로 생성할 경우 key의 Comparable 구현에 따른 정렬을 수행한다.
	 *  
	 * ==========================================================================================   
	 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main3 {

	public static void main(String[] args) throws IOException {
		Counter3 counter3 = new Counter3();
		System.out.println(counter3);
	}
}

class Counter3 {
	
	private TreeMap<Integer, Integer> counter = new TreeMap<>();
	
	// 객체 생성
	Counter3() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 입력 횟수
		
		for (int i=0; i<N; i++) {
			Integer number = Integer.valueOf(br.readLine());
			countNumber(number);
		}
		br.close();
	}
	
	// counter의 Entry를 반환함
	private Set<Map.Entry<Integer,Integer>> entrySet() {
		return counter.entrySet();
	}
	
	// 지정 숫자의 count를 증가시킴
	private void countNumber(Integer number) {
		if (counter.containsKey(number)) {
			counter.put(number, counter.get(number)+1);
			return;
		}
		counter.put(number, 1);
		return;
	}
	
	@Override
	public String toString() {
		
		Iterator<Map.Entry<Integer, Integer>> ir = entrySet().iterator();
		StringBuilder sb = new StringBuilder();
		
		while(ir.hasNext()) {
			Map.Entry<Integer, Integer> entry = ir.next();
			int number = entry.getKey(); // 저장된 숫자
			int count = entry.getValue(); // 숫자의 등장 횟수

			for (int i=0; i<count; i++) {
					sb.append(number);
					sb.append('\n');
			}
			
		}
		return sb.toString();
	}
}