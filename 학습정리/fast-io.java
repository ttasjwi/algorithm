import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Main {

    public static void main(String[] args) {

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
    private static final StringBuilder rsb = new StringBuilder();

    private static int i() {
        int v = 0;
        byte c = r();
        do {v = v * 10 + c - 48;} while (isDigit((c = r())));
        return v;
    }

    private static int i() {
        int v = 0;
        byte c = r();
        boolean n = c == ASCII_minus;
        c =  n ? r() : c;
        do {v = v * 10 + c - 48;} while (isDigit((c = r())));
        return n ? -v : v;
    }

    private static String s() {
        byte c = r();
        do {rsb.append(c);} while (!isSpace((c = r())));
        String s = rsb.toString();
        rsb.setLength(0);
        return s;
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

    private void writeStr(String s) {
        for (int i=0; i<s.length(); i++) {
            writeByte((byte) s.charAt(i));
        }
    }

    private void writeChar(char ch) {
        writeByte((byte) ch);
    }

    private void writeInt(int i) {
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

    private void writeSpace() {
        writeByte(ASCII_space);
    }

    private void writeN() {
        writeByte(ASCII_n);
    }

    private void writeByte(byte b) {
        if (outbufferpointer == outbuffer.length) flushBuffer();
        outbuffer[outbufferpointer++] = b;
    }

    private void flushBuffer() {
        if (outbufferpointer != 0) {
            try {
                dout.write(outbuffer, 0, outbufferpointer)
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            outbufferpointer = 0;
        }
    }

    private static boolean isSpace(byte b) {
        return b <= ASCII_space;
    }
    private static boolean isDigit(byte b) {
        return b >= ASCII_0;
    }

    private static boolean isEOF() {
        return bytesread == EOF;
    }
}
