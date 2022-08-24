# \[BOJ 03052] 나머지

- 난이도 : Bronze 2
- 나머지, 카운팅
- 문제 : <a href="https://www.acmicpc.net/problem/3052" target="_blank">링크</a>

---  

## 풀이
```java
    public static void main(String[] args) throws IOException {
        int[] counter = new int[42];
        for (int i = 0; i < 10; i++) {
            counter[readInt()%42] ++;
        }
        int answer = 0;
        for (int i : counter) {
            if (i > 0) {
                answer ++;
            }
        }
        System.out.print(answer);
    }
```
- 42로 나눈 나머지의 경우의 수는 42가지. 카운터 배열을 하나 생성한다.
- 숫자를 입력받고 42로 나눈 인덱스의 카운트를 1 증가시킨다.
- 카운터를 순서대로 탐색하여 0보다 큰 값이 있을 경우 answer를 증가시킨다.
- answer를 출력한다.

---
