package boj_15552;

	/* ===================================================
	 * BOJ(백준) 3단계 - for문
	 * 
	 * <<boj_15552>>
	 * 빠른 A+B (BufferedReader, BufferedWriter)
	 * https://www.acmicpc.net/problem/15552
	 * 
	 * 본격적으로 for문 문제를 풀기 전에 주의해야 할 점이 있다. 입출력 방식이 느리면 여러 줄을 입력받거나 출력할 때 시간초과가 날 수 있다는 점이다.
	 *
	 * C++을 사용하고 있고 cin/cout을 사용하고자 한다면, cin.tie(NULL)과 sync_with_stdio(false)를 둘 다 적용해 주고, endl 대신 개행문자(\n)를 쓰자. 단, 이렇게 하면 더 이상 scanf/printf/puts/getchar/putchar 등 C의 입출력 방식을 사용하면 안 된다.
	 * 
	 * Java를 사용하고 있다면, Scanner와 System.out.println 대신 BufferedReader와 BufferedWriter를 사용할 수 있다.
	 * BufferedWriter.flush는 맨 마지막에 한 번만 하면 된다.
	 * 
	 * Python을 사용하고 있다면, input 대신 sys.stdin.readline을 사용할 수 있다. 단, 이때는 맨 끝의 개행문자까지 같이 입력받기 때문에 문자열을 저장하고 싶을 경우 .rstrip()을 추가로 해 주는 것이 좋다.
	 * 
	 * 또한 입력과 출력 스트림은 별개이므로, 테스트케이스를 전부 입력받아서 저장한 뒤 전부 출력할 필요는 없다. 테스트케이스를 하나 받은 뒤 하나 출력해도 된다.
	 * 자세한 설명 및 다른 언어의 경우는 이 글에 설명되어 있다.
	 * 이 블로그 글에서 BOJ의 기타 여러 가지 팁을 볼 수 있다.
	 * 
	 * 입력>
	 * 첫 줄에 테스트케이스의 개수 T가 주어진다. T는 최대 1,000,000이다.
	 * 다음 T줄에는 각각 두 정수 A와 B가 주어진다. A와 B는 1 이상, 1,000 이하이다.
	 * 
	 * 출력>
	 * 각 테스트케이스마다 A+B를 한 줄에 하나씩 순서대로 출력한다.
	 * 
	 * (예제 입력)
	 *  5
	 *  1 1
	 *  12 34
	 *  5 500
	 *  40 60
	 *  1000 1000
	 *
	 * (예제 출력)
	 *  2
	 *  46
	 *  505
	 *  100
	 *  2000
	 * 
	 * ===================================================
	 * 
	 * [필요 지식]
	 * 
	 * 1. BufferedReader, BufferedWriter
	 * 
	 * ===================================================
	 * 
	 * 1. BufferedReader, BufferedWriter
	 *  - 속도가 Scanner보다 빠름
	 *    Scanner를 사용해 문제를 풀었을 경우 시간 초과에 걸려서 문제를 풀 수 없음.
	 *    
	 *    현재는 입출력 단원을 공부하지 않았기 때문에
	 *    구글링으로 줏어들은 BufferedReader, BufferedWriter를 억지로 사용했지만 추후 이 부분은 공부가 필요할 듯 하다.
	 *  
	 * ===================================================
	 * 
	 */



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nmbOfTestCase = Integer.parseInt(br.readLine());
		
		BufferedWriter bwr = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=0; i<nmbOfTestCase; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," "); // 공백을 구분자로 한 StringTokenizer
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int sum = a+b;
			bwr.write(String.valueOf(sum)+"\n"); // 버퍼에 입력
		}
		
		br.close(); // 입력자원 반환
		
		bwr.flush(); // 버퍼에 저장된 것들을 전부 출력
		bwr.close(); // 출력자원 반환
	}

}
