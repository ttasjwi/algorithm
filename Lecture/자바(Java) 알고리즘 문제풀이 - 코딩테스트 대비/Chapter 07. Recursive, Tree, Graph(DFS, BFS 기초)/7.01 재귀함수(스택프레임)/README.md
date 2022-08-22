# 7.01 재귀함수(스택프레임)
- 분류 : 재귀함수
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 7.01)

---

## 재귀
- 알아둘 지식 : 스택프레임
  - 메서드가 호출되면 새로운 해당 메서드의 스택프레임이 현재 메서드의 스택프레임 위에 쌓인다.
  - 최상단의 스택프레임의 메서드가 순서대로 실행된다.
- 종료조건에 주의 : 종료조건을 제대로 설정하지 않으면 스택이 계속 쌓여서 `StackOverFlow`가 발생

---

## 풀이
### 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        String answer = solution(n);
        System.out.print(answer);
    }
```

### 로직
```java
    private static String solution(int n) {
        StringBuilder sb = new StringBuilder();
        return recursive(n, sb).toString();
    }
```
- recursive 메서드를 호출하여 순서대로 문자열을 생성한다.
- toString으로 문자열로 반환

### recursive(재귀함수)
```java
    private static StringBuilder recursive(int n, StringBuilder sb) {
        if (n > 1) {
            recursive(n-1, sb);
        }
        sb.append(n).append(' ');
        return sb;
    }
```
- n이 1보다 크면 n-1을 인자로 하여, 재귀호출한다.
- n이 1이 되면, sb에 자기 자신을 append 한다.
- `recursive(1)` 스택프레임이 pop되고, `recursive(2)`가 이어서 작동한다.
- ...
- 최 상단 스택프레임에 있는 숫자부터 순서대로 출력할 수 있도록 한다.

---
