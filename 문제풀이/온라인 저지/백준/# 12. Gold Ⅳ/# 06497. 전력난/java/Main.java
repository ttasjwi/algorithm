import java.io.DataInputStream;
import java.io.DataOutputStream;


public class Main {

    private static int[] parent;

    public static void main(String[] args) {
        while (true) {
            int m = i();
            int n = i();
            if (m == 0 && n == 0) {
                break;
            }
            parent = new int[m];
            for (int i = 0; i < m; i++) {
                parent[i] = i;
            }
            Heap heap = new Heap(n);
            while (n-- > 0) heap.push(new Edge(i(), i(), i()));
            int cnt = 0;
            int saveCost = 0;
            while (heap.isNotEmpty()) {
                Edge cur = heap.pop();
                if (cnt == m - 1) {
                    saveCost += cur.cost;
                    continue;
                }
                if (union(cur.from, cur.to)) {
                    cnt++;
                } else {
                    saveCost += cur.cost;
                }
            }
            writeInt(saveCost);
        }
        flushBuffer();
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;
        if (aRoot < bRoot) parent[bRoot] = aRoot;
        else parent[aRoot] = bRoot;
        return true;
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

class Edge implements Comparable<Edge> {

    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge other) {
        return cost - other.cost;
    }
}

class Heap {
    private final Edge[] arr;
    private int size;

    public Heap(int cap) {
        arr = new Edge[cap + 1];
    }

    public void push(Edge e) {
        arr[++size] = e;
        int i = size;
        int p = i >> 1;
        Edge tmp;
        while (p > 0) {
            if (arr[i].compareTo(arr[p]) < 0) {
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

    public Edge pop() {
        Edge e = arr[1];
        arr[1] = arr[size];
        arr[size--] = null;
        int i = 1;
        int lt = i << 1;
        int rt = lt + 1;
        int small = i;
        Edge tmp;
        while (true) {
            if (lt <= size && arr[lt].compareTo(arr[small]) < 0) small = lt;
            if (rt <= size && arr[rt].compareTo(arr[small]) < 0) small = rt;
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

    public boolean isNotEmpty() {
        return size != 0;
    }
}

