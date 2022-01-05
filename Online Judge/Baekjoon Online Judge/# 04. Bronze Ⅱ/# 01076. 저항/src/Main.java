import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long result = 0;
        result += getResistanceValue(br.readLine())*10;
        result += getResistanceValue(br.readLine());
        result *= getResistanceMultiple(br.readLine());
        System.out.print(result);
    }

    private static int getResistanceValue(String color) {
        switch(color) {
            case "black" : return 0;
            case "brown" : return 1;
            case "red" : return 2;
            case "orange" : return 3;
            case "yellow" : return 4;
            case "green" : return 5;
            case "blue" : return 6;
            case "violet" : return 7;
            case "grey" : return 8;
            default : return 9;
        }
    }

    private static int getResistanceMultiple(String color) {
        int result = 1;
        int value = getResistanceValue(color);
        for (int i=0; i< value; i++) {
            result *= 10;
        }
        return result;
    }
}
