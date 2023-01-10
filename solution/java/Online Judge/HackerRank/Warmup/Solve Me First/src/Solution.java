import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {


    private static int solveMeFirst(int a, int b) {
        return a+b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a  = Integer.parseInt(br.readLine());
        int b  = Integer.parseInt(br.readLine());
        br.close();
        int sum = solveMeFirst(a,b);
        System.out.println(sum);
    }
}