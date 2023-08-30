public class Main {

    public static void main(String[] args) throws java.io.IOException {

    }

    // 0 또는 양수 Int
    private static int i() throws java.io.IOException {
        int v = 0;
        int c = System.in.read();
        do v = v * 10 + (c - 48); while((c = System.in.read()) > 47);
        return v;
    }

    // 0 또는 양수 long
    private static long i() throws java.io.IOException {
        long v = 0;
        int c = System.in.read();
        do v = v * 10 + (c - 48); while((c = System.in.read()) > 47);
        return v;
    }

    // 음수 포함 int
    private static int i() throws java.io.IOException {
        int v = 0;
        int c = System.in.read();
        boolean n = c == 45;
        c = n ?  System.in.read() : c;
        do { v = v * 10 + c - 48;} while ((c = System.in.read()) > 47);
        return n? -v : v;
    }

    // 음수 포함 long
    private static long i() throws java.io.IOException {
        long v = 0;
        int c = System.in.read();
        boolean n = c == 45;
        if (n) c = System.in.read();
        do v = v * 10 + c - 48; while ((c = System.in.read()) > 47);
        return n? -v : v;
    }

    private static final rsb = new StringBuilder();

    // 공백문자까지
    private static String s() throws java.io.IOException {
        int c = r();
        do rsb.append((char)c); while ((c = r()) > 32);
        String s = rsb.toString();
        rsb.setLength(0);
        return s;
    }

    // 개행문자까지
    private static String s() throws java.io.IOException {
        int c = System.in.read();
        do rsb.append((char)c); while ((c = System.in.read()) > 13);
        String s = rsb.toString();
        rsb.setLength(0);
        return s;
    }

    private static final int S = 65536;
    private static final java.io.InputStream IS = new java.io.DataInputStream(System.in);
    private static final byte[] b = new byte[S];
    private static int c = 0;
    private static int l = 0;
    private static StringBuilder rsb = new StringBuilder();

    private static int i() throws java.io.IOException {
        int v = 0;
        int c = r();
        do v = v * 10 + c - 48; while ((c = r()) > 47);
        return v;
    }

    private static int i() throws java.io.IOException {
        int v = 0;
        int c = r();
        boolean n = c == 45;
        if (n) c = r();
        do v = v * 10 + c - 48; while ((c = r()) > 47);
        return n ? -v : v;
    }

    // 공백문자까지
    private static String s() throws java.io.IOException {
        int c = r();
        do rsb.append((char)c); while ((c = r()) > 32);
        String s = rsb.toString();
        rsb.setLength(0);
        return s;
    }

    // 개행문자까지
    private static String s() throws java.io.IOException {
        int c = r();
        do rsb.append((char)c); while ((c = r()) > 13);
        String s = rsb.toString();
        rsb.setLength(0);
        return s;
    }

    private static byte r() throws java.io.IOException {
        if (c == l) {
            l = IS.read(b, (c=0), S);
            if (l == -1) b[0] = -1;
        }
        return b[c++];
    }
}
