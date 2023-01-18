import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String input;
		int a;
		int b;

		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=T; i++) { // 반복 횟수만큼 입력을 받고, 결과를 출력
			input = br.readLine();
			a = input.charAt(0)-48;
			b = input.charAt(2)-48;
			sb.append("Case #")
					.append(i).append(": ")
					.append(a+b)
					.append('\n');
		}
		System.out.println(sb);
	}

}