package boj_4344;

import java.util.Scanner;
import java.text.DecimalFormat;

	/* ===================================================
	 * BOJ(백준) 5단계 - 1차원 배열
	 * 
	 * <<boj_4344>>
	 *  정수 배열에서 평균보다 큰 수의 비율을 반환 (배열 접근, 형식화)
	 *  https://www.acmicpc.net/problem/4344
	 * 
	 *  대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.
	 *
	 * 입력>
	 *  첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
	 *  둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고,
	 *  이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
	 * 
	 * 출력>
	 *  각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
	 *  
	 * (예제 입력) 
	 *   5
	 *   5 50 50 70 80 100
	 *   7 100 95 90 80 70 60 50
	 *   3 70 90 80
	 *   3 70 90 81
	 *   9 100 99 98 97 96 95 94 93 91
	 *  
	 * (예제 출력)
	 *   40.000%
	 *   57.143%
	 *   33.333%
	 *   66.667%
	 *   55.556%
	 *   
	 * ===================================================
	 * 
	 * [필요 지식]
	 * 
	 * 1. 배열
	 * 2. DecimalFormat
	 * 
	 * ===================================================
	 * 
	 * 1. 배열
	 *  같은 타입의 여러 변수를 하나의 묶으로 다루는 것
	 *  
	 *   1) 생성
	 *    타입[] 변수이름;
	 *    변수이름 = new 타입[길이];
	 *   
	 *   2) 배열의 각 요소
	 *    배열이름[0], 배열이름[1], 배열이름[2], ... , 배열이름[길이-1] : 배열의 각 요소
	 *    
	 *   3) 배열의 초기화
	 *    배열이름[index] = 값;
	 *  
	 * ===================================================
	 * 
	 * 2. DecimalFormat
	 *  숫자를 형식화하는 클래스
	 *  
	 *  1) 사용법 : pattern을 지정하여 객체 생성 -> .format(값) 으로 포맷하기
	 *   DecimalFormat df = new DecimalFormat(String Format);
	 *   String result = df.format(double number);
	 *   
	 *  2) 주요 패턴
	 *   0 : 십진수 (값이 없으면 0)
	 *   # : 십진수
	 *   . : 소숫점
	 *   - : 음수부호
	 *   , : 단위 구분자
	 *   E0 : 지수
	 *   ; : 패턴 구분자
	 *   % : 퍼센트
	 *   \u2030 : 퍼밀 (퍼센트 * 10)
	 *   \u00A4 : 통화
	 *   ' : escape 문자
	 *   
	 * ===================================================
	 */


public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int numberTestCase = scanner.nextInt();
				
		for (int i=0; i<numberTestCase; i++) {
			int numberStudent = scanner.nextInt(); // 인원수
			printlnOverAverageRate(scanner, numberStudent); // 인원수만큼 값을 입력받아 평균보다 큰 점수의 비율을 출력
		}
	}

	private static void printlnOverAverageRate(Scanner scanner, int numberStudent) {
		int scoreArr[] = getScoreArr(scanner, numberStudent); // 인원수만큼 입력받아 배열에 점수 저장
		
		double average = getArrAverage(scoreArr); // 평균
		double rate = getOverValueRate(scoreArr, average); // 평균 이상인 사람의 비율
		String rateStr = getFormattedRate(rate); // 비율을 형식화
		
		System.out.println(rateStr); // 형식화된 비율을 출력
	}
	
	private static int[] getScoreArr(Scanner scanner, int numberStudent) { // 입력받아서 배열을 채움
		int[] scoreArr = new int[numberStudent];
		
		for (int i=0; i<scoreArr.length; i++) {
			scoreArr[i] = scanner.nextInt();
		}
		return scoreArr;
	}
	
	private static double getArrAverage(int[] intArr) { // 배열의 모든 값들의 평균을 반환
		
		double arrTotal = getArrTotal(intArr); // 배열의 총합을 계산해 저장 (getArrTotal)
		double arrAverage = arrTotal/intArr.length;
		return arrAverage;
	}
	
	private static int getArrTotal(int[] intArr) { // 배열의 모든 값들의 총합을 반환
		int arrTotal = 0;
		
		for (int i=0; i<intArr.length; i++) {
			arrTotal += intArr[i];
		}
		return arrTotal;
	}
	
	private static double getOverValueRate (int[] intArr, double standard) { // 배열에서 기준보다 큰 값인 데이터의 비율을 반환
		
		int count = 0; // 기준값보다 큰 값인 데이터의 개수
		
		for (int i=0; i<intArr.length; i++) {
			if (intArr[i]>standard) count++;
		}

		double overValueRate = (double)count/intArr.length; // 배열의 길이(값의 갯수)로 나눠서 비율을 계산
		return overValueRate;
	}

	private static String getFormattedRate (double rate) {
		final DecimalFormat rateFormat = new DecimalFormat("0.000%"); // 반올림하여 소숫점 셋째자리까지 표현.
		return rateFormat.format(rate);
	}
	
}
