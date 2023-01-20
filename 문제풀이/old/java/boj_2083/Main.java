package boj_2083;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

	/* ==========================================================================================
	 * 백준 - Bronze5
	 * 
	 * [Bronze5] boj_2083 값을 입력받아 회원 분류하기 (조건문, 반복문)
	 * https://www.acmicpc.net/problem/2083
	 * 
	 *  올 골드 럭비 클럽의 회원들은 성인부 또는 청소년부로 분류된다.
	 *  나이가 17세보다 많거나, 몸무게가 80kg 이상이면 성인부이다. 그 밖에는 모두 청소년부이다. 클럽 회원들을 올바르게 분류하라.
	 * 
	 *  (입력)
	 *   각 줄은 이름과 두 자연수로 이루어진다.
	 *   두 자연수는 순서대로 나이와 몸무게를 나타낸다. 입력의 마지막 줄은 # 0 0 이다. 이 입력은 처리하지 않는다.
	 *   이름은 알파벳 대/소문자로만 이루어져 있고, 길이는 10을 넘지 않는다.
	 *  
	 *  (출력)
	 *   입력 받은 각 회원에 대해 이름과 분류를 출력한다. 성인부 회원이면 'Senior', 청소년부 회원이면 'Junior'를 출력한다.
	 * 
	 *  (예제 입력)
	 *   Joe 16 34
	 *   Bill 18 65
	 *   Billy 17 65
	 *   Sam 17 85
	 *   # 0 0
	 *   
	 *  (예제 출력)
	 *   Joe Junior
	 *   Bill Senior
	 *   Billy Junior
	 *   Sam Senior
	 *  
	 * ==========================================================================================
	 * 
	 *  필요 지식
	 *   1. toString() 오버라이드
	 *   
	 * ==========================================================================================
	 * 
	 *   1. toString() 오버라이드
	 *    - toString() 메서드는 Object 클래스의 메서드. 각각의 메서드에서 오버라이드 하여 원하는 문자열을 반환할 수 있다.
	 *    - 출력문에서 객체의 참조변수를 매개변수로 사용할 경우 toString() 메서드가 호출되므로 이를 이용하여 유용하게 문자열을 출력할 수 있다.
	 *    
	 * ==========================================================================================
	 */


public class Main {

	public static void main(String[] args) throws IOException {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			
			// 입력
			String input = br.readLine();
			if (isEndCommand(input)) break;
			
			StringTokenizer st = new StringTokenizer(input, " ");
			
			// 입력값 분리
			String name = st.nextToken();
			int age = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			// 멤버 객체 생성
			Member member = new Member(name, age, weight);
			
			// toString() 호출하여 버퍼에 추가
			bwr.write(member+"\n");
		}
		
		//출력
		br.close();
		bwr.flush();
		bwr.close();
	}
	
	// 입력이 종료 명령인가?
	private static boolean isEndCommand(String input) {
		return input.equals("# 0 0");
	}
	
}

class Member {
	
	private String name; // 이름
	private int age; // 나이
	private int weight; //  몸무게
	
	Member (String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	//멤버 정보를 문자열로 반환
	@Override 
	public String toString() { 
		return name+" "+group();
	}
	
	// 연령, 몸무게를 매개변수로 하여, 그룹을 반환
	private String group() {
		if (isSenior()) return "Senior";
		else return "Junior";
	}
		
	// 나이, 무게를 토대로 성인/청소년 여부를 반환
	private boolean isSenior() {
		return age>17||weight>=80;
	}
	
}
