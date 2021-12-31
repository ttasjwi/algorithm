# \[BOJ 01924] 2007년

- 난이도 : Bronze1
- 2007년 기준 월, 일 입력받고 그 날의 요일을 출력하기
- 문제 : <a href="https://www.acmicpc.net/problem/1924" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>

---  

## Main.java : 백준 제출 답안
- 월, 일을 입력받는다.
- 각 월별 일수를 저장한 배열을 생성하고, 1월부터 일수를 누적시킨다
    ```
    int[] DAY_OF_MONTHS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    for (int i=0; i<x; i++) {
        dayOfYear += DAY_OF_MONTHS[i]; // 그 달까지 일수를 누적
    }
    ```
- 그 달의 경과 일수를 합산 후, 총 누적 일수를 7로 나눈 나머지에 따라 요일을 출력한다.
  ```
  dayOfYear += y; // 그 달의 경과 일수를 누적
  String[] DAY_OF_WEEKS = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
  System.out.println(DAY_OF_WEEKS[dayOfYear%7]); // 누적 일수를 7로 나눈 나머지에 따라 요일을 출력
  ```

---

## Review
- 예전에 자바 플레이 그라운드 및, 코드스쿼드 코코아 과정에서 달력을 구현했던 경험이 있어서 그런가 매우 빠르게 구현함.

---