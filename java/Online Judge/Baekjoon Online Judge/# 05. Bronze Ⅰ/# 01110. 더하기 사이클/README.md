# \[BOJ 01110\] 더하기 사이클

- 난이도 : Bronze1
- 사칙연산, 반복문 활용
- 문제 : <a href="https://www.acmicpc.net/problem/1110" target="_blank"> [링크]</a>

---  

## 풀이
```java
    public static void main(String[] args) throws IOException {
        int original, number;
        original = number = readInt();

        int count = 0;

        do {
            count++;
            number = (number % 10 * 10) + (number / 10 + number % 10) % 10;

        } while (number != original);
        System.out.print(count);
    }
```
- 처음 입력받은 숫자를 토대로 연산을 해야하는데 최초값과 비교해야한다.
  - 하나는 origin에 저장해서 그대로 유지
  - 하나는 number에 저장해서 연산에 사용
- while문을 통해 number와 original이 다른지 확인해야한다.
  - 처음엔 같을 수밖에 없으므로 do while문으로 사용
- 문제에서 주어진 대로 숫자값을 조작하면 된다.

---
