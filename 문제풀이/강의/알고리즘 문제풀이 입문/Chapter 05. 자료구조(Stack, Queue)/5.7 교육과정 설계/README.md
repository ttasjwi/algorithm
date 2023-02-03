# 5.7 교육과정 설계

- 분류 : Queue
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 5.7)

---

## Queue 지식
- Queue는 `first in, first out`의 fifo 구조
- `java`에서는 `Queue` 인터페이스가 있고, `LinkedList`가 이를 구현하고 있는데 주로 이를 많이 사용한다.
- offer : 삽입
- poll : 첫번째 요소를 제거
- peek : 첫번째 요소를 확인

---

## 풀이1 : 내 풀이

```java
    private static String solution(String order, String plan) {
        Queue<Character> queue = new LinkedList<>();
        for (char ch : plan.toCharArray()) queue.offer(ch);
        boolean find;

        for (char o : order.toCharArray()) {
            find = false;
            while(!queue.isEmpty()) {
                if (queue.poll() == o) {
                    find = true;
                    break;
                }
            }

            if (find) {
                continue;
            } else {
                return "NO";
            }
        }
        return "YES";
    }
```
- order: 정해진 순서
- queue에 수강하려는 계획 과목들을 순서대로 삽입한다.
- queue에서 정해진 순서의 현재 순서 과목과 일치할 때까지 계속 꺼낸다.
  - 일치하는 과목을 찾았다면 find 플래그를 true로 한다.
- 만약 현재 과목을 찾았다면(`find == true`) 다음 반복으로 넘어가고, 못 찾았다면 "NO"를 반환한다.
- 별 문제 없었다면, "YES"를 반환한다.

---

## 풀이2 : 강사님 방식
```java
    private static String solution(String order, String plan) {
        Queue<Character> queue = new LinkedList<>();
        for (char o : order.toCharArray()) queue.offer(o);

        for (char p : plan.toCharArray()) { // plan에서 p를 순서대로 꺼낸다.

            if (queue.contains(p)) { // 큐에서 p를 포함하고 으면
                if (p!=queue.poll()) {
                    // queue에서 문자를 꺼낸다. 근데 p와 같지 않으면 순서가 맞지 않다는 뜻이다.
                    return "NO";
                }
            }
        }
        return (queue.isEmpty()) ? "YES" : "NO";
    }
```
- 위와 비슷하게 Queue를 사용하는데, 기준점을 반대로 돌린 것과 비슷하다.
- 내 생각엔 복잡도는 내가 짠 방식이 더 낫지 않을까 싶다.

---