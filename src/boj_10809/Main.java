package boj_10809;

import java.util.Scanner;

	/* ===================================================
	 * BOJ(백준) 7단계 - 문자열
	 * 
	 * <<boj_10809>>
	 *  입력받은 문자열에서 영어 소문자들을 찾아 인덱스 반환하기
	 *  https://www.acmicpc.net/problem/10809
	 *  
	 *  알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서,
	 *  단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
	 *  
	 *  (입력)
	 *   첫째 줄에 단어 S가 주어진다.
	 *   단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
	 *  
	 *  (출력)
	 *   각각의 알파벳에 대해서,
	 *   a가 처음 등장하는 위치, b가 처음 등장하는 위치, ... z가 처음 등장하는 위치를 공백으로 구분해서 출력한다.
	 *   만약, 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다. 단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.
	 * 
	 *  (예제 입력)
	 *   baekjoon
	 *  
	 *  (예제 출력)
	 *   1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
	 *  
	 * ===================================================
	 * 
	 * 필요지식
	 * 
	 *  1. 문자열에서 특정 문자의 인덱스 찾기 
	 * 
	 * ===================================================
	 * 
	 *  1. 문자열에서 특정 문자의 인덱스 찾기
	 *  
	 *   - int indexOf(String str)
	 *   - int indexOf(int ch, int pos) : 주어진 문자가 문자열에 존재하는지 앞에서부터 확인하여 index를 반환. 없으면 -1
	 *   - int lastIndexOf(String str)
	 *   - int lastIndexOf(int ch) : 주어진 문자가 문자열에 존재하는지 뒤에서부터 확인하여 index를 반환. 없으면 -1
	 *   
	 * ===================================================
	 *   
	 */


class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine(); // 문자열을 라인으로 입력받음
		scanner.close();
		
		printLowerCaseIndexes(str); // 입력받은 문자열의 영어 소문자들의 인덱스들을 순서대로 출력
	}
	
	private static void printLowerCaseIndexes(String str) {
		for (char ch = 'a' ; ch <= 'z'; ch ++) {
			System.out.print(str.indexOf(ch)+" "); // ch가 위치한 인덱스를 앞에서부터 찾아서 출력
		}
		return;
	}
}
