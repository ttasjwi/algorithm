import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Main {

    public static void main(String[] args) {
        int t = i();
        int n, x, y, lt, rt, mid, answer;
        int speed = -1;
        double minTime, time;

        loop:
        while (t-- > 0) {
            n = i();
            x = i();
            y = i();
            minTime = Double.MAX_VALUE;
            while (n-- > 0) {
                speed = i();
                time = x / (double) speed;
                if (minTime > time) {
                    if (n == 0) {
                        writeInt(0);
                        continue loop;
                    }
                    minTime = time;
                }
            }
            lt = 1;
            rt = y;
            answer = -1;
            while (lt <= rt) {
                mid = (lt + rt) >> 1;
                time = (x < mid) ? x / (double) mid : 1 + (x - mid) / (double) speed;
                if (minTime > time) {
                    answer = mid;
                    rt = mid - 1;
                } else {
                    lt = mid + 1;
                }
            }
            writeInt(answer);
        }
        flushBuffer();
    }

    private static final byte EOF = -1;
    private static final byte ASCII_n = 10;
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
        writeByte(ASCII_n);
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
