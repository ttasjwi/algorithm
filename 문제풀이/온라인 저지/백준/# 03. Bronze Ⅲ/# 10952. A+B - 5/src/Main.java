import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String input;

		while(true) {
			input = br.readLine();
			int a = input.charAt(0)-'0'; // 입력값의 범위가 한자리이므로 0번 인덱스 문자에서 '0'을 제하면 숫자값으로 파싱된다.
			int b = input.charAt(2)-'0'; // 입력값의 범위가 한자리이므로 2번 인덱스 문자에서 '0'을 제하면 숫자값으로 파싱된다.
			if (a==0 && b==0) break;
			sb.append(a+b).append('\n');
		}
		br.close();
		System.out.println(sb);
	}
}
