package boj_2798;

	/* ==========================================================================================
	 * 백준 - Bronze2
	 * 
	 * [Bronze2] boj_2798 블랙잭 (브루트포스 알고리즘)
	 * https://www.acmicpc.net/problem/2798
	 * 
	 *  카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다. 블랙잭은 카지노마다 다양한 규정이 있다.
	 *  한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.
	 *  김정인 버전의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다. 그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 그런 후에 딜러는 숫자 M을 크게 외친다.
	 *  이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
	 *  N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.
	 * 
	 *  (입력)
	 *   첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다.
	 *   둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는 양의 정수이다.
	 *   합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.
	 *  
	 *  (출력)
	 *   첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.
	 *
	 *  (예제 입력)
	 *   5 21
	 *   5 6 7 8 9
	 *  
	 *  (예제 출력)
	 *   21
	 *   
	 * ==========================================================================================
	 * 
	 *  필요 지식
	 *   1. 브루트포스(Brute Force)
	 *   
	 * ==========================================================================================
	 * 
	 *  1. 브루트포스 (Brute Force)
	 *   
	 *   가장 단순무식한 알고리즘
	 *   모든 경우를 생각하고, 모두 수행한다. 반복문을 통한 구현이 용이
	 *   
	 *   구현 난이도 : 쉬움
	 *   단점 : 대부분의 경우 메모리 상으로도, 시간상으로도 손실이 큼.
	 *  
	 * ==========================================================================================
	 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Prompt p = new Prompt();
		p.run();
	}
}

class Prompt {
	
	private int nmbOfCards; // 카드의 수
	private Integer maxSum; // 합의 최댓값
	private int deck[]; // 카드들
	
	private Integer result;
	
	void run() throws IOException {
		input();
		getResult();
		print();
	}
	
	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		nmbOfCards = Integer.parseInt(st.nextToken());
		maxSum = Integer.valueOf(st.nextToken());
		
		deck = new int[nmbOfCards];
		
		st = new StringTokenizer(br.readLine(), " ");
		br.close();
		
		for (int i=0; i<deck.length; i++) {
			deck[i] = Integer.parseInt(st.nextToken());
		}
		
		return;
	}
	
	
	private void getResult() {

		// sum들의 TreeSet
		TreeSet<Integer> sumSet = new TreeSet<>();
		
		// 덱에서 3개의 값을 뽑고 이들의 합을 sumSet에 저장
		for (int i=0; i<deck.length; i++) {

			for (int j=i+1; j<deck.length; j++) {

				for (int k = j+1; k<deck.length; k++) {

					int card1 = deck[i];
					int card2 = deck[j];
					int card3 = deck[k];
					
					int sum = card1 + card2 + card3;
					sumSet.add(sum);
				}
			}
		}
		
		this.result = sumSet.floor(maxSum); // sumSet에서 maxSum 이하의 객체들 중 가장 큰 값의 객체를 찾아 반환. 없으면 null
		return;
	}
	
	// result가 있을 경우 출력
	private void print() {
		if(!(result.equals(null))) System.out.println(result);
		return;
	}
}