import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Main {

    public static void main(String[] args) {
        int n = i();
        int inf = 50;
        int[][] cost = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                cost[i][j] = inf;
            }
        }
        for(int a, b; ; ) {
            a = i();
            b = i();
            if (a == -1) break;
            cost[a][b] = 1;
            cost[b][a] = 1;
        }

        for (int m = 1, alt; m<=n; m ++) {
            for (int s=1; s<=n; s++) {
                if (cost[s][m] == inf) continue;
                for (int e =1; e<=n; e++) {
                    if (s == e || cost[m][e] == inf) continue;
                    alt = cost[s][m] + cost[m][e];
                    if (cost[s][e] > alt) {
                        cost[s][e] = alt;
                    }
                }
            }
        }
        int size = 0;
        int[] stack = new int[inf];
        int minScore = inf;
        int currentMaxScore;
        for (int r = n; r>=1; r--) {
            currentMaxScore = 0;
            for (int c=n; c>=1; c--) {
                if (cost[r][c] != inf && currentMaxScore < cost[r][c]) {
                    currentMaxScore = cost[r][c];
                }
            }
            if (currentMaxScore != 0 && currentMaxScore <= minScore) {
                if (currentMaxScore < minScore) {
                    size = 0;
                    minScore = currentMaxScore;
                }
                stack[size++] = r;
            }
        }
        writeInt(minScore);
        writeInt(size);
        writeByte(ASCII_n);
        while(size > 0) {
            writeInt(stack[--size]);
        }
        flushBuffer();
    }

    private static final byte EOF = -1;
    private static final byte ASCII_n = 10;
    private static final byte ASCII_space = 32;
    private static final byte ASCII_minus = 45;
    private static final byte ASCII_0 = 48;
    private static final DataInputStream din = new DataInputStream(System.in);
    private static final DataOutputStream dout = new DataOutputStream(System.out);
    private static final byte[] inbuffer = new byte[65536];
    private static int inbufferpointer;
    private static int bytesread;
    private static final byte[] outbuffer = new byte[65536];
    private static int outbufferpointer;
    private static final byte[] bytebuffer = new byte[20];

    private static int i() {
        int v = 0;
        byte c = r();
        boolean n = c == ASCII_minus;
        c =  n ? r() : c;
        do {v = v * 10 + c - 48;} while (isDigit((c = r())));
        return n ? -v : v;
    }

    private static byte r() {
        if (inbufferpointer == bytesread) fillBuffer();
        return (bytesread == EOF) ? EOF : inbuffer[inbufferpointer++];
    }

    private static void fillBuffer() {
        try {
            bytesread = din.read(inbuffer, (inbufferpointer = 0), inbuffer.length);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeInt(int i) {
        if (i == 0) {
            writeByte(ASCII_0);
        } else {
            if (i < 0) {
                writeByte(ASCII_minus);
                i = -i;
            }
            int index = 0;
            while (i > 0) {
                bytebuffer[index++] = (byte)(i % 10 + ASCII_0);
                i /= 10;
            }
            while (index-- > 0) {
                writeByte(bytebuffer[index]);
            }
        }
        writeByte(ASCII_space);
    }

    private static void writeByte(byte b) {
        if (outbufferpointer == outbuffer.length) flushBuffer();
        outbuffer[outbufferpointer++] = b;
    }

    private static void flushBuffer() {
        if (outbufferpointer != 0) {
            try {
                dout.write(outbuffer, 0, outbufferpointer);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            outbufferpointer = 0;
        }
    }

    private static boolean isDigit(byte b) {
        return b >= ASCII_0;
    }
}
