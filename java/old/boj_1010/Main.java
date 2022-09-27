package boj_1010;

	/* ==========================================================================================
	 * 백준 - Silver5
	 * 
	 * [Silver5] boj_1010 다리 놓기 (순열과 조합)
	 * https://www.acmicpc.net/problem/1010	
	 * 
	 *  재원이는 한 도시의 시장이 되었다.
	 *  이 도시에는 도시를 동쪽과 서쪽으로 나누는 큰 일직선 모양의 강이 흐르고 있다.
	 *  하지만 재원이는 다리가 없어서 시민들이 강을 건너는데 큰 불편을 겪고 있음을 알고 다리를 짓기로 결심하였다.
	 *  강 주변에서 다리를 짓기에 적합한 곳을 사이트라고 한다.
	 *  
	 *  재원이는 강 주변을 면밀히 조사해 본 결과 강의 서쪽에는 N개의 사이트가 있고 동쪽에는 M개의 사이트가 있다는 것을 알았다. (N ≤ M)
	 *  재원이는 서쪽의 사이트와 동쪽의 사이트를 다리로 연결하려고 한다. (이때 한 사이트에는 최대 한 개의 다리만 연결될 수 있다.)
	 *  재원이는 다리를 최대한 많이 지으려고 하기 때문에 서쪽의 사이트 개수만큼 (N개) 다리를 지으려고 한다.
	 *  다리끼리는 서로 겹쳐질 수 없다고 할 때 다리를 지을 수 있는 경우의 수를 구하는 프로그램을 작성하라.
	 *  
	 * 
	 *  (입력)
	 *   입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다.
	 *   그 다음 줄부터 각각의 테스트케이스에 대해 강의 서쪽과 동쪽에 있는 사이트의 개수 정수 N, M (0 < N ≤ M < 30)이 주어진다.
	 *  
	 *  (출력)
	 *   각 테스트 케이스에 대해 주어진 조건하에 다리를 지을 수 있는 경우의 수를 출력한다.
	 *
	 *  (예제 입력)
	 *   3
	 *   2 2
	 *   1 5
	 *   13 29
	 *  
	 *  (예제 출력)
	 *   1
	 *   5
	 *   67863915
	 *  
	 * ==========================================================================================
	 * 
	 *  필요 지식
	 *   1. 순열과 조합
	 *   
	 * ==========================================================================================
	 * 
	 *  1. 순열과 조합
	 *   1) 순열
	 *    nPr : 서로 다른 n개의 요소를 r개의 서로 다른 자리에 배치하는 경우의 수
	 *    n!  : 서로 다른 n개의 요소를 n개의 서로 다른 자리에 배치하는 경우의 수
	 *  
	 *   2) 조합
	 *    nCr : 서로 다른 n개의 요소 중 r개를 선택하는 경우의 수
	 *    nC0 = 1, nCn = 1, nC1 = n, nCn-1 = n
	 *  
	 * ==========================================================================================
	 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		
		// 테스트 케이스의 갯수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int nmbOfTestCase = Integer.parseInt(br.readLine());
		
		
		// 테스트의 케이스의 개수만큼 라인단위로 입력받아 각각의 경우의 수를 반환
		for (int i=0; i<nmbOfTestCase; i++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input," ");
			
			int nmbOfWestSite = Integer.parseInt(st.nextToken());
			int nmbOfEastSite = Integer.parseInt(st.nextToken());
			
			BigInteger nmbOfCase = getNmbOfCase(nmbOfWestSite, nmbOfEastSite);
			bwr.write(nmbOfCase.toString());
			bwr.newLine();
		}
		
		br.close();
		bwr.flush();
		bwr.close();
	}
	
	// 다리를 지을 수 있는 경우의 수
	private static BigInteger getNmbOfCase(int nmbOfWestSite, int nmbOfEastSite) {
		return Calculator.combination(nmbOfEastSite, nmbOfWestSite); // 동쪽의 사이트들 중에서 서쪽의 사이트의 갯수만큼 선택하는 경우의 수와 같음 
	}
	
}

class Calculator {
	
	// 조합 nCr
	static BigInteger combination (int n, int r) {
		return factorial(n).divide(factorial(r).multiply(factorial(n-r))); // nCr = n!/r!(n-r)!
	}
	
	// n!
	private static BigInteger factorial(int n) {
		if (n==0) return BigInteger.ONE;
		else return BigInteger.valueOf(n).multiply(factorial(n-1));
	}
}