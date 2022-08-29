# 8.09 조합 구하기
- 분류 : dfs
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 8.09)

---

## 풀이

### 정적 변수
```java
    private static int n; // 숫자 갯수
    private static int m; // 선택하는 숫자의 갯수
    private static int[] selectedNumbers; // 선택된 숫자
    private static StringBuilder sb;
```

### 입출력
```java
    public static void main(String[] args) throws IOException {
        n = readInt();
        m = readInt();
        String answer = solution();
        System.out.print(answer);
    }
```

### solution
```java

    private static String solution() {
        selectedNumbers = new int[m];
        sb = new StringBuilder();
        dfs(0, 1);
        return sb.toString();
    }
```

### DFS
```java
    private static void dfs(int index, int start) {
        if (index == m) {
            for (int selectedNumber : selectedNumbers) {
                sb.append(selectedNumber).append(' ');
            }
            sb.append('\n');
            return;
        }
        for (int i=start; i<=n; i++) {
            selectedNumbers[index] = i;
            dfs(index + 1, i+1);
        }
    }
```
- index가 m이면 선택된 숫자들을 sb에 append 한다.
- 반복 시작을 start로 둔다.
- 다음 재귀 호출 시에는 i+1를 호출하여 숫자 중복을 회피할 수 있다.

---
