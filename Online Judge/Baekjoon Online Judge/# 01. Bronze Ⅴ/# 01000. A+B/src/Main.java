
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		br.close();

		StringTokenizer st = new StringTokenizer(input, " "); // " "을 구분자로 하여 입력받음

		int a = Integer.parseInt(st.nextToken()); // 값 두개를 입력받는다
		int b = Integer.parseInt(st.nextToken());
		System.out.println(a+b); // 합을 출력한다
	}
}