package boj_1546;

import java.util.Scanner;

	/* ===================================================
	 * BOJ(백준) 5단계 - 1차원 배열
	 * 
	 * <<boj_1546>>
	 *  점수를 입력받아, 조작한 평균을 반환하기 (반복문을 통한 배열 초기화, 접근)
	 *  https://www.acmicpc.net/problem/1546
	 * 
	 *  세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다. 일단 세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다. 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
	 *  예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.
	 *  세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.
	 *  
	 * 입력>
	 *  첫째 줄에 시험 본 과목의 개수 N이 주어진다.
	 *  이 값은 1000보다 작거나 같다. 둘째 줄에 세준이의 현재 성적이 주어진다. 이 값은 100보다 작거나 같은 음이 아닌 정수이고, 적어도 하나의 값은 0보다 크다.
	 * 
	 * 출력>
	 *  - 첫째 줄에 새로운 평균을 출력한다. 실제 정답과 출력값의 절대오차 또는 상대오차가 10^(-2) 이하이면 정답이다.
	 *  - 10^(-2) 이하의 오차를 허용한다는 말은 정확히 소수 2번째 자리까지 출력하라는 뜻이 아니다. (예제 2)
	 *  
	 * (예제 입력 1) 
	 *   30
	 *   40 80 60
	 *  
	 * (예제 출력 1)
	 *   75.0
	 *   
	 * (예제 입력 2)
	 *  3
	 *  10 20 30
	 *  
	 * (예제 출력 2)
	 *  66.666667
	 * 
	 * (예제 입력 3)
	 *  4
	 *  1 100 100 100
	 * 
	 * (예제 출력 3)
	 *  5
	 *  1 2 4 8 16
	 * 
	 * (예제 입력 4)
	 *  5
	 *  1 2 4 8 16
	 * 
	 * (예제 출력 4)
	 *  38.75
	 * 
	 * (예제 입력 5)
	 *  2
	 *  3 10
	 * 
	 * (예제 출력 5)
	 *  65.0
	 * 
	 * ===================================================
	 * 
	 * [필요 지식]
	 * 
	 * 1. 배열
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
	 */


class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int numberSubjects = scanner.nextInt(); // 입력할 과목의 갯수
		int[] original = new int[numberSubjects]; // 원래 점수
		
		fillArray(scanner, original);
		scanner.close();
		
		int org_Max = getMax(original); // 최댓값 구하기
		int org_total = getTotal(original); // 총점 구하기
		
		double manipulated_Total = (double)org_total/org_Max*100; // 조작한 총점
		double manipulated_Average = manipulated_Total/numberSubjects; // 조작한 평균
		
		System.out.println(manipulated_Average);
	}

	private static void fillArray(Scanner scanner, int[] intArr) { // 값을 입력받아 배열에 저장
		for (int i=0; i<intArr.length; i++) {
			intArr[i] = scanner.nextInt();
		}
	}

	private static int getMax(int[] intArr) { // 지정 배열의 최댓값을 반환
		int max = intArr[0];
		
		for (int i=1; i<intArr.length; i++) {
			if (intArr[i]>max) max = intArr[i];
		}
		return max;
	}
	
	private static int getTotal(int[] intArr) { // 지정 배열의 모든 값의 총합을 반환
		int total = 0;
		for (int i=0; i<intArr.length; i++) {
			total += intArr[i];
		}
		return total;
	}
	
}
