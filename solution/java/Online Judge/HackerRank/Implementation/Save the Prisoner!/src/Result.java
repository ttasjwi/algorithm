
public class Result {

    public static int saveThePrisoner(int n, int m, int s) {
        int sit = (s+m-1)%n;
        return (sit == 0)? n : sit;
    }

}