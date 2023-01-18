import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine()); // 각1
        int b = Integer.parseInt(br.readLine()); // 각2
        int c = Integer.parseInt(br.readLine()); // 각3

        br.close();
        String result;

        if (a+b+c == 180) { // 각의 합이 180인 경우

            if (a==b && b==c && c == a) { // 세 각의 크기가 같다
                result = "Equilateral";
            } else if (a==b || b==c || c==a) { // 그 외에, 적어도 두 각의 크기가 같다.
                result = "Isosceles";
            } else { // 그 외 : 서로 같은 각이 없는 경우
                result = "Scalene";
            }
        } else { // 각의 합이 180이 아닌 경우
            result = "Error";
        }

        System.out.println(result);
    }
}
