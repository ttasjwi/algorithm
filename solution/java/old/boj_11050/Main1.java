package boj_11050;

	/* ==========================================================================================
	 * 백준 - Bronze1
	 * 
	 * [Bronze1] boj_11050 이항 계수 (풀이 1 : 조합의 정의 nCr = nPr/r!)
	 * https://www.acmicpc.net/problem/11050
	 * 
	 *  자연수 n과 정수 r이 주어졌을 때 이항 계수 nCr을 구하는 프로그램을 작성하시오.
	 * 
	 *  (입력)
	 *   첫째 줄에 n과 r이 주어진다. (1<=n<=10, 0<=r<=n)
	 *  
	 *  (출력)
	 *   nCr을 출력한다.
	 *
	 *  (예제 입력)
	 *   5 2
	 *  
	 *  (예제 출력)
	 *   10
	 *   
	 * ==========================================================================================
	 * 
	 *  필요 지식
	 *   1. 조합
	 *   
	 * ==========================================================================================
	 * 
	 *  1. 조합
	 *   
	 *   서로 다른 n개의 요소 중 r개를 선택하는 가짓수
	 *   서로 다른 n개를 r개의 구분된 자리에 배치하는 가짓수는 nPr 가지수이고, 그 각각에 대하여 자리의 구분이 없어진다면 r! 만큼 중복된다.
	 *   따라서, nCr = nPr/r! 이다.
	 *   
	 *   nCr = nPr/r! = n!/(n-r)!*r!
	 *  
	 * ==========================================================================================
	 * 
	 *  2. 조합의 귀납적 정의 (재귀 정의)
	 *  
	 *   n개의 요소 중에서 r개를 선택하는 가짓수는
	 *   n개의 요소 중에서 특정 하나를 반드시 포함하고, 나머지 요소 중에서 r-1개를 선택하는 가짓수 C(n-1,r-1)과
	 *   n개의 요소 중에서 특정 하나를 반드시 포함하지 않고, 나머지 요소 중에서 r개를 선택하는 가짓수 C(n-1,r)의 합과 같다.
	 *   
	 *   C(n,r) = C(n-1, r-1) + C(n-1, r)
	 *   
	 * ==========================================================================================   
	 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		br.close();

		StringTokenizer st = new StringTokenizer(input, " ");
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int nCr = MyMath1.combination(n, r); // 조합
		
		System.out.println(nCr);
	}

}

class MyMath1 {
	
	static int combination(int n, int r) {
		
		int numerator = 1; // 분자
		int denominator = 1; // 분모
		
		for (int i=0; i<r; i++) {
			numerator *= (n-i);
			denominator *= (r-i);
		}
		
		return numerator/denominator; // nCr = n*(n-1)*(n-2)...*(n-(r-1))/r*(r-1)*(r-2)*...(r-(r-1))
	}
}
