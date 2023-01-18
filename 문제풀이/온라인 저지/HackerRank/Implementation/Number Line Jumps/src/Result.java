

public class Result {

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        if (v1 <= v2) return "NO";

        double t = (double)(x2-x1)/(v1-v2);

        if (t==(int)t) {
            return "YES";
        }

        return "NO";
    }

}