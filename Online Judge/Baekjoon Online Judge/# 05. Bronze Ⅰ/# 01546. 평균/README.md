# \[BOJ 01546\] 평균

- 난이도 : Bronze 1
- 사칙연산
- 문제 : https://www.acmicpc.net/problem/1546

---  

## 풀이
```java
    public static void main(String[] args) throws IOException {
        int n = readInt();
        double[] scores = new double[n];
        int maxScore = Integer.MIN_VALUE;
        double answer = 0;
        for (int i=0; i<n; i++) {
            answer += scores[i] = readInt();
            if (scores[i] > maxScore) maxScore = (int) scores[i];
        }
        answer = answer/maxScore/n * 100;
        System.out.print(answer);
    }
```
- 각각 조작을 시킬 필요 없이, 최종적으로 모두 점수를 합산한 뒤 총점을 조작하면 된다.

---
