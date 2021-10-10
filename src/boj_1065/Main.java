package boj_1065;

import java.util.*;

	/* ===================================================
	 * BOJ(백준) 6단계 - 함수
	 * 
	 * <<boj_1065>>
	 *  범위를 입력받고 범위내의 한수(각 자리 숫자가 등차수열을 이룸)의 개수 반환하기
	 *  https://www.acmicpc.net/problem/1065
	 * 
	 *  어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다.
	 *  등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
	 *  N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. 
	 *  
	 *  입력>
	 *  첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.
	 *  
	 *  출력>
	 *  첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.
	 *  
	 *  (예제 입력1) 110
	 *  (예제 출력1) 99
	 *  
	 *  (예제 입력2) 1
	 *  (예제 출력2) 1
	 *  
	 *  (예제 입력3) 210
	 *  (예제 출력3) 105
	 *  
	 *  (예제 입력4) 1000
	 *  (예제 출력4) 144
	 *   
	 * ===================================================
	 * 
	 * [필요 지식]
	 * 
	 * 1. 클래스와 객체
	 * 2. 메서드
	 * 
	 * ===================================================
	 * 
	 * 1. 클래스와 객체
	 * 
	 *  1) 클래스
	 *   - 객체를 정의해둔 설계도 -> 객체를 사용하기 위해서
	 *   - 데이터 + 함수 -> 서로 관련된 여러 기능, 속성을 하나로 저장할 수 있는 공간
	 *   - 사용자 정의 타입 -> 사용자가 원하는 타입을 직접 만들 수 있음
	 *   
	 *  2) 객체 (iv 묶음)
	 *   - 실제로 존재하는 것. 용도는 기능과 속성에 따라 다름
	 *   
	 *  3) 클래스(설계도) -> 인스턴스화 -> 인스턴스(제품)
	 *  
	 *  4) 객체 생성 및 저장 : 클래스명 참조변수명 = new 클래스명(~~~~);
	 *  
	 *  5) 객체배열(참조변수의 배열) : 클래스명[i] <- 하나하나가 클래스들의 참조변수
	 *  
	 * ===================================================
	 * 
	 * 2. 메서드
	 * 
	 *  1) 정의 : 문장들을 작업단위로 이름 붙인 것
	 *  2) 역할 : 값(인수)을 입력받아서 처리하고, 결과를 반환(출력)
	 *  3) 메서드의 장점
	 *   - 중복코드를 줄일 수 있음
	 *   - (한 곳에서 수행하기 때문에) 관리가 쉽다.
	 *   - 코드 재사용 가능
	 *   - 코드가 간결해서 이해하기 쉬움
	 *  
	 *  4) 메서드 작성
	 *   - 반복되는 여러 문장을 메서드로 작성
	 *   - 하나의 메서드는 한가지 기능만 수행하도록 작성
	 *  
	 *  5) 메서드의 구조 = 선언부(머리) + 구현부(몸통)
	 *         선언부 : 제어자 + 반환타입 + 메서드명 (데이터타입 변수명, 데이터타입 변수명, ...)
	 *         구현부 : {/ 메서드 호출시 실행될 코드};
	 *  6) 메서드 호출 : 참조변수. 메서드 이름(데이터1, 데이터2, ...)
	 *  7) 메서드 실행의 흐름
	 *       인스턴스 생성 -> 메서드 호출 -> 메서드 내 코드 수행 -> 호출한 곳으로 반환       
	 * 
	 * ===================================================
	 */

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int range = scanner.nextInt(); // 범위 지정 : 1부터 range까지
		scanner.close();
		
		int hansuCount = getHansuCount(range); // 범위 내의 한수의 개수
		System.out.println(hansuCount);
	}
	
	private static int getHansuCount (int range) { // 1부터 range까지의 범위 내에서 한수의 개수를 반환
		int hansuCount = 0;
		for (int i=1; i<=range; i++) {
			if (isHansu(i)) hansuCount ++; // 한수인지 판단하여, 한수이면 hansuCount 증가
		}
		return hansuCount;
	}
	
	private static boolean isHansu(int number) {
		if (1<=number&&number<=99) return true; // 1부터 99까지는 한수 취급
		
		int[] split = getSplit(number);
		int common_dff = split[1]-split[0]; // 공차
		
		for (int i=1; i<split.length; i++) {
			if(common_dff != split[i]-split[i-1]) return false; // 계차들을 순차적으로 비교했을 때 공차와 다른 경우가 있을 경우 등차수열이 아님
		}
		
		return true;
	}

	private static int[] getSplit(int number) { // 정수를 입력받고 각 자리 숫자를 분리하여 배열에 저장
		final int DIVISOR = 10;
		int numberLength = (int)Math.log10(number)+1; // log10(number) + 1 : 자리의 갯수
		
		int[] numberSplit = new int[numberLength];
		
		for (int i=0; i<numberSplit.length; i++) {
			numberSplit[i] = number%DIVISOR; // 정수를 10으로 나눈 나머지는 끝자리 숫자
			number = number/DIVISOR; // 끝자리를 없앰
		}
		
		return numberSplit;
	}
}
