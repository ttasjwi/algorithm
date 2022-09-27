
# 2.07 점수계산

- 분류 : 배열(Array)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 2.07)

---

## 풀이 : '보너스' 변수 도입
```java
    private static int solution(boolean[] isAnswers) {
        int bonus = 0;
        int totalScore = 0;

        for (boolean isAnswer : isAnswers) {
            if (isAnswer) {
                bonus ++;
                totalScore += bonus;
            } else {
                bonus = 0;
            }
        }
        return totalScore;
    }
```
- 배열을 순서대로 탐색
- 정답이 나올 때마다 bonus를 1 증가
- 누적된 보너스만큼 총점을 합산
- 오답이 나오면 bonus를 0으로 초기화

---
