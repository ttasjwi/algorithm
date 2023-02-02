import java.io.DataInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static int t;
    private static int n;
    private static int m;
    private static int value;
    private static Queue<int[]> q = new LinkedList<>();
    private static int[] counter;


    public static void main(String[] args) throws IOException {
        Reader r = new Reader();
        t = r.nextInt();
        while (t-- > 0) {
            n = r.nextInt();
            m = r.nextInt();

            counter = new int[10];

            for (int i = 0; i < n; i++) {
                value = r.nextInt();
                q.offer(new int[]{i, value});
                counter[value] += 1;
            }
            sb.append(solution()).append('\n');
            q.clear();
        }
        System.out.print(sb);
    }

    private static int solution() {
        int count = 0;
        int[] item;

        for (int i = 9; i > 0; i--) {
            while (counter[i] > 0) {
                item = q.poll();
                if (item[1] == i) {
                    counter[i]--;
                    count++;
                    if (item[0] == m) {
                        return count;
                    }
                } else {
                    q.offer(item);
                }
            }
        }
        return -1;
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
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
