package boj_1000;

import java.util.Scanner;

public class Main {

	private static boolean isValid(int a, int b) {
		return a > 0 && a < 10 && b > 0 && b < 10;
	}
	
	private static int calSum(int a,  int b) {
		return a+b;
	}
	
	private static void printResult (int a, int b) {
		if (!isValid(a,b)) {
			System.out.println("값을 잘못 입력하셨습니다.");
			return;
		}
		int sum = calSum(a,b);
		System.out.println(sum);
		return;
	}
	
	public static void main(String[] args) {
		System.out.println("1~9 중에 정수를 두 개 입력해주세요.");
		Scanner scanner = new Scanner(System.in);

		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		printResult(a,b);
		scanner.close();
	}
}
