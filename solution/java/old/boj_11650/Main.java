package boj_11650;

	/* ==========================================================================================
	 * 백준 - Silver5
	 * 
	 * [Silver5] boj_11650 좌표 정렬하기 (정렬)
	 * https://www.acmicpc.net/problem/11650
	 * 
	 *  2차원 평면 위의 점 N개가 주어진다.
	 *  좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
	 * 
	 *  (입력)
	 *   첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다.
	 *   둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000)
	 *   좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
	 *  
	 *  (출력)
	 *   첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
	 *
	 *  (예제 입력)
	 *   5
	 *   3 4
	 *   1 1
	 *   1 -1
	 *   2 2
	 *   3 3
	 *  
	 *  (예제 출력)
	 *   1 -1
	 *   1 1
	 *   2 2
	 *   3 3
	 *   3 4
	 *   
	 * ==========================================================================================
	 * 
	 *  필요 지식
	 *   1. 정렬
	 *   
	 * ==========================================================================================
	 * 
	 *  1. 정렬
	 *   
	 *   Comparable구현 또는 Comparator 구현을 통한 정렬법
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
		Prompt p = new Prompt();
		p.run(); // 실행
	}
	
}

class Prompt {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));
	
	void run() throws IOException {
		
		// 테스트케이스의 수
		int nmbOfTestCase = Integer.parseInt(br.readLine());
		
		// 테스트케이스만큼 입력받아서 Point 객체를 생성 후 Set으로 반환
		Set<Point> pointSet = getPointTreeSet(nmbOfTestCase);
		
		// Set의 모든 요소를 줄을 바꿔가며 출력
		printlnElements(pointSet);
	}

	// 지정 컬렉션의 모든 요소를 줄을 바꿔가며 출력
	private <E> void printlnElements(Collection<E> c) throws IOException {
		Iterator<E> ir = c.iterator();

		while (ir.hasNext()) {
			E element = ir.next();
			bwr.write(element.toString());
			bwr.newLine();
		}
		bwr.flush();
	}
	
	// 테스트 케이스의 갯수만큼 좌표를 입력받아 Point 객체를 생성 후, TreeSet으로 반환
	private TreeSet<Point> getPointTreeSet(int nmbOfTestCase) throws IOException {
	
		TreeSet<Point> pointSet = new TreeSet<>();
		
		for (int i=0; i<nmbOfTestCase; i++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input, " ");
			
			int x = Integer.parseInt(st.nextToken()); 
			int y = Integer.parseInt(st.nextToken());
			
			pointSet.add(new Point(x, y));
		}
		return pointSet;
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
		if (this.x != other.x) return this.x -other.x; // x좌표가 앞서는 순
		return this.y-other.y; // x좌표가 같을 경우 y좌표 앞서는 순
	}
	
	@Override
	public String toString() {
		return this.x+" "+this.y;
	}
}