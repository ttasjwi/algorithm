import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Main {

    public static void main(String[] args) {
        int n = i();
        int m = i();
        int success = 0;
        Heap heap = new Heap(m);

        for (int i=0, tmp; i<m; i++) {
            tmp = n- i();
            i();
            if (tmp <= 0) success ++;
            else heap.push(tmp);
        }
        int answer = 0;
        while (success < m-1) {
            answer += heap.pop();
            success ++;
        }
        writeInt(answer);
        flushBuffer();
    }

    private static final byte EOF = -1;
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


class Heap {

    private final int[] arr;
    private int size;

    Heap(int cap) {
        this.arr = new int[cap+1];
    }

    void push(int e) {
        arr[++size] = e;
        int i = size;
        int p = i >> 1;
        int tmp;
        while (p > 0) {
            if (arr[i] < arr[p]) {
                tmp = arr[p];
                arr[p] = arr[i];
                arr[i] = tmp;
                i = p;
                p = i >> 1;
            } else {
                break;
            }
        }
    }

    int pop() {
        int e = arr[1];
        arr[1] = arr[size--];
        int i = 1;
        int lt = i << 1;
        int rt = lt + 1;
        int small = i;
        int tmp;
        while (true) {
            if (lt <= size && arr[lt] < arr[small]) small = lt;
            if (rt <= size && arr[rt] < arr[small]) small = rt;
            if (i == small) break;
            tmp = arr[i];
            arr[i] = arr[small];
            arr[small] = tmp;
            i = small;
            lt = i << 1;
            rt = lt + 1;
        }
        return e;
    }
}