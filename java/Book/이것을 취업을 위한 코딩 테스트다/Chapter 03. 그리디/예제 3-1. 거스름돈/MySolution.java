import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MySolution {

    public static void main(String[] args) {
        int N = inputN();
        long startTime = System.currentTimeMillis();

        int count = 0;
        int[] units = {500,100,50,10};
        int index = 0;
        while (N>0) {
            count += N / units[index];
            N = N %units[index++];
        }
        System.out.println(count);

        long endTime = System.currentTimeMillis();
        System.out.println("소요시간 : "+(endTime-startTime)+" ms");
    }

    private static int inputN() {
        int N = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            br.close();
        } catch (NumberFormatException e) {

        } catch (IOException e) {

        }
        return N;
    }
}
