import java.util.Arrays;

public class Solution1 {

    public int[] solution(int[] numlist, int n) {
        MyNumber.standard = n;

        return Arrays.stream(numlist)
                .mapToObj(MyNumber::new)
                .sorted()
                .mapToInt(MyNumber::getValue)
                .toArray();
    }

}

class MyNumber implements Comparable<MyNumber> {
    static int standard;

    int value;

    public MyNumber(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(MyNumber o) {
        int thisDiff = this.diff();
        int otherDiff = o.diff();

        if (thisDiff == otherDiff) {
            return o.value - this.value;
        }
        return thisDiff - otherDiff;
    }

    private int diff() {
        return Math.abs(value - standard);
    }

    public int getValue() {
        return value;
    }
}
