import java.io.DataInputStream;
import java.io.DataOutputStream;

class Stack {
    private int size;
    private final byte[] arr = new byte[20];

    void push(byte b) {
        arr[size++] = b;
    }

    byte pop() {
        return arr[--size];
    }

    boolean isNotEmpty() {
        return size != 0;
    }
}

public class Main {

    public static void main(String[] args) {
        int t = i();
        Stack stack = new Stack();
        byte c, sep;
        while (t > 0) {
            sep = ASCII_space;
            while (true) {
                c = r();
                if (c == ASCII_n) {
                    t --;
                    sep = c;
                }
                if (c <= ASCII_space) break;
                stack.push(c);
            }
            while (stack.isNotEmpty()) writeByte(stack.pop());
            writeByte(sep);
        }
        flushBuffer();
    }

    private static final byte EOF = -1;
    private static final byte ASCII_n = 10;
    private static final byte ASCII_space = 32;
    private static final byte ASCII_0 = 48;
    private static final DataInputStream din = new DataInputStream(System.in);
    private static final DataOutputStream dout = new DataOutputStream(System.out);
    private static final byte[] inbuffer = new byte[65536];
    private static int inbufferpointer;
    private static int bytesread;
    private static final byte[] outbuffer = new byte[65536];
    private static int outbufferpointer;

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
