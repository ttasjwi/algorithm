package boj_10869;

class Calculator {
	//boj_10869에 사용
	//사칙연산의 결과를 반환해주는 static 메서드들을 묶어둔 클래스
	
	static int addition(int a, int b) { // 합
		return a+b;
	}
	
	static int subtraction (int a, int b) { // 차
		return a-b;
	}
	
	static int multiplication (int a, int b) { // 곱
		return a*b;
	}
	
	static double division (int a, int b) { // 나눗셈
		return (double)a/b;
	}
	
	static int quotient (int a, int b) { // 몫
		return a/b;
	}
	
	static int remainder (int a, int b) { // 나머지
		return a%b;
	}
}
