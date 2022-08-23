# \[BOJ 02577\] 숫자의 개수

- 난이도 : Bronze 2
- 나머지 연산 활용
- 문제 : https://www.acmicpc.net/problem/2577

---  

## 풀이
```java
    public static void main(String[] args) throws IOException {
        int number = readInt();
        number *= readInt();
        number *= readInt();

        int[] counter = new int[10];
        int tmp;
        while (number > 0) {
            tmp = number%10;
            counter[tmp] ++;
            number /= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : counter) {
            sb.append(i).append('\n');
        }
        System.out.print(sb);
    }
```
- 10으로 나눈 나머지가 끝 자리수
- 10으로 나눌 때마다 자리수가 하나씩 줄어든다.
- 배열에 숫자를 카운팅한다.

---
