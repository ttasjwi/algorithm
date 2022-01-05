import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solve1 {

    public static void main(String[] args) throws IOException {
        Map<String, int[]> map = new HashMap<>();
        map.put("black", new int[] {0, 1});
        map.put("brown", new int[] {1, 10});
        map.put("red", new int[] {2, 100});
        map.put("orange", new int[] {3, 1000});
        map.put("yellow", new int[] {4, 10000});
        map.put("green", new int[] {5, 100000});
        map.put("blue", new int[] {6, 1000000});
        map.put("violet", new int[] {7, 10000000});
        map.put("grey", new int[] {8, 100000000});
        map.put("white", new int[] {9, 1000000000});
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long result = 0;
        result += map.get(br.readLine())[0] * 10;
        result += map.get(br.readLine())[0];
        result *= map.get(br.readLine())[1];
        br.close();
        System.out.print(result);
    }
}