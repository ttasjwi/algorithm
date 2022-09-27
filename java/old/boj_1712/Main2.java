package boj_1712;

	/* ===================================================
	 * BOJ(백준) 7단계 - 문자열
	 * 
	 * <<boj_1712>>
	 *  손익분기점 (부등식 - 대입(by 반복문))
	 *  https://www.acmicpc.net/problem/1712
	 *  
	 *  월드전자는 노트북을 제조하고 판매하는 회사이다.
	 *  노트북 판매 대수에 상관없이 매년 임대료, 재산세, 보험료, 급여 등 A만원의 고정 비용이 들며,
	 *  한 대의 노트북을 생산하는 데에는 재료비와 인건비 등 총 B만원의 가변 비용이 든다고 한다.
	 *  
	 *  예를 들어 A=1,000, B=70이라고 하자.
	 *  이 경우 노트북을 한 대 생산하는 데는 총 1,070만원이 들며, 열 대 생산하는 데는 총 1,700만원이 든다.
	 *  
	 *  노트북 가격이 C만원으로 책정되었다고 한다.
	 *  일반적으로 생산 대수를 늘려 가다 보면 어느 순간 총 수입(판매비용)이 총 비용(=고정비용+가변비용)보다 많아지게 된다.
	 *  최초로 총 수입이 총 비용보다 많아져 이익이 발생하는 지점을 손익분기점(BREAK-EVEN POINT)이라고 한다.
	 *  A, B, C가 주어졌을 때, 손익분기점을 구하는 프로그램을 작성하시오.
	 *  
	 *  (입력)
	 *   첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 21억 이하의 자연수이다.
	 *  
	 *  (출력)
	 *   첫 번째 줄에 손익분기점 즉 최초로 이익이 발생하는 판매량을 출력한다. 손익분기점이 존재하지 않으면 -1을 출력한다.
	 * 
	 *   예제 입력1>
	 *   1000 70 170
	 *   
	 *   예제 출력1>
	 *   11
	 *  
	 *   예제 입력2>
	 *   3 2 1
	 *   
	 *   예제 출력2>
	 *   -1
	 *   
	 *   예제 입력3>
	 *   2100000000 9 10
	 *   
	 *   예제 출력3>
	 *   2100000001
	 *  
	 * ===================================================
	 * 
	 * <필요지식>
	 *  1. 부등식 풀이
	 *   1) 대입 : 하나하나 적절한 값을 대입하며 값 비교하기 (프로그래밍에서의 반복문)
	 *   2) 부등식의 상등
	 *    - 양변에 같은 값을 더하기 (+,-)
	 *    - 양변에 같은 양수를 곱하기, 나누기 (*, /) : 음수를 곱하면 등호가 반대로 변함
	 *      (주의 : 0으로 나눌 수 없음)
	 *   
	 * ========================================================================  
	 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main2 {
	
	// 메인
	public static void main(String[] args) throws IOException {
		
		// 입력
		String[] inputSplit = getLineInput().split(" +");
		
		// 입력 결과의 값들을 분리
		int fixedCost = Integer.parseInt(inputSplit[0]); // 고정비용 (A)
		int variableCost = Integer.parseInt(inputSplit[1]); // 가변비용 (B)
		int price = Integer.parseInt(inputSplit[2]); // 제품 1개의 가격 (C)
		
		int profit = getProfit(variableCost, price); // 제품 1개를 판매하였을 때 얻게 되는 이익
		
		// 손익분기점 계산
		int brkEvenPoint = getBrkEvenPoint(fixedCost, profit);
		
		// 출력
		printInt(brkEvenPoint);
		
	}
	
	// 제품 1개를 판매하였을 때 얻게되는 이익
	private static int getProfit(int variableCost, int price) {
		return price - variableCost;
	}
	
	// 라인으로 문자열 입력
	private static String getLineInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String lineInput = br.readLine();
		br.close();
		
		return lineInput;
	}
	
	// 손익분기점 계산
	private static int getBrkEvenPoint(int fixedCost, int profit) {
		if (!(profit>0)) return -1; // 판매이익이 양수가 아니면 손익분기점이 존재하지 않음

		int brkEvenPoint = gauss((double)fixedCost/profit) +1; // 부등식 brkEvenPoint > fixedCost/profit 에서의 최소 정숫값
		return brkEvenPoint;
	}
	
	//value 이하의 정수 중 최대 정수 : 수학의 가우스
	private static int gauss(double value) {
		return (int)Math.floor(value);
	}
	
	// int 타입값을 출력
	private static void printInt(int brkEvenPoint) throws IOException {
		BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));
		bwr.write(brkEvenPoint+"");
		bwr.flush();
		bwr.close();
	}
	
}