import java.io.DataInputStream;
import java.io.IOException;
import java.io.Reader;

public class Main {

    public static void main(String[] args) throws IOException {
        Reader r = new Reader();
        int n = r.nextInt();
        int[] counter = new int[8001];

        int max = -4001;
        int min = 4001;
        int sum = 0;
        int value;
        for (int i=0; i<n; i++) {
            value = r.nextInt();
            counter[value + 4000] ++;
            if (value > max) {
                max = value;
            }

            if (value < min) {
                min = value;
            }
            sum += value;
        }
        int mode = -4001;
        int modeCount = 0;
        boolean modeDuplicated = false;

        int count = 0;
        int median = 4001;
        for (int i=min + 4000; i < max + 4001; i++) {
            if (counter[i] > 0) {
                count += counter[i];
                if (median == 4001 && count > n/2) {
                    median = i - 4000;
                }
                if (counter[i] > modeCount) {
                    mode = i - 4000;
                    modeCount = counter[i];
                    modeDuplicated = false;
                } else if (counter[i] == modeCount && !modeDuplicated){
                    mode = i - 4000;
                    modeDuplicated = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Math.round(sum/(double)n))
                .append('\n')
                .append(median)
                .append('\n')
                .append(mode)
                .append('\n')
                .append(max-min);
        System.out.print(sb);
    }


    static class Reader {
        private final int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

    }
}
