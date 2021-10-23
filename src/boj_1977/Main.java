package boj_1977;

	/* ==========================================================================================
	 * 백준 - Bronze1
	 * 
	 * [Bronze1] boj_1977 입력 범위 내에서 완전제곱수의 합과 최솟값 반환하기 (제곱근 이용)
	 * https://www.acmicpc.net/problem/1977
	 * 
	 *  M과 N이 주어질 때 M이상 N이하의 자연수 중 완전제곱수인 것을 모두 골라 그 합을 구하고 그 중 최솟값을 찾는 프로그램을 작성하시오.
	 *  예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 완전제곱수는 64, 81, 100 이렇게 총 3개가 있으므로
	 *  그 합은 245가 되고 이 중 최솟값은 64가 된다.
	 * 
	 *  (입력)
	 *  첫째 줄에 M이, 둘째 줄에 N이 주어진다. M과 N은 10000이하의 자연수이며 M은 N보다 같거나 작다.
	 *  
	 *  (출력)
	 *  M이상 N이하의 자연수 중 완전제곱수인 것을 모두 찾아 첫째 줄에 그 합을,
	 *  둘째 줄에 그 중 최솟값을 출력한다. 단, M이상 N이하의 자연수 중 완전제곱수가 없을 경우는 첫째 줄에 -1을 출력한다.
	 * 
	 *  (예제 입력 1)
	 *   60
	 *   100
	 *   
	 *  (예제 출력 1)
	 *   245
	 *   64
	 *   
	 *  (예제 입력 2)
	 *   75
	 *   80
	 *   
	 *  (예제 출력 2)
	 *   -1
	 *  
	 * ==========================================================================================
	 * 
	 *  필요 지식
	 *   1. Math.pow
	 *    Math.pow(double a, double b) : a^b를 double로 반환
	 *   
	 * ==========================================================================================
	 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

	public static void main(String[] args) throws IOException {
		Prompt p = new Prompt();
		p.run();
	}
}

class Prompt {
	
	private int minRange; // 완전제곱수를 찾는 범위의 첫번째값
	private int maxRange; // 완전제곱수를 찾는 범위의 끝값
	
	private int sumOfPerfectSquare = 0; // 지정 범위에서 완전 제곱수의 합
	private int minOfPerfectSquare = -1; // 지정 범위에서 완전 제곱수들 중 최솟값
	
	
	void run() throws IOException {
		input(); // 사용자로부터 입력을 받는다.
		getResults(); // 입력받은 인자값을 기반으로 지정범위 내에서 완전제곱수들을 찾고, 그들의 합과 최솟값을 계산한다.
		printResults(); // 결과(완전제곱수의 합, 최솟값)를 반환한다.
		
		return;
	}
	
	private boolean hasPerfectSquare() {
		return minOfPerfectSquare != -1;
	}
	
	// 사용자로부터 입력을 받는다.
	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		minRange = Integer.parseInt(br.readLine());
		maxRange = Integer.parseInt(br.readLine());
		
		br.close();
		return;
	}
	
	// 입력받은 인자값을 기반으로 지정범위 내에서 완전제곱수들을 찾고, 그들의 합과 최솟값을 계산한다.
	private void getResults() {
		for (int i=maxRange; i>=minRange; i--) {
			if (MyMath.isPerfectSquare(i)) {
				sumOfPerfectSquare += i;
				minOfPerfectSquare = i;
			}
		}
		return;
	}
	
	private void printResults() throws IOException {
		BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		if (hasPerfectSquare()) {
			bwr.write(String.valueOf(sumOfPerfectSquare));
			bwr.newLine();
		}
		bwr.write(String.valueOf(minOfPerfectSquare));
		bwr.flush();
		bwr.close();
		return;
	}
}

class MyMath {
	
	static boolean isPerfectSquare(int number) {// 지정값이 완전제곱수인지 여부를 반환한다.
		double squareRoot = getSquareRoot(number);
		return isInteger(squareRoot);
	}
	
	static double getSquareRoot(int number) { // 지정 정수값의 양의 제곱근을 반환한다.
		double squareRoot = Math.pow(number, 0.5);
		return squareRoot;
	}
	
	static boolean isInteger(double value) { // 지정 값이 정수인지 아닌지를 boolean으로 반환한다.
		return Math.floor(value) == value; // 지정 값을 소숫점 첫째자리에서 버림했을 때, 그 값이 지정값과 같으면 정수
	}
	
}