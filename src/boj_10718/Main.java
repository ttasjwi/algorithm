package boj_10718;

public class Main {
	/* 요구사항
	 * https://www.acmicpc.net/problem/10718
	 * 
	 * 두 줄에 걸쳐 "강한친구 대한육군"을 한 줄에 한 번씩 출력한다.
	 */
	
	public static void main(String[] args) {
		String str = "강한친구 대한육군";
		Printter.printStr(str, 2);
	}

	private static class Printter {
		static void printStr(String str, int count) {
			for (int i=0; i<count; i++) System.out.println(str);
			return;
		}
	}
}
