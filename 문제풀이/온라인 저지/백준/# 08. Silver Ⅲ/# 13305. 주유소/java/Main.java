import java.io.DataInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int n = i();
        int[] d = new int[n - 1];
        for (int i=0; i<n-1; i++) d[i] = i();
        int[] c = new int[n];
        for (int i=0; i<n-1; i++) c[i] = i();
        i();
        int lt = 0;
        int rt;
        long answer = 0L;
        while (lt < n - 1) {
            rt = lt + 1;
            while (rt < n && c[lt] < c[rt]) {
                answer += (long) c[lt] * d[rt - 1];
                rt++;
            }
            answer += (long) c[lt] * d[rt - 1];
            lt = rt;
        }
        System.out.print(answer);
    }

    private static final int S = 65536;
    private static final java.io.InputStream IS = new DataInputStream(System.in);
    private static final byte[] b = new byte[S];
    private static int c = 0;
    private static int l = 0;

    private static int i() throws IOException {
        int v = 0;
        int c = r();
        do v = v * 10 + c - 48; while ((c = r()) > 47);
        return v;
    }

    private static byte r() throws IOException {
        if (c == l) {
            l = IS.read(b, (c=0), S);
            if (l == -1) b[0] = -1;
        }
        return b[c++];
    }
}
