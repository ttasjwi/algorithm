import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Main {

    public static void main(String[] args) {
        int[] a = i();
        int[] b = i();
        writeInt(a[0] + b[0]);
        writeInt(a[1] + b[1]);
        flushBuffer();
    }

    private static final byte EOF = -1;
    private static final byte ASCII_space = 32;
    private static final byte ASCII_minus = 45;
    private static final byte ASCII_0 = 48;
    private static final DataInputStream din = new DataInputStream(System.in);
    private static final DataOutputStream dout = new DataOutputStream(System.out);
    private static final byte[] inbuffer = new byte[16];
    private static int inbufferpointer;
    private static int bytesread;
    private static final byte[] outbuffer = new byte[16];
    private static int outbufferpointer;
    private static final byte[] bytebuffer = new byte[16];

    private static int[] i() {
        int min = 0;
        int max = 0;
        byte c;
        while (isDigit(c = r())) {
            min = min * 10 + ((c == 54) ? 5 : c - 48);
            max = max * 10 + ((c == 53) ? 6 : c - 48);
        }
        return new int[]{min, max};
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
