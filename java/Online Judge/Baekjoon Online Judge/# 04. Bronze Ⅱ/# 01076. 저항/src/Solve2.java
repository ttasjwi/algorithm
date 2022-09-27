import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solve2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long result = 0;
        result += Solve2_Resistance.valueOf(br.readLine()).getValue() * 10;
        result += Solve2_Resistance.valueOf(br.readLine()).getValue();
        result *= Solve2_Resistance.valueOf(br.readLine()).getMultiply();
        br.close();
        System.out.println(result);
    }

}