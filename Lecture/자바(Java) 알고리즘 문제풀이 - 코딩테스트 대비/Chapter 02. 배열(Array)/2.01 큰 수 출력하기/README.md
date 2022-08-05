
# 2.01 큰 수 출력하기

- 분류 : 배열(Array)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 2.01)

---

## 풀이

### 입출력
```java
    public static void main(String[] args) throws IOException {
        int N = readInt();
        int[] numbers = new int[N+1];

        for (int i=1; i<=N; i++) {
            numbers[i] = readInt();
        }
        String answer = solution(numbers);
        System.out.print(answer);
    }
```
- 편의 상 배열을 생성할 때 숫자 갯수보다 한 칸 더 많이 생성한다.

### 로직
```java
    private static String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<numbers.length; i++) {
            if (numbers[i-1] < numbers[i]) {
                sb.append(numbers[i]).append(' ');
            }
        }
        return sb.toString();
    }
```
- 반복 돌려서 각 인덱스마다 이전 인덱스와 비교

---
