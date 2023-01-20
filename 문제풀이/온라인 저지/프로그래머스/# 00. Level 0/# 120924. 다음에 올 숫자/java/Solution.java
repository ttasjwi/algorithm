class Solution {
    public int solution(int[] common) {
        int d = common[1] - common[0];

        // 등차 판별
        if (d == common[2] - common[1]) {
            return common[common.length-1] + d;
        }

        // 등비인데 초항이 0인 경우 나눗셈 연산으로 공비를 구할 수 없음
        if (common[0] == 0) {
            return 0;
        }

        // 그 외는 공비를 정상적으로 구할 수 있음. -> 계산
        return common[common.length-1] * common[1]/common[0];
    }
}
