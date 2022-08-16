# 5.6 공주 구하기

- 분류 : Queue
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 5.6)

---

## Queue 지식
- Queue는 `first in, first out`의 fifo 구조
- `java`에서는 `Queue` 인터페이스가 있고, `LinkedList`가 이를 구현하고 있는데 주로 이를 많이 사용한다.
- offer : 삽입
- poll : 첫번째 요소를 제거
- peek : 첫번째 요소를 확인

---

## 풀이
### 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        int n = Integer.parseInt(st.nextToken()); // 숫자의 갯수
        int k = Integer.parseInt(st.nextToken()); // 몇 번째?

        int answer = solution(n, k);
        System.out.print(answer);
    }
```
- n : 숫자 갯수
- k : 몇 번째

### 로직
```java
    private static int solution(int n, int k) {
        Queue<Integer> queue = new LinkedList();

        for (int i=1; i<=n; i++) queue.offer(i);

        while (queue.size() != 1) {
            for (int i=0; i<k-1; i++) queue.offer(queue.poll()); // k-1번째까지는 뺐다 넣는다.
            queue.poll(); // k번째 요소는 제거한다.
        }
        return queue.poll(); // 마지막 남은 단 하나를 반환한다.
    }
```
- 1~n까지를 queue에 offer한다.
- queue의 size가 1이 될 때까지 반복한다.
  - k-1번 맨 앞 요소를 맨 뒤로 보낸다. (poll -> offer)
  - k번째 요소를 제거한다. (poll)
- 마지막 남은 단 하나를 poll해서 반환한다.

---
