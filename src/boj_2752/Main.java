package boj_2752;

	/* ==========================================================================================
	 * 백준 - Bronze4
	 * 
	 * [Bronze4] boj_2752 세수 정렬
	 * https://www.acmicpc.net/problem/2752
	 * 
	 *  동규는 세수를 하다가 정렬이 하고싶어졌다.
	 *  숫자 세 개를 생각한 뒤에, 이를 오름차순으로 정렬하고 싶어 졌다.
	 *  숫자 세 개가 주어졌을 때, 가장 작은 수, 그 다음 수, 가장 큰 수를 출력하는 프로그램을 작성하시오.
	 * 
	 *  (입력)
	 *   숫자 세 개가 주어진다. 이 숫자는 1보다 크거나 같고, 1,000,000보다 작거나 같다. 이 숫자는 모두 다르다.
	 *  
	 *  (출력)
	 *   제일 작은 수, 그 다음 수, 제일 큰 수를 차례대로 출력한다.
	 *
	 *  (예제 입력)
	 *   3 1 2
	 *  
	 *  (예제 출력)
	 *   1 2 3
	 *  
	 * ==========================================================================================
	 * 
	 *  필요 지식
	 *   1. 정렬
	 *   
	 * ==========================================================================================
	 * 
	 *  1. Arrays.sort(Arr)
	 *   : Comparable 구현에 의한 오름차순 정렬
	 *  
	 * ==========================================================================================
	 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Prompt p = new Prompt();
		p.run();
	}

}

class Prompt {
	
	void run() throws IOException {
		int[] intArr = getIntArr(3); // 사용자로부터 정수들을 입력받아 배열에 저장한다.
		Arrays.sort(intArr); // 오름차순 정렬
		printArr(intArr); // 배열 출력
	}
	
	// 사용자로부터 입력받은 값을 구분자로 분리
	int[] getIntArr(int countOfNumbers) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		br.close();
		
		StringTokenizer st = new StringTokenizer(input, " ");
		int[] intArr = new int[countOfNumbers];
		
		for (int i=0; i<intArr.length; i++) {
			intArr[i] = Integer.parseInt(st.nextToken());
		}
		return intArr;
	}
	
	// 지정 배열의 요소를 한 줄에 구분자를 통해 출력한다.
	private void printArr(int[] intArr, char delim) {
		StringBuilder sb = new StringBuilder();
		for (int i: intArr) {
			sb.append(i).append(delim);
		}
		System.out.print(sb.toString());
	}
	
	// 구분자를 지정하지 않을 경우 공백으로 나눠서 출력
	private void printArr(int[] intArr) {
		this.printArr(intArr,' ');
	}
}
