import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Main {

    public static void main(String[] args) {
        int n = i();
        int bus = i();
        int[][] cost = new int[n][n];
        int inf = 10_000_000;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = i == j ? 0 : inf;
            }
        }

        for (int i = 0, a,b,c; i < bus; i++) {
            a = i() - 1;
            b = i() - 1;
            c = i();
            if (cost[a][b] > c) cost[a][b] = c;
        }

        for (int m = 0, alt; m < n; m++) {
            for (int s = 0; s < n; s++) {
                if ((s == m) || cost[s][m] == inf) continue;
                for (int e = 0; e < n; e++) {
                    if ((s == e) || (m == e) || cost[m][e] == inf) continue;
                    alt = cost[s][m] + cost[m][e];
                    if (cost[s][e] > alt) cost[s][e] = alt;
                }
            }
        }
        for (int[] arr : cost) {
            for (int c : arr) {
                writeInt((c == inf) ? 0 : c);
                writeByte(ASCII_space);
            }
            writeByte(ASCII_n);
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
        do {v = v * 10 + c - 48;} while (isDigit((c = r())));
        return v;
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
