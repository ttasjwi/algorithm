package boj_10872;

	/* ===================================================
	 * BOJ(백준) 10단계 - 재귀
	 * 
	 * <<boj_10872>>
	 *  팩토리얼 (재귀 메서드)
	 *  https://www.acmicpc.net/problem/10872
	 *  
	 *  0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
	 *  
	 *  (입력)
	 *   첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.
	 *  
	 *  (출력)
	 *   첫째 줄에 N!을 출력한다.
	 * 
	 *   예제 입력1>
	 *   10
	 *   
	 *   예제 출력1>
	 *   3628800
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
	


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력
		int number = readIntLine();
		
		// 연산
		int result = factorial(number);
		
		// 출력
		printInt(result);
	}
	
	// 화면에서 라인으로 값을 입력받아 int로 반환
	private static int readIntLine() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		br.close();
		return number;
	}
	
	// 팩토리얼 값을 반환
	private static int factorial(int number) {  
		if (number == 0) return 1; // 무한 재귀를 막기 위해, 끝을 지정해야함
		else return number * factorial(number-1);
	}
	
	// 화면에서 라인으로 int 타입의 값을 출력함
	private static void printInt(int result) throws IOException {
		BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));
		bwr.write(result+"");
		bwr.flush();
		bwr.close();
	}
	
}
