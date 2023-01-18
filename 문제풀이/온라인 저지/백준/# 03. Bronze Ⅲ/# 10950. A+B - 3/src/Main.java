import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		while (T>0) { // 반복 횟수만큼 입력을 받고, 결과를 출력
			st = new StringTokenizer(br.readLine(), " ");
			sb.append(Integer.parseInt(st.nextToken())+
							Integer.parseInt(st.nextToken()))
					.append('\n');
			T--;
		}
		br.close();
		System.out.println(sb);
	}
}
