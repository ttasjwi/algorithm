# 3.6 최대 길이 연속부분수열

- 분류 : 투 포인터(Two Pointer)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 3.6)

---

### 풀이: 투 포인터
```java
    private static int solution(int[] numbers, int n, int k) {
        int answer = 0;
        int cnt = 0; // 0을 1로 바꾼 횟수
        int lt = 0; // 왼쪽 끝값
        int length; // 연속 수열의 길이
        for (int rt = 0; rt < n; rt++) {
            if (numbers[rt] == 0) { // rt가 있는 위치는 무조건 1이여야한다. (rt가 움직이면서 0을 1로 변환시킨다.)
                cnt++; // rt의 위치를 1로 변환했다고 가정한다
            }

            while(cnt > k) { // k보다 더 많이 cnt를 증가시킨 상황이므로 lt를 그만큼 오른쪽으로 움직여야한다. 
                if (numbers[lt] == 0) { // 
                    cnt --; // lt를 움직이기 전에, rt에 의해 1로 바뀌었던 것을 0으로 되돌린다)
                }
                lt ++; // lt를 움직인다.
            }

            // cnt <=k일 때 (합법적으로 lt가 가장 왼쪽인 시점)
            length = rt - lt + 1; // rt 시점에서 가장 길게 잡을 수 있는 길이
            answer = Math.max(answer, length);
        }
        return answer;
    }
```
- rt를 for문을 돌며 움직이면서 lt가 이를 따라 움직이는 형태
- rt는 도착한 인덱스의 저장값이 0이면 이를 1로 만들고 cnt를 증가시킨다.
- cnt가 k보다 커졌을 경우에는, cnt가 k이하가 될 때까지 lt를 이동시킨다.
  - lt를 이동시키기 전에, lt가 있던 자리의 저장값이 0이였다면 rt가 증가시킨 분만큼 다시 cnt를 감소시킨다.
  - lt를 이동시킨다.
- length를 구한다. (rt - lt +1)
- length, answer 중 최댓값을 answer로 갱신한다

---

### 소감
- 어렵다... 투포인터는 여러번 자주 풀어보면서 익숙해져야할 개념 같다.

---
