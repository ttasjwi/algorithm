package boj_4673;

	/* ===================================================
	 * BOJ(백준) 6단계 - 함수
	 * 
	 * <<boj_4673>>
	 *  d(n) 메서드를 작성하고, '셀프넘버'만 출력하기 (풀이 1 : 셀프넘버인지 여부를 확인하고, 조건에 부합하면 출력)
	 *  https://www.acmicpc.net/problem/4673
	 * 
	 *  셀프 넘버는 1949년 인도 수학자 D.R. Kaprekar가 이름 붙였다. 양의 정수 n에 대해서 d(n)을 n과 n의 각 자리수를 더하는 함수라고 정의하자. 예를 들어, d(75) = 75+7+5 = 87이다.
	 *  양의 정수 n이 주어졌을 때, 이 수를 시작해서 n, d(n), d(d(n)), d(d(d(n))), ...과 같은 무한 수열을 만들 수 있다. 
	 *  
	 *  예를 들어, 33으로 시작한다면 다음 수는 33 + 3 + 3 = 39이고,
	 *  그 다음 수는 39 + 3 + 9 = 51, 다음 수는 51 + 5 + 1 = 57이다.이런식으로 다음과 같은 수열을 만들 수 있다.
	 *  33, 39, 51, 57, 69, 84, 96, 111, 114, 120, 123, 129, 141, ...
	 *  
	 *  n을 d(n)의 생성자라고 한다.
	 *  위의 수열에서 33은 39의 생성자이고, 39는 51의 생성자, 51은 57의 생성자이다.
	 *  생성자가 한 개보다 많은 경우도 있다. 예를 들어, 101은 생성자가 2개(91과 100) 있다. 
	 *  생성자가 없는 숫자를 셀프 넘버라고 한다. 100보다 작은 셀프 넘버는 총 13개가 있다.
	 *  1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, 97
	 *  
	 *  10000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
	 *  
	 *  입력>
	 *  입력은 없다.
	 *  
	 *  출력>
	 *  10,000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 증가하는 순서로 출력한다.
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

class Main1 {
	
	static int d(int number) { // 지정한 수의 값, 그리고 각 자리의 숫자를 합한 값을 합하여 반환	
		
		int result = 0;
		result += number; // 인수의 값 합산
		
		while(number!=0) { // number가 0이 될 때까지 반복
			
			final int DIVISOR = 10; // 나누는 수
			int split_number = number % DIVISOR; // number를 10으로 나눈 나머지는 가장 마지막의 자릿수
			number = number / DIVISOR; // number를 10으로 나눈 몫은 마지막 아닌 자릿수의 숫자들. 이들만 남긴다.

			result += split_number; // 분리된 자릿수를 결과에 합산
			
		}
		
		return result;
	}
	
	static boolean isSelfNumber(int n) { // 지정 숫자가 셀프 넘버인지 확인하는 메서드
		
		if (n==1) return true;
		
		for (int i=1; i<n; i++) { //자기보다 작은 값들 중에 d(i)의 결과값이 자신이 되는 값이 존재하면 selfNumber
			if (d(i)==n) return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		
		final int LIMIT = 10000; // 지정 범위 : 1~10000
		
		for (int number=1; number<=LIMIT; number++) { // 지정범위 내의 정수가 셀프넘버인지 확인 후, 셀프 넘버이면 출력
			if (isSelfNumber(number)) {
				System.out.println(number);
			}
		}
		
	}
}
