package boj_10989;

	/* ==========================================================================================
	 * 백준 - Silver5
	 * 
	 * [Silver5] boj_10989 입력 정수들을 정렬해서 출력하기 (풀이 1 : Arrays.sort)
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
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main1 {

	public static void main(String[] args) throws IOException {
		
		// 입력
		int[] intArr = inputInts();
		
		// 정렬
		Arrays.sort(intArr);
		
		// 출력
		printlnArr(intArr);
	}

	// 입력
	private static int[] inputInts() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int length = Integer.parseInt(br.readLine());
		int[] intArr = new int[length];
		for (int i=0; i<intArr.length; i++) {
			intArr[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		return intArr;
	}
	
	// 출력
	private static void printlnArr(int[] intArr) throws IOException {
		BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i : intArr) {
			bwr.write(String.valueOf(i));
			bwr.newLine();
		}
		bwr.flush();
		bwr.close();
	}

}