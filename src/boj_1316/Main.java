package boj_1316;

	/* ===================================================
	 * BOJ(백준) 7단계 - 문자열
	 * 
	 * <<boj_1316>>
	 *  그룹 단어 체크 (Set 활용)
	 *  https://www.acmicpc.net/problem/1316
	 *  
	 *  그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
	 *  예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고,
	 *  kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만,
	 *  aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
	 *  
	 *  단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
	 *  
	 *  (입력)
	 *   첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다.
	 *   둘째 줄부터 N개의 줄에 단어가 들어온다.
	 *   단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
	 *  
	 *  (출력)
	 *   첫째 줄에 그룹 단어의 개수를 출력한다.
	 * 
	 *   예제 입력1>
	 *   3
	 *   happy
	 *   new
	 *   year
	 *   
	 *   예제 출력1>
	 *   3
	 *  
	 *   예제 입력2>
	 *   4
	 *   aba
	 *   abab
	 *   abcabc
	 *   a
	 *   
	 *   예제 출력2>
	 *   1
	 *  
	 * ===================================================
	 * 
	 * <필요지식>
	 * 
	 *  1. Set
	 *  
	 * ===================================================
	 * 
	 *  1. Set
	 *   - 중복을 허용하지 않고, 순서가 없다.
	 *     
	 * ========================================================================  
	 */



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		// 입력
		String[] srcArr = getSrcArr();
		
		// 계산
		int nmbOfGroupWord = getNmbOfGroupWord(srcArr);
		
		//출력
		BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));
		bwr.write(nmbOfGroupWord+"");
		bwr.flush();
		bwr.close();
		
	}
	
	// 지정 갯수만큼 단어를 입력받고 배열에 저장해서 반환
	private static String[] getSrcArr() throws IOException { 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int nmbOfSrc = Integer.parseInt(br.readLine()); // 입력받을 단어의 갯수
		String[] srcArr = new String[nmbOfSrc]; // 입력받을 단어를 저장할 배열
		
		for (int i=0; i<srcArr.length; i++) {
			srcArr[i] = br.readLine(); // 읽어온 문자열을 배열에 저장
		}
		
		br.close();
		
		return srcArr; // 저장 배열을 반환
	}
	
	// 지정 단어 배열에 속한 그룹단어의 갯수를 반환
	private static int getNmbOfGroupWord(String[] srcArr) { 
		int nmbOfGroupWord = 0;
		
		for (String src : srcArr) {
			if (isGroupWord(src)) nmbOfGroupWord ++;
		}
		
		return nmbOfGroupWord;
	}
	
	// 그룹단어인가?
	private static boolean isGroupWord(String src) {
		int nmbOfChar = getNmbOfChar(src); // 서로 다른 문자의 종류
		int nmbOfChange = getNmbOfChange(src); // 문자의 변화 횟수
		
		return nmbOfChar == nmbOfChange+1; // 서로 다른 문자의 갯수와 문자의 변화 횟수 + 1 이 같으면 그룹단어
	}
	
	// 서로 다른 문자의 갯수
	private static int getNmbOfChar(String src) {
		
		Set<Character> charSet = new HashSet<>(); // 문자열들에 속한 문자들을 저장할 Set
		
		for(int i=0; i< src.length(); i++) {
			charSet.add(src.charAt(i)); // charSet에 문자를 저장
		}
		
		int nmbOfChar = charSet.size(); // 서로 다른 문자의 갯수
		return nmbOfChar;
	}

	// 문자의 변화 횟수
	private static int getNmbOfChange(String src) {
		int nmbOfChange = 0; // 문자가 변화 횟수
		if (src.length() == 1) return nmbOfChange; // 한 글자면 문자의 변화가 없음
		
		for (int i=1; i < src.length(); i++) {
			if(isChanged(src, i)) nmbOfChange ++;
		}
		return nmbOfChange;
	}

	// 이전 인덱스의 문자와 달라졌는가?
	private static boolean isChanged(String src, int index) {
		return src.charAt(index) != src.charAt(index-1);
	}

}