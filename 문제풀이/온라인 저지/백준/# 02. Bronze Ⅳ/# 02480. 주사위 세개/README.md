
# \[BOJ 02480\] 주사위 세개

- 난이도 : Bronze4
- 숫자 3개를 비교하여 분기처리
- 문제: <a href="https://www.acmicpc.net/problem/2480" target="_blank"> [링크]</a>

---

## 풀이

### 카운터 사용
```java
int[] counter = new int[7];

for (int i=0; i<3; i++) {
    counter[readInt()]++;
}

```
- 숫자의 종류는 1~6이고, 각각 나온 횟수가 중요하다.
- 나온 숫자에 해당하는 카운터를 증가시킨다.

### 값 구하기
```java
int answer;

int maxNumber = 0;

for (int i=1; i<=6; i++) {
    if (counter[i] == 3) {
        answer = 10000 + (i * 1000);
        System.out.print(answer);
        return;
    } else if (counter[i] == 2) {
        answer = 1000 + i * 100;
        System.out.print(answer);
        return;
    } else if (counter[i] == 1){
        maxNumber = (i > maxNumber) ? i : maxNumber;
    } else {
        continue;
    }
}
answer = maxNumber * 100;
System.out.print(answer);
```
- 카운터를 1번부터 6번까지 순서대로 읽으면서
  - 집계 갯수가 3개 : 같은 눈이 세 개 -> 결과 반환
  - 집계 갯수가 2개 : 같은 눈이 두 개 -> 결과 반환
  - 집계 갯수가 1개 : 여태 나온 눈 중 최댓값인지 확인 후 갱신
- 끝까지 돈 경우는 서로 다른 눈이 3개이므로, 다른 눈에 따른 결과값을 출력하면 됨

---