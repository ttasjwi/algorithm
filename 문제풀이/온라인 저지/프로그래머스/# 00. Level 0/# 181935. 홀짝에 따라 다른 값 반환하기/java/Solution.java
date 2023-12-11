class Solution {
    public int solution(int n) {
        return (n % 2 == 1)
                ? (n + 1) / 2 * ((n + 1) / 2)
                : n * (n + 1) * (n + 2) / 6;
    }
}
