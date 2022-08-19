# 6.04 Least Recently Used

- 분류 : 뒤로 밀기(삽입정렬 아이디어 차용)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 6.04)

---

## 풀이

### 1. 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken()); // 캐시의 크기
        int n = Integer.parseInt(st.nextToken()); // 작업의 갯수

        int[] cache = new int[s];
        int[] works = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        br.close();

        for (int i=0; i<n; i++) {
            works[i] = Integer.parseInt(st.nextToken());
        }

        String answer = solution(cache, works, s);
        System.out.print(answer);
    }
```
- cache 배열, work 배열을 입력받는다.
- 로직 수행후 answer를 출력한다.

### 2. 풀이 로직
```java
    // 로직을 수행하고 출력 문자열을 생성한다.
    private static String solution(int[] cache, int[] works, int s) {
        logic(cache, works, s);
        StringBuilder sb = new StringBuilder();
        for (int i : cache) {
            sb.append(i).append(' ');
        }
        return sb.toString();
    }

    // 순서대로 LRU 캐싱 알고리즘을 수행한다.
    private static void logic(int[] cache, int[] works, int s) {
        for (int work : works) {
            int sameWorkIndex = findSameWorkIndex(cache, s, work);
            if (sameWorkIndex == -1) {
                cacheMiss(cache, s, work);
            } else {
                cacheHit(cache, s, sameWorkIndex, work);
            }
        }
    }
```
- LRU 캐싱 알고리즘을 수행 후 cache 배열의 결과를 순차적으로 StringBuilder에 append 하여 반환한다.
- findSameWorkIndex : work와 같은 값을 저장한 인덱스를 탐색함
  - cacheMiss : 인덱스가 없으면 모든 캐싱된 작업들을 뒤로 밀고 work를 0번 인덱스에 삽입
  - cacheHit : 인덱스가 있으면 해당 인덱스까지 캐싱된 작업들을 밀고 work를 0번 인덱스에 삽입

### 3. findSameWorkIndex
```java
    // 같은 work가 위치한 인덱스를 찾는다.
    private static int findSameWorkIndex(int[] cache, int s, int work) {
        for (int i=0; i<s; i++) {
            if (cache[i] == work) {
                return i;
            }
        }
        return -1;
    }
```
- work와 같은 값을 저장한 인덱스를 찾아 반환한다. 없으면 -1을 반환

### 4. pushToRight, cacheMiss, cacheHit
```java

    // 배열 끝까지 모든 요소를 뒤로 민뒤, 0번 인덱스에 새 작업을 삽입한다.
    private static void cacheMiss(int[] cache, int s, int work) {
        pushToRight(cache, s, s-1);
        cache[0] = work;
    }

    // 이미 work가 위치해있던 인덱스까지 모든 요소를 밀어버리고 0번 인덱스에 work를 삽입한다.
    private static void cacheHit(int[] cache, int s, int sameWorkIndex, int work) {
        pushToRight(cache, s, sameWorkIndex);
        cache[0] = work;
    }

    // pushEnd 인덱스까지 값들을 밀어버린다.
    private static void pushToRight(int[] cache, int s, int pushEnd) {
        if (pushEnd >= s) {
            pushEnd = s-1;
        }
        int i;
        for (i= pushEnd; i>=1; i--) {
            cache[i] = cache[i-1];
        }
    }
```
- pushToRight : 배열의 해당 인덱스까지 모든 값들을 오른쪽으로 밀어버린다.
- cacheMiss : 끝까지 민 후 0번 인덱스에 삽입
- cacheHit : work가 위치한 인덱스까지 밀고 0번 인덱스에 삽입

---
