# 9.3 결혼식
- 분류 : 그리디 알고리즘
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 9.3)

---

## 그리디 알고리즘
- 매 순간의 최적해가 전체의 최적해

---

## 풀이

### Event
```java
class Event implements Comparable<Event> {

    int when;
    boolean isEnd;

    public Event(int when, boolean isEnd) {
        this.when = when;
        this.isEnd = isEnd;
    }


    @Override
    public int compareTo(Event other) {
        if (this.when == other.when) {
            if (isEnd && !other.isEnd) {
                return -1;
            } else if (!isEnd && other.isEnd) {
                return 1;
            } else {
                return 0;
            }
        }
        return this.when - other.when;
    }
}
```
- when : 언제
- isEnd : 나가는지(true), 들어오는지(false)
- 시간을 기준으로 정렬하되, 시간이 같다면 나가는 것을 우선으로 하여 집계한다


### 정적변수
```java
    private static int n; // 참석 인원수
    private static Event[] events;
```

### main
```java
    public static void main(String[] args) throws IOException {
        input();
        int answer = solution();
        System.out.print(answer);
    }
```

### input
```java
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        events = new Event[2*n];
        StringTokenizer st;
        for (int i=0; i<2*n; i+= 2) {
            st = new StringTokenizer(br.readLine(), " ");
            events[i] = new Event(Integer.parseInt(st.nextToken()), false);
            events[i+1] = new Event(Integer.parseInt(st.nextToken()), true);
        }
        br.close();
    }
```
- 한번 입력받을 때, 들어오는 이벤트/ 나가는 이벤트 객체 두개를 만든다

### solution
```java
    private static int solution() {
        Arrays.sort(events);
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (Event event : events) {
            if (event.isEnd) count --;
            else count ++;
            max = Math.max(max, count);
        }
        return max;
    }
```
- 이벤트를 시간순(나가는 것 우선) 정렬
  - 들어오는 것을 우선으로 정렬하면 동시간대에 나가는 사람이 같이 존재하는 모순이 발생한다
  - 일엏게 하면 매 시간 종료 시점 존재하는 사람의 수의 정합성이 맞다
- 이벤트를 순서대로 탐색한다
- 나가는 이벤트면 count 감소
- 들어오는 이벤트면 count 증가
- 매순간 count 최댓값을 갱신
