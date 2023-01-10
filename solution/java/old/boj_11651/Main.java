package boj_11651;

	/* ==========================================================================================
	 * 백준 - Silver5
	 * 
	 * [Silver5] boj_11651 좌표 정렬하기 (정렬)
	 * https://www.acmicpc.net/problem/11651
	 * 
	 *  2차원 평면 위의 점 N개가 주어진다.
	 *  좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
	 * 
	 *  (입력)
	 *   첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다.
	 *   둘째 줄부터 N개의 줄에는 i번점의 위치 x_i와 y_i가 주어진다.
	 *   (-100,000 ≤ x_i, y_i ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
	 *  
	 *  (출력)
	 *   첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
	 *
	 *  (예제 입력)
	 *   5
	 *   0 4
	 *   1 2
	 *   1 -1
	 *   2 2
	 *   3 3
	 *  
	 *  (예제 출력)
	 *   1 -1
	 *   1 2
	 *   2 2
	 *   3 3
	 *   0 4
	 *   
	 * ==========================================================================================
	 * 
	 *  필요 지식
	 *   1. 정렬
	 *   2. Iterable<T>인터페이스의 default 메서드 forEach
	 *   
	 * ==========================================================================================
	 * 
	 *  1. 정렬
	 *   
	 *   Comparable구현 또는 Comparator 구현을 통한 정렬법
	 *  
	 * ==========================================================================================
	 * 
	 *  2. Iterable<T>인터페이스의 default 메서드 forEach
	 *  
	 *   default void forEach(Consumer<? super T> action)
	 *    - Collection<T> 인터페이스는 Iterable<T> 인터페이스를 상속받았다.
	 *    - forEach를 통해 지정 컬렉션의 각 요소에 접근하여 각각 지정 작업을 수행한다. (return 없음)
	 *  
	 * ==========================================================================================
	 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		Prompt p = new Prompt();
		p.run(); // 실행
	}
	
}

class Prompt {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	boolean isUsed = false;
	
	void run() throws IOException {
		
		if(isUsed) return;
		
		// 테스트케이스의 수
		int nmbOfTestCase = Integer.parseInt(br.readLine());
		
		// 테스트케이스만큼 입력받아서 Point 객체를 생성 후 Set으로 반환
		Set<Point> pointSet = getPointTreeSet(nmbOfTestCase);
		
		// Set의 모든 요소를 줄을 바꿔가며 출력
		printlnElements(pointSet);
		
		isUsed = true;
		return;
	}

	// 테스트 케이스의 갯수만큼 좌표를 입력받아 Point 객체를 생성 후, TreeSet으로 반환
	private TreeSet<Point> getPointTreeSet(int nmbOfTestCase) throws IOException {
	
		TreeSet<Point> pointSet = new TreeSet<>(); // Point의 Comparable 구현에 의한 정렬
		
		for (int i=0; i<nmbOfTestCase; i++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input, " ");
			
			int x = Integer.parseInt(st.nextToken()); 
			int y = Integer.parseInt(st.nextToken());
			
			pointSet.add(new Point(x, y));
		}
		br.close();
		return pointSet;
	}
	
	// 지정 컬렉션의 모든 요소를 줄을 바꿔가며 출력
	private <E> void printlnElements(Collection<E> c) {
		StringBuilder sb = new StringBuilder();
		c.forEach(element -> sb.append(element).append('\n')); // 각 요소를 sb에 줄바꿔가며 추가
		System.out.println(sb);
	}
	
}

class Point implements Comparable<Point>{
	private int x; // x 좌표
	private int y; // y 좌표
	
	Point (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Point other) {
		if (this.y != other.y) return this.y -other.y; // y좌표가 앞서는 순
		return this.x-other.x; // y좌표가 같을 경우 x좌표 앞서는 순
	}
	
	@Override
	public String toString() {
		return this.x+" "+this.y;
	}
}