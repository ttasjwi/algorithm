package boj_8958;

import java.util.Scanner;

	/* ===================================================
	 * BOJ(백준) 5단계 - 1차원 배열
	 * 
	 * <<boj_8958>>
	 *  OX 퀴즈의 결과를 일차원 배열로 입력받아 점수를 계산하는 문제 (반복문을 통한 배열 초기화/접근, 문자열에서 문자 추출)
	 *  https://www.acmicpc.net/problem/8958
	 * 
	 *  "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.
	 *  "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
	 *  OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.
	 *
	 * 입력>
	 *  첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 길이가 0보다 크고 80보다 작은 문자열이 주어진다. 문자열은 O와 X만으로 이루어져 있다.
	 * 
	 * 출력>
	 *  각 테스트 케이스마다 점수를 출력한다.
	 *  
	 * (예제 입력) 
	 *   5
	 *   OOXXOXXOOO
	 *   OOXXOOXXOO
	 *   OXOXOXOXOXOXOX
	 *   OOOOOOOOOO
	 *   OOOOXOOOOXOOOOX
	 *  
	 * (예제 출력)
	 *   10
	 *   9
	 *   7
	 *   55
	 *   30
	 *   
	 * ===================================================
	 * 
	 * [필요 지식]
	 * 
	 * 1. 배열
	 * 2. charAt(char index)
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
	 * 2. charAt(int index)
	 *  : 호출한 문자열의 index번째에 위치한 문자를 반환함
	 * 
	 */


public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
		int numberTestCase = scanner.nextInt(); // 테스트케이스의 개수
		scanner.nextLine(); // 버퍼를 비움
		
		// 라인별로 결과를 입력받고, 이를 Score로 반환
		for (int i=0; i<numberTestCase; i++) printlnScore(scanner.nextLine()); 
		
		scanner.close();
	}

	private static void printlnScore(String result) {
		int score = getTotalScore(result); // 라인단위로 score를 계산하여 저장
		System.out.println(score); // score 출력
	}
	
	private static int getTotalScore(String result) {  // 결과를 매개변수로 하여 총점 반환
		
		int[] scoreArr = getScoreArr(result); // 입력받은 결과의 각 문항별 점수를 배열에 저장
		int totalScore = getArrTotal(scoreArr); // 배열의 모든 요소의 합을 저장
		
		return totalScore; // 총점을 반환
	}
	
	private static int[] getScoreArr(String result) {
		int length = result.length(); // 결과 문자열의 길이 (문항수)
		int[] scoreArr = new int[length];

		for (int i=0; i<length; i++) {
			int bonus = getBonus(scoreArr, i); // 가산점
			if (result.charAt(i)=='O') scoreArr[i] = bonus +1; // 맞았을 경우 점수 저장
		}
		
		return scoreArr;
	}

	private static int getBonus(int[] scoreArr, int i) {
			
			int bonus = 0;
			if (i==0) return bonus; // 0번 인덱스는 bonus 없음
			if (scoreArr[i-1]>0) bonus += scoreArr[i-1]; // 이전 문제의 값이 양수일 경우(이전 문제가 맞았을 경우)
			
			return bonus;
	}

	private static int getArrTotal(int[] intArr) { // 배열의 모든 요소의 총합을 반환
		int arrTotal = 0;
		
		for (int i=0; i<intArr.length; i++) {
			arrTotal += intArr[i];
		}
		return arrTotal;
	}
	
}
