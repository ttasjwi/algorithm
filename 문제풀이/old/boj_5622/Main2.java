package boj_5622;

	/* ===================================================
	 * BOJ(백준) 7단계 - 문자열
	 * 
	 * <<boj_5622>>
	 *  문자를 다이얼넘버로 환산 (풀이 2 : toCharArray로 문자배열 분리 후, 각 문자의 범위에 따라 dialTime 합산)
	 *  https://www.acmicpc.net/problem/5622
	 *  
	 *  전화를 걸고 싶은 번호가 있다면, 숫자를 하나를 누른 다음에 금속 핀이 있는 곳 까지 시계방향으로 돌려야 한다.
	 *  숫자를 하나 누르면 다이얼이 처음 위치로 돌아가고, 다음 숫자를 누르려면 다이얼을 처음 위치에서 다시 돌려야 한다.
	 *  
	 *  숫자 1을 걸려면 총 2초가 필요하다.
	 *  1보다 큰 수를 거는데 걸리는 시간은 이보다 더 걸리며, 한 칸 옆에 있는 숫자를 걸기 위해선 1초씩 더 걸린다.
	 *  상근이의 할머니는 전화 번호를 각 숫자에 해당하는 문자로 외운다.
	 *  
	 *  즉, 어떤 단어를 걸 때, 각 알파벳에 해당하는 숫자를 걸면 된다. 예를 들어, UNUCIC는 868242와 같다.
	 *  할머니가 외운 단어가 주어졌을 때, 이 전화를 걸기 위해서 필요한 최소 시간을 구하는 프로그램을 작성하시오.
	 *  
	 *  (입력)
	 *   첫째 줄에 알파벳 대문자로 이루어진 단어가 주어진다. 단어의 길이는 2보다 크거나 같고, 15보다 작거나 같다.
	 *  
	 *  (출력)
	 *   첫째 줄에 다이얼을 걸기 위해서 필요한 최소 시간을 출력한다.
	 * 
	 *   예제 입력1> WA
	 *   예제 출력1> 13
	 *  
	 *   예제 입력2> UNUCIC
	 *   예제 출력2> 36
	 *  
	 * ===================================================
	 * 
	 * 필요지식
	 * 
	 *  1. String의 메서드 toCharArray()
	 *  
	 * ===================================================
	 * 
	 *  1. String의 메서드 toCharArray()
	 *   - 문자열을 문자들로 쪼개서 char[]로 반환
	 *   
	 * ========================================================================  
	 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main2 {

	public static void main(String[] args) throws IOException {
		
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String dialWord = br.readLine();
		br.close();
		
		// 계산
		int dialTime = getDialTime(dialWord); // 입력받은 문자열로 dialTime(소요시간) 반환
		
		// 출력
		BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));
		bwr.write(dialTime+"");
		bwr.flush();
		bwr.close();
	}

	private static int getDialTime(String dialWord) { // dialWord의 문자 하나하나에 접근하여 문자의 범위에 따라 dialTime을 증가
		
		int dialTime = 0; // 총 소요시간
		char[] wordSplit = dialWord.toCharArray();
		
 		for (int i=0; i<wordSplit.length; i++) {
 			
 			char ch = wordSplit[i]; // dialTime의 문자 하나하나에 순차적으로 접근
 			
 			if ('A' <= ch && ch <= 'O') { // 문자의 범위에 따라 dialTime 값을 합산
 				dialTime += (ch-'A')/3 + 3;
 			} else if ('P' <= ch && ch <= 'S') {
 				dialTime += 8;
 			} else if ('T' <= ch && ch <= 'V') {
 				dialTime += 9;
 			} else {
 				dialTime += 10;
 			}
 		}
 			
		return dialTime;
	}

}
