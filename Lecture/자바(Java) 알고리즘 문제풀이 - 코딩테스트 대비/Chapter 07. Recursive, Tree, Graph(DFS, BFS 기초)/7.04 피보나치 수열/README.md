# 7.04 피보나치 수열
- 분류 : 재귀함수, 메모이제이션(DP)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 7.04)

---

## 풀이

### 정적 배열
```java
    private static int[] numbers;
```
- 숫자들을 기록하기 위해 static 배열 변수를 하나 준비한다.

### 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        StringBuilder answer = solution(n);
        System.out.print(answer);
    }
    
    private static StringBuilder solution(int n) {
        numbers = new int[n+1];
        recursive(n);

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n; i++) {
            sb.append(numbers[i]).append(' ');
        }
        return sb;
    }
```
- recursive 수행 후, 배열에 저장된 값을 순서대로 Sb에 append한다.

### 로직
```java
    private static int recursive(int i) {
        if (numbers[i] > 0) {
            return numbers[i];
        }
        if (i ==  1 || i == 2) {
            return numbers[i] = 1;
        }
        return numbers[i] = recursive(i-2) + recursive(i-1);
    }
```
- `numbers[i]` 값이 0보다 크다는 것은 이미 값이 계산됐다는 뜻이다. 꺼내서 쓴다.
  - 값을 재사용하기 때문에, 이미 계산한 값을 다시 계산하는 불필요한 시간 낭비를 없앨 수 있다.
- 그렇지 않다는 것은 값이 계산되지 않았다는 것이다.
- `i==1` 또는 `i==2` 일 경우, 배열 값을 1로 계산하고 반환한다.
- 그렇지 않을 경우 피보나치 로직에 따라 재귀함수를 호출하여 값을 기록하고 반환한다.

---
