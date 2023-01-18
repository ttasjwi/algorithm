import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int price = Integer.parseInt(br.readLine());
        br.close();

        int price1 = (int)(price * (1-0.22)); // 전체에서 0.22만큼을 제한 경우
        int price2 = (int)((price) * (0.8) + (price) * (0.2) * (1-0.22)); // 전체에서 0.8을 받고 나머지 0.2 중의 전체에서 0.22만큼을 제한 경우
        StringBuilder sb = new StringBuilder();
        sb.append(price1).append(' ').append(price2);
        System.out.println(sb);
    }
}
