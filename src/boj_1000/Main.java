package boj_1000;
import java.util.Scanner;

	/* ===================================================
	 * BOJ(백준) 1단계 : 입출력과 사칙연산
	 * 
	 * <boj_1000>
	 * 
	 * https://www.acmicpc.net/problem/1000
	 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
	 * ===================================================
	 * 
	 * [Scanner 클래스]
	 *	Scanner(System.in) : 사용자의 입력으로부터 값을 버퍼에 저장
	 * 
	 * [Scanner(System.in) 사용시 주의할 점]
	 * 	1. 사용자의 입력
	 * 	2. 사용자가 입력 한값을 버퍼에 저장. 이 때 공백, 탭문자, 개행자(\n) 등도 버퍼에 저장된다.
	 * 	3. next(), nextInt() 메서드는
	 *     버퍼에서 다음 공백, 탭문자, 개행자를 기점으로 앞부분까지만 가져와서(버퍼에서 해당부분은 지워짐) 반환한다.
	 *  4. nextLine() 메서드는 다음 개행자(\n)까지 가져와서(버퍼에서 해당부분은 지워짐)
	 *    개행자 앞부분까지를 반환한다.
	 *    
	 * 	5. 이런 점에서 next(), nextInt() 등에 이어서 nextLine() 등을 같이 쓸 때는 주의해야하는데,
	 *    버퍼를 nextLine()을 한번 사용해서 버퍼를 비우도록 해야함.
	 * 
	 * 	6. 타입이 맞지 않는 입력값을 받았을 경우 inputMismatchException이 발생하므로 예외처리를 하는 것이 좋다.
	 * 
	 */

public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//Scanner(System.in) : 사용자의 입력값을 버퍼에 저장하는 Scanner 클래스
		
		int a = scanner.nextInt(); // 버퍼에 저장된 입력값을 공백 앞까지 끊어서 Int타입으로 반환
		int b = scanner.nextInt(); 
		scanner.close();
		
		int sum = a+b;
		
		System.out.println(sum);
		
	}
}