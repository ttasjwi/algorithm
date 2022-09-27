# 5.8 응급실

- 분류 : Queue
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 5.8)

---

## Queue 지식
- Queue는 `first in, first out`의 fifo 구조
- `java`에서는 `Queue` 인터페이스가 있고, `LinkedList`가 이를 구현하고 있는데 주로 이를 많이 사용한다.
- offer : 삽입
- poll : 첫번째 요소를 제거
- peek : 첫번째 요소를 확인

---

## 풀이
### Person 클래스
```java
class Person {

    int id;
    int level;

    public Person (int id, int level) {
        this.id = id;
        this.level = level;
    }

}
```
- 식별자 : id
- 격리 수준 : level

### 입출력
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()); // 환자수
        int m = Integer.parseInt(st.nextToken()); // m번째 환자는 몇 번째로 진료 받는가?

        Person[] people = new Person[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++) {
            int level = Integer.parseInt(st.nextToken());
            people[i] = new Person(i, level);
        }
        br.close();
        
        int answer = solution(people, n, m);
        System.out.print(answer);
    }
```
- 사람을 입력받을 때 객체로 저장한다.

### 로직
```java
    private static int solution(Person[] people, int n, int m) {
        int answer = 0; // 진료를 본 사람의 수
        Queue<Person> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            q.offer(people[i]);
        }

        while(!q.isEmpty()) {
            Person current = q.poll();
            for (Person other : q) {
                if (current.level < other.level) {
                    // 나머지 사람들 중에 우선순위가 높은 사람이 있다면
                    q.offer(current);
                    current = null;
                    break;
                }
            }
            if (current != null) {
                answer ++;
                if (current.id == m) break;
            }
        }
        return answer;
    }
```
- Queue에 사람들을 순서대로 저장한다.
- Queue가 빌 때까지 반복
  - queue에서 사람을 하나 poll하고, Queue를 전부 뒤져서 우선순위가 더 높은 사람이 있는 지 찾는다.
  - 우선순위가 더 높은 사람이 있으면 queue에 다시 offer 시킨다.
  - 우선순위가 더 높은 사람이 없으면, answer를 증가시킨다.
    - 이때, 사람의 식별자를 확인했을 때 m과 같으면 break 하고 answer를 반환한다.
---
