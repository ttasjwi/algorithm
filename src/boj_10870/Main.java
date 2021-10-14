package boj_10870;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

	/* ===================================================
	 * BOJ(백준) 10단계 - 재귀
	 * 
	 * <<boj_10870>>
	 *  피보나치 수열 구현하기 (재귀 메서드)
	 *  https://www.acmicpc.net/problem/10870
	 *  
	 *  피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
	 *  이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
	 *  n=17일때 까지 피보나치 수를 써보면 다음과 같다.
	 *  
	 *  0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
	 *  n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
	 *  
	 *  (입력)
	 *   첫째 줄에 n이 주어진다. n은 20보다 작거나 같은 자연수 또는 0이다.
	 *  
	 *  (출력)
	 *   첫째 줄에 n번째 피보나치 수를 출력한다.
	 * 
	 *   예제 입력>
	 *   10
	 *   
	 *   예제 출력>
	 *   55
	 *  
	 * ===================================================
	 * 
	 * <필요지식>
	 * 
	 *  1. 재귀 메서드
	 *  
	 * ===================================================
	 * 
	 *  1. 재귀 메서드
	 *   - 메서드 정의 상에, 자기 자신을 호출하는 것이 정의된 메서드
	 *   - 무한 재귀가 일어나지 않도록 주의해야함. 
	 *     
	 * ========================================================================  
	 */


class Main {

	public static void main(String[] args) throws IOException {
		// 입력
		int number = readIntLine();
		
		// 계산
		int fbncNumber = fbncNumber(number);
		
		// 출력
		printInt(fbncNumber);
	}
	
	// 화면에서 라인으로 값을 입력받아 int로 반환
	private static int readIntLine() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		br.close();
		return number;
	}
	
	// 피보나치 수열의 index번째 항을 반환함
	private static int fbncNumber(int index) {
		if (index == 0) return 0;
		else if (index == 1) return 1;
		else return fbncNumber(index-2) + fbncNumber(index-1);
	}
	
	// 화면에서 라인으로 int 타입의 값을 출력함
	private static void printInt(int number) throws IOException {
		BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));
		bwr.write(number+"");
		bwr.flush();
		bwr.close();
	}
}
