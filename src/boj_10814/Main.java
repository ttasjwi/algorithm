package boj_10814;

	/* ==========================================================================================
	 * 백준 - Silver5
	 * 
	 * [Silver5] boj_10814 회원을 나이가 빠른 순으로, 나이가 같을 경우 등록순서가 빠른 순으로 정렬. (정렬)
	 * https://www.acmicpc.net/problem/10814	
	 * 
	 *  온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다.
	 *  이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.
	 *  
	 * 
	 *  (입력)
	 *   첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)
	 *   둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다.
	 *   나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고,
	 *   이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다. 입력은 가입한 순서로 주어진다.
	 *  
	 *  (출력)
	 *   첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.
	 *
	 *  (예제 입력)
	 *   3
	 *   21 Junkyu
	 *   21 Dohyun
	 *   20 Sunyoung
	 *  
	 *  (예제 출력)
	 *   20 Sunyoung
	 *   21 Junkyu
	 *   21 Dohyun
	 *  
	 * ==========================================================================================
	 * 
	 *  필요 지식
	 *   1. 인터페이스 Comparable<T>
	 *   2. 인터페이스 Comparator<T>
	 *   3. 정렬
	 *   
	 * ==========================================================================================
	 * 
	 *  1. 인터페이스 Comparable<T>
	 *   기본 정렬 기준을 구현하는데 사용
	 *   java.lang에 있음 (별도로 import 필요 없음)
	 *  
	 *   int compareTo(Object o)
	 *   
	 * ==========================================================================================
	 *  
	 *  2. 인터페이스 Comparator<T>
	 *   기본 정렬 기준 외에 다른 기준으로 정렬하고자 할 때 사용
	 *   java.util에 있음
	 *  
	 *   int compare(Object o1, Object o2)
	 *   boolean equals(Object obj)
	 *   
	 * ==========================================================================================
	 * 
	 *  3. 정렬
	 *  - 정렬을 위해서는 정렬 대상이 필요하고 정렬 기준이 필요하다.
	 *  - sort(Object[] arr) : 기본 정렬 기준 Comparable의 구현에 의한 정렬. 비교대상들이 Comparable 인터페이스를 구현해야한다.
	 *  - sort(Object[] arr, Comparator cp) : 별도의 정렬 기준 Comparator의 구현에 의한 정렬. 비교대상들이 Comparator 인터페이스를 구현해야한다.
	 *  - 각각의 정렬 기준에 존재하는 compareTo, compare을 기준으로 하여 두 객체끼리 비교하여  1,0,-1을 반환받고 이를 통한 자리바꿈
	 *  
	 * ==========================================================================================
	 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				 BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));) {
			// 사용자로부터 회원수를 입력받음
			int nmbOfMember = Integer.parseInt(br.readLine());
			
			// 지정 횟수만큼 회원정보를 입력받아, TreeSet에 저장
			TreeSet<Member> memberSet = new TreeSet<>();
			
			for (int i=0; i<nmbOfMember; i++) {
				String input = br.readLine();
				StringTokenizer st = new StringTokenizer(input, " ");
				
				int age = Integer.parseInt(st.nextToken());
				String name = st.nextToken();
				memberSet.add(new Member(age, name));
			}
			
			// memberSet의 toString()을 순차적으로 줄바꿈을 하면서 출력
			Iterator<Member> ir = memberSet.iterator();
			
			while(ir.hasNext()) {
				Member member = ir.next();
				bwr.write(member.toString());
				bwr.newLine();
			}
			
			bwr.flush();
		}
	}
}

class Member implements Comparable<Member> {
	
	private int age; // 나이
	private String name; // 이름
	private int order; // 등록순서
	
	private static int nextOrder = 0; // 다음번에 부여될 order
	
	Member(int age, String name) {
		this.age = age;
		this.name = name;
		this.order = nextOrder++; // 등록순으로 order부여
	}
	
	@Override
	public int compareTo(Member other) {
		if (this.age != other.age) return this.age - other.age;
		else return this.order - other.order;
	}
	
	@Override
	public String toString() {
		return age+" "+name;
	}
}