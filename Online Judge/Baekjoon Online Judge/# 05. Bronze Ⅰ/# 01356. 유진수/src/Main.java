import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();

        int LENGTH = input.length();
        
        if (LENGTH == 1) {
            System.out.println("NO");
        } else {
            int[] ints = new int[LENGTH];
            for (int i=0; i<LENGTH; i++) ints[i] = input.charAt(i) - '0';

            int multiply1;
            int multiply2;

            boolean isYuzinsu = false;

            for (int i=0; i <LENGTH-1; i++) {
                multiply1 = 1;
                multiply2 = 1;

                for (int j=0; j<=i; j++) multiply1 *= ints[j]; // 앞의 값 곱
                for (int j=LENGTH-1; j>i; j--) multiply2 *= ints[j]; //뒤의 값 곱

                if (multiply1 == multiply2) {// 같으면 유진수
                    isYuzinsu = true;
                    break;
                }
            }
            System.out.println((isYuzinsu) ? "YES" : "NO");
        }
    }
}