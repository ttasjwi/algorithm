import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input;
		int a;
		int b;

		// true를 작성하면 EOF가 없어짐.
		// 문자열이 null이면 더 이상 출력하지 않도록 하여 EOF 처리
		while((input = br.readLine()) != null) {
			a = input.charAt(0)-'0'; // 입력값의 범위가 한자리이므로 0번 인덱스 문자에서 '0'을 제하면 숫자값으로 파싱된다.
			b = input.charAt(2)-'0'; // 입력값의 범위가 한자리이므로 2번 인덱스 문자에서 '0'을 제하면 숫자값으로 파싱된다.
			sb.append(a+b).append('\n');
		}
		br.close();
		System.out.println(sb);
	}
}
