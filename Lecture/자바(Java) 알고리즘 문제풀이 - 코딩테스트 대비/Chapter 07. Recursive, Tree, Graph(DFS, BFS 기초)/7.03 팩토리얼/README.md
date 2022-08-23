# 7.03 팩토리얼
- 분류 : 재귀함수
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 7.03)

---

## 주의
- 숫자 범위가 `1<= n <= 100`이므로, 팩토리얼 계산값이 long 을 벗어난다.
- 따라서 BigInteger를 써야한다.

---

## 풀이
### 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        BigInteger answer = recursive(n);
        System.out.print(answer);
    }
```

### 로직
```java
    private static BigInteger recursive(int n) {
        if (n==0) {
            return BigInteger.ONE;
        }
        return BigInteger.valueOf(n).multiply(recursive(n-1));
    }
```
- `n == 0` : 1 반환
- 그 외 : 숫자값과, n-1 팩토리얼 계산 재귀함수의 곱을 반환한다.

---
