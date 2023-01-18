import java.io.IOException;
import java.util.*;

public class Main {

    private static final int RESET_BIT = 0b1111_1111_1111_1111_1111_0000_0000_0000;

    public static void main(String[] args) throws IOException {
        int N = readInt();
        int M = readInt();

        int[] trains = new int[N];

        int command, trainIndex, sitIndex;

        for (int i = 0; i < M; i++) {
            command = readInt();
            if (command == 1) {
                trainIndex = readInt() - 1;
                sitIndex = readInt() - 1;
                trains[trainIndex] = trains[trainIndex] | prepareSitBit(sitIndex);
            } else if (command == 2) {
                trainIndex = readInt() - 1;
                sitIndex = readInt() - 1;
                trains[trainIndex] = trains[trainIndex] & (~prepareSitBit(sitIndex));
            } else if (command == 3) {
                trainIndex = readInt() - 1;
                trains[trainIndex] = removeAbove20(trains[trainIndex] >>> 1);
            } else {
                trainIndex = readInt() - 1;
                trains[trainIndex] = trains[trainIndex] << 1;
            }
        }

        Set<Integer> trainSet = new HashSet<>();
        for (int train : trains) {
            trainSet.add(train);
        }
        System.out.print(trainSet.size());
    }

    // 좌석에 해당하는 자리에 1(비트)을 둔다.
    private static int prepareSitBit(int sitIndex) {
        int sitBit = Integer.MIN_VALUE;
        for (int i = 0; i < sitIndex; i++) {
            sitBit = sitBit >>> 1;
        }
        return sitBit;
    }

    private static int readInt() throws IOException {
        int value = 0;
        while (true) {
            // 입력 문자의 ASCII코드 값.
            // 가령 '0'이 들어왔으면 숫자 0이 아니라 '0'의 ASCII 코드값인 48이다.
            int input = System.in.read();
            if (input == ' ' || input == '\n') { // 개행문자거나 공백이면 연산을 끊음
                return value; // 양수면 그냥 반환
            } else {
                value = value * 10 + (input - 48); // 기존 값을 10배하고 입력된 추가값을 파싱하여 더함
            }
        }
    }

    private static int removeAbove20(int trainBit) {
        return trainBit & RESET_BIT;
    }

}