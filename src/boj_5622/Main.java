package boj_5622;

	/* ===================================================
	 * BOJ(백준) 7단계 - 문자열
	 * 
	 * <<boj_5622>>
	 *  문자를 다이얼넘버로 환산 (풀이 1 : 열거형 활용)
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
	 *  1. 열거형
	 *  2. 열거형에 멤버 추가하기, 열거형 상수의 멤버 반환하기
	 *  
	 * ===================================================
	 * 
	 * 1. 열거형의 정의와 사용
	 *  
	 *  1) 열거형
	 *   - 서로 관련된 상수를 편리하게 선언하기 위한 것.
	 *   - C에서는 타입이 달라도 값이 같으면 동일하게 취급하는 등, 타입에 안전하지 않았지만
	 *     Java에서는 타입과 값을 모두 체크하는 점에서'타입에 안전한 열거형'이다.
	 * 
	 *  2) 열거형 정의하기 
	 *   - enum 열거형이름 {상수명1, 상수명2, 상수명3, ...}
	 *  
	 *  3) 열거형 상수의 비교
	 *   - == 을 통해 비교 가능. (상수이므로, 메모리 주소를 통한 비교가 가능함)
	 *   - equals를 통해 비교가 가능하지만, ==을 통한 비교가 더 빠름.
	 *      -> equals를 통한 비교가 가능하다 : 열거형 상수는 객체다.
	 *   - compareTo()를 통한 비교가 가능. (ordinal의 대소로 비교)
	 *   - > < >= <=를 통한 비교 불가능.
	 *  
	 *  4) switch문에서 case문에 열거형의 이름을 적지 않고 상수의 이름만 적어야함.
	 *   
	 *  5) java.lang.Enum : 모든 열거형의 조상
	 *   - static E values() : 열거형 상수가 보유한 모든 상수를 배열로 반환함
	 *   - static E valueOf(String name) : 문자열로 열거형 상수를 반환함
	 *   - Class<E> getDeclaringClass() : 열거형의 class 객체 반환
	 *   - String name : 열거형 상수의 이름을 문자열로 반환
	 *   - int ordinal : 열거형 상수가 정의된 순서를 반환 (0부터 시작)
	 *   
	 * ======================================================================== 
	 * 
	 * 2. 열거형에 멤버 추가하기, 열거형 상수의 멤버 반환하기
	 * 
	 *  1) 열거형 상수의 멤버변수 선언
	 *   private final 타입a 변수명1;
	 *   private final 타입b 변수명2; ...
	 *   
	 *  2) 열거형 상수의 생성자
	 *   (private) 열거형이름 (멤버변수타입 매개변수) {this.멤버변수타입 = 매개변수; ...}
	 *  
	 *  3) 열거형 상수의 멤버변수 반환
	 *   public 타입 get변수() ...
	 *   
	 * ========================================================================  
	 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

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

	private static int getDialTime(String dialWord) {
		
		int dialTime = 0; // 총 소요시간
		String[] wordSplit = dialWord.split(""); // dialWord를 한 글자씩 분리하여 배열에 저장
		
 		for (int i=0; i<wordSplit.length; i++) {
 			DialNumber d = DialNumber.valueOf(wordSplit[i]); // 문자열로 열거형 상수 DialNumber 반환
 			dialTime += d.getDialTime(); // DialNumber를 걸기 위한 소요시간 반환, 합산
		}
		return dialTime;
	}

}

enum DialNumber { // 다이얼 넘버의 열거형
	A(2), B(2), C(2),
	D(3), E(3), F(3),
	G(4), H(4), I(4),
	J(5), K(5), L(5),
	M(6), N(6), O(6),
	P(7), Q(7), R(7), S(7),
	T(8), U(8), V(8),
	W(9), X(9), Y(9), Z(9);
	
	private final int number; // 각 상수에 저장한 값
	DialNumber(int number) {this.number = number;} // 각 상수의 생성자
	public int getNumber() {return number;} // 상수에 저장된 값을 반환
	public int getDialTime() {return number+1;} // 상수에 저장된 값을 기반으로 소요시간을 반환 (dialNumber + 1)
}
