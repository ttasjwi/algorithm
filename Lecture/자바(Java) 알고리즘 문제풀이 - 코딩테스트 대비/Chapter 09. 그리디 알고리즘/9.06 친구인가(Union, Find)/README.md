# 9.06 친구인가(Union, Find)
- 분류 : 서로소 집합(union, find)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 9.06)

---

## 풀이
### 정적 변수
```java
    private static int n; // 학생 수
    private static int m; // 숫자 쌍의 갯수
    private static int[] parent; // 부모
```
- n : 학생 수
- m : 숫자 쌍의 갯수
- parent : 부모
  - 기본적으로는 자기 자신을 부모로 갖도록 함

### findParent
```java
    private static int findParent(int x) {
        // 루트가 아니라면, 루트를 찾을 때까지 재귀적 호출
        if (parent[x] == x) {
            return parent[x];
        }
        return parent[x] = findParent(parent[x]); // 경로 압축
    }
```
- 인덱스와 저장값(부모)이 같으면 루트 노드이다. 바로 저장값 반환
- 그렇지 않으면 저장값을 인자로 넘겨 재귀적으로 호출하여, 루트 노드를 찾은 뒤 자신의 저장값을 루트노드로 하도록 한다.
  - 마지막에 자기 자신의 부모를 루트 노드로 변경함으로서 경로 압축이 가능하다.

### unionParent
```java

    private static void unionParent(int a, int b) {
        int rootA = findParent(a);
        int rootB = findParent(b);

        if (rootA < rootB) {
            parent[rootB] = rootA;
        } else if (rootA > rootB) {
            parent[rootA] = rootB;
        }
    }
```
- 루트 노드를 찾고, 통일한다.

### main
```java

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for (int i=1; i<=n; i++) parent[i] = i;
        m = Integer.parseInt(st.nextToken());

        int a, b;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            unionParent(a, b);
        }

        st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        String answer = (findParent(a) == findParent(b)) ? "YES" : "NO";
        System.out.print(answer);
    }
```
- 입출력을 받고 union 시켜간다.
- 마지막 인자 두개에 대해 findParent하여, 루트가 같으면 YES, 다르면 NO 출력

---
