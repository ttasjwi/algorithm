package boj_4153;

	/* ==========================================================================================
	 * 백준 - Bronze3
	 * 
	 * [Bronze3] boj_4153 다리 놓기 (피타고라스의 정리)
	 * https://www.acmicpc.net/problem/4153
	 * 
	 *  과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다.
	 *  주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.
	 * 
	 *  (입력)
	 *   입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다.
	 *   각 테스트케이스는 모두 30,000보다 작은 양의 정수로 주어지며, 각 입력은 변의 길이를 의미한다.
	 *  
	 *  (출력)
	 *   각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력한다.
	 *
	 *  (예제 입력)
	 *   6 8 10
	 *   25 52 60
	 *   5 12 13
	 *   0 0 0
	 *  
	 *  (예제 출력)
	 *   right
	 *   wrong
	 *   right
	 *  
	 * ==========================================================================================
	 * 
	 *  필요 지식
	 *   1. 피타고라스의 정리
	 *   
	 * ==========================================================================================
	 * 
	 *  1. 피타고라스의 정리
	 *   삼각형의 세 변의 길이 a,b,c에 대하여
	 *   가장 긴 변의 길이가 c 일 때
	 *   
	 *   c^2 = a^2+b^2 가 성립하면 이 삼각형은 직각삼각형이다.
	 *  
	 * ==========================================================================================
	 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			String line = br.readLine();
			if(isEndCommand(line)) break; // 입력받은 명령이 종료 명령어면 반복문 탈출
			
			String result = getResult(line);
			bwr.write(result+"\n");
		}
		
		br.close();
		bwr.flush();
		bwr.close();
	}
	
	// 입력받은 라인이 종료 명령어인지 판단
	private static boolean isEndCommand(String line) {
		return line.equals("0 0 0");
	}
	
	// 입력받은 라인을 분석하여 직각삼각형이면 "right", 아니면 "wrong"을 반환
	private static String getResult(String line) {
		int[] intArr = getIntArr(line);
		
		if(isRightTriangle(intArr)) return "right";
		else return "wrong";
	}

	// 입력받은 라인을 분석하여 각 변의 길이를 배열로 분리 반환
	private static int[] getIntArr(String line) {
		int[] intArr = new int[3];
		StringTokenizer st = new StringTokenizer(line, " ");
		
		for (int i=0; i<intArr.length; i++) {
			intArr[i] = Integer.parseInt(st.nextToken());
		}
		return intArr;
	}
	
	// 입력받은 길이 배열을 읽고, 직각삼각형인지 여부를 반환
	private static boolean isRightTriangle(int[] lengthArr) {
		
		Arrays.sort(lengthArr); // 배열을 정렬
		
		double a2 = Math.pow(lengthArr[0],2);
		double b2 = Math.pow(lengthArr[1],2);
		double c2 = Math.pow(lengthArr[2],2);
		
		return c2 == a2 + b2; // 피타고라스의 정리
	}
}
