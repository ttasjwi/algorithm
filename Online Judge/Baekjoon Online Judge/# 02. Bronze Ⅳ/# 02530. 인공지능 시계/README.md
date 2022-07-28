
# \[BOJ 02530\] 인공지능 시계

- 난이도 : Bronze4
- 시간의 덧셈
- 문제: <a href="https://www.acmicpc.net/problem/2530" target="_blank"> [링크]</a>

---

## 풀이
### 전제지식
- 1일은 24 * 60 * 60초
- 1시간은 60 *  60초
- 1분은 60초

### 입력 -> 초로 환산해 일괄 합산
```java
private static final int DAY_SECOND = 24 * 60 * 60;
private static final int HOUR_SECOND = 60 * 60;
private static final int MINUTE_SECOND = 60;

public static void main(String[] args) throws IOException {
    int second = 0; // 전체 시간을 초로 환산
    second += readInt() * HOUR_SECOND; // 시
    second += readInt() * MINUTE_SECOND; // 분
    second += readInt(); // 초
    second += readInt(); // 추가 초
```
- 입력 받을 때마다 각 단위를 초로 환산하여 합산한다.

### 합산된 초를 각 단위별로 분리
```java
    StringBuilder sb = new StringBuilder();

    second = second%DAY_SECOND; // 1일 이상의 초 제거
    sb.append(second/HOUR_SECOND).append(' '); // 남은 시 환산

    second = second%HOUR_SECOND; // 1시간 이상의 초 제거
    sb.append(second/MINUTE_SECOND).append(' '); // 남은 분 환산

    second = second%MINUTE_SECOND; // 1분 이상의 초 제거
    sb.append(second);

    System.out.print(sb);
}
```
- 전체 초 기준으로 1일치 초으로 나눈 몫이 경과 일자
- 나머지 기준으로 한 단계 씩 분리

---
