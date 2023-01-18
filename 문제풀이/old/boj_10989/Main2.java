package boj_10989;

	/* ==========================================================================================
	 * 백준 - Silver5
	 * 
	 * [Silver5] boj_10989 입력 정수들을 정렬해서 출력하기 (풀이 2 : 등장 횟수를 '카운터'에 기록)
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
	 *   1. 정렬
	 *   
	 * ==========================================================================================
	 * 
	 *  1. Arrays.sort
	 *   
	 *   Comparable 구현체들의 배열을 Arrays.sort()로 오름차순으로 정렬 가능
	 *  
	 * ==========================================================================================   
	 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

	public static void main(String[] args) throws IOException {
		Counter counter = new Counter();
		System.out.println(counter);
	}
}


class Counter {
	
	private int[] counter = new int[10000];
	
	int getCount(int number) {return counter[number-1];}
	int getNumber(int index) {return index+1;}
	int getIndex(int number) {return number-1;}
	
	// 카운터 객체 생성
	Counter() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 입력 횟수
		
		for (int i=0; i<N; i++) {
			int number = Integer.parseInt(br.readLine());
			int index = getIndex(number);
			counter[index] ++;
		}
		br.close();
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<counter.length; i++) {
			int number = getNumber(i); // 현재 인덱스가 가리키는 숫자
			int count = getCount(number); // 현재 숫자의 등장 횟수
			
			if (count>0) {
				for (int j=0; j<count; j++) {
					sb.append(number);
					sb.append('\n');
				}
			}
		}
		return sb.toString();
	}
}