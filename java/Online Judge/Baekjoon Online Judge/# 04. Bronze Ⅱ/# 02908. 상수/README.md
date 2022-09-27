# \[BOJ 02908] 상수

- 난이도 : Bronze 2
- 숫자 뒤집어서 비교
- 문제 : <a href="https://www.acmicpc.net/problem/2908" target="_blank">링크</a>

---  

## 풀이
### 입력 : 뒤집어서 숫자 입력받기
```java
    private static int readReverse() throws IOException {
        int value = 0;

        value += (System.in.read() - 48);
        value += (System.in.read() - 48) * 10;
        value += (System.in.read() - 48) * 100;
        System.in.read();
        return value;
    }
```

### 로직
```java
    public static void main(String[] args) throws IOException {
        int a = readReverse();
        int b = readReverse();
        int answer = Math.max(a, b);
        System.out.print(answer);
    }
```
- 두 숫자를 뒤집어 입력받는다.
- 비교하여 큰 값을 출력
