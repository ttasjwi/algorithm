import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;


class Queue {
    private final int c;
    private final int[] arr;
    private int f;
    private int r;
    int size = 0;

    Queue(int cap) {
        this.c = cap + 1;
        this.arr = new int[c];
    }

    public void enQueue(int e) {
        size ++;
        arr[(r = (r+1+c)%c)] = e;
    }
    public int deQueue() {
        size --;
        return arr[(f = (f+1+c)%c)];
    }

    public boolean isNotEmpty() {
        return size != 0;
    }
}


public class Main {

    public static void main(String[] args) {
        int n = i();
        int m = i();

        int[] inDegree = new int[n + 1];
        int[] counter = new int[n + 1];
        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        Queue q = new Queue(n);
        int from;
        int to;
        while (m-- > 0) {
            from = i();
            to = i();
            graph[from].add(to);
            inDegree[to]++;
        }

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                q.enQueue(i);
            }
        }
        int cur;
        int size;
        int depth = 0;
        while (q.isNotEmpty()) {
            size = q.size;
            depth++;
            while (size-- > 0) {
                cur = q.deQueue();
                counter[cur] = depth;
                for (int next : graph[cur]) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) {
                        q.enQueue(next);
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            writeInt(counter[i]);
        }
        flushBuffer();
    }

    private static final byte EOF = -1;
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
        do {
            v = v * 10 + c - 48;
        } while (isDigit((c = r())));
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
                bytebuffer[index++] = (byte) (i % 10 + ASCII_0);
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