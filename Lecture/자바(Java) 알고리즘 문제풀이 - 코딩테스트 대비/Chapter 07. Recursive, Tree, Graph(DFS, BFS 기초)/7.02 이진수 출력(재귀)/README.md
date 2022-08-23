# 7.02 이진수 출력(재귀)
- 분류 : 재귀함수
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 7.02)

---

## 풀이
### 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        
        StringBuilder answer = solution(n);
        System.out.print(answer);
    }
```

### 로직
```java
    private static StringBuilder solution(int n) {
        StringBuilder sb = new StringBuilder();
        return recursive(n, sb);
    }
    
    private static StringBuilder recursive(int n, StringBuilder sb) {
        if (n==0) {
            return sb;
        }
        recursive(n/2, sb);
        sb.append(n%2);
        return sb;
    }
```
- n부터 시작
- `n/2`를 인자로 한 재귀함수를 호출한다.
  - `n==0`이 될 때 종료한다.
- `StringBuilder`에 나머지를 append한다.
- 이 방식대로면 2를 나눈 나머지들이 역순으로 append된다.
- `StringBuilder`를 반환한다.

---
