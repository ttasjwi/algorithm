import java.util.ArrayList;
import java.util.List;

class Result {

    // 커트라인
    private static final int CUT_LINE = 38;

    // 사용자로부터 입력받은 grade List를 기반으로 수정값을 반환한다.
    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> reGrades = new ArrayList<>();
        for (Integer grade : grades) {
            int regrade = reGrading(grade);
            reGrades.add(regrade);
        }
        return reGrades;
    }

    // 지정 정수의 다음 k의 배수를 반환한다.
    public static int nextMultipleOfK(int origin, int k) {
        int nextMultipleOfK = 0;
        for (int i = origin + 1 ; i<= origin + k; i ++) {
            if (i%k == 0) {
                nextMultipleOfK = i;
            }
        }
        return nextMultipleOfK;
    }

    // grade를 기반으로 regrading
    public static int reGrading(int grade) {
        int regrade = grade;
        if (grade >= CUT_LINE) {
            int nextMultipleOf5 = nextMultipleOfK(grade,5);
            int diff = nextMultipleOf5 - grade;
            regrade = (diff<3)? nextMultipleOf5 : grade;
        }
        return regrade;

    }
}