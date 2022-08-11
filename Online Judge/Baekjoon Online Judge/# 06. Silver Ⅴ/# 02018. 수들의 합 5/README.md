# \[BOJ 02018\] 수들의 합 5

- 난이도 : Silver5
- 투 포인터, 나머지 연산
- 문제 : <a href="https://www.acmicpc.net/problem/2018" target="_blank"> [링크]</a>

---  

## 풀이1 : 숫자 분할(나머지)
```java
    public static void main(String[] args) throws IOException {
        int n = readInt();
        int answer = 0;
        int cnt = 1;

        do {
            if (n % cnt == 0) {
                answer++;
            }
            n -= cnt++;
        } while (n > 0);
        System.out.print(answer);
    }
```
- 숫자의 갯수를 1로 둔다.
- n을 숫자의 갯수로 나눴을 때 나누어 떨어지는지 확인한다.
  - 숫자의 갯수만큼 남은 숫자를 분배 가능하다는 것이다
  - answer를 증가시킨다.
- n에서 cnt를 차감하고, cnt를 증가시킨다.

---

## 풀이2 : 투포인터
```java

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int lt = 1;
        int rt = 1;
        int sum = 0;
        int answer = 0;

        while (lt <= n && rt <= n) {
            sum += rt;
            if (sum == n) {
                answer++;
                sum -= lt;
                lt++;
            }
            while (sum >= n) {
                sum -= lt;
                lt++;
                if (sum == n) {
                    answer++;
                }
            }
            rt++;
        }
        System.out.print(answer);
    }
```
- 투포인터를 사용함
- lt, rt를 1에서 시작한다.
- sum을 현재 rt값에 따라 증가시킨다.
- sum, n을 비교하고 같으면 answer를 증가시키고 lt를 뒤로 민다.
  - 기존 lt값만큼 뺀다음에 lt를 증가시켜야한다.
- 이후, sum이 n보다 크거나 같으면 작아질 때까지 lt를 민다.
  - 이 도중에, sum이 같아지는 순간이 오면 answer를 증가시킨다.
- rt를 증가시킨다.

---
