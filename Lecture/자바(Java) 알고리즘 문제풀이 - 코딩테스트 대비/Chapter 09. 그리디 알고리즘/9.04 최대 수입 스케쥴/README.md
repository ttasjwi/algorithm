# 9.04 최대 수입 스케쥴
- 분류 : 그리디 알고리즘, PriorityQueue
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 9.4)

---

## 그리디 알고리즘
- 매 순간의 최적해가 전체의 최적해

## Priority Queue
- 정렬 기준으로 가장 먼저 오는 것을 먼저 꺼냄

---

## 풀이

### Lecture
```java
class Lecture implements Comparable<Lecture> {

  int money;
  int time;

  public Lecture(int money, int time) {
    this.money = money;
    this.time = time;
  }

  @Override
  public int compareTo(Lecture other) {
    return other.time - this.time; // 날짜 기준 내림차순
  }

}
```
- money : 강연료
- time : ~일안에 와야한다
- 시간 기준 내림차순 정렬

### 정적 변수
```java
    private static int n;
    private static Lecture[] lectures;
    private static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    private static int maxTime = Integer.MIN_VALUE;
```
- n : 강연 요청 수
- lectures : 강연들
- pq : 비용들을 저장하는 pq
- maxTime : 가장 마지막 날짜

### 입출력
```java

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        lectures = new Lecture[n];
        int money, time;
        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            money = Integer.parseInt(st.nextToken());
            time = Integer.parseInt(st.nextToken());

            maxTime = Math.max(maxTime, time);
            lectures[i] = new Lecture(money, time);
        }
        int answer = solution();
        System.out.print(answer);
    }
```
- 강의 배열에 강의들을 저장한다
- 입력을 받으면서, 가장 마지막 날짜를 구해둔다

### solution
```java
    private static int solution() {
        Arrays.sort(lectures);
        int sum = 0;
        int index = 0;
        for (int time=maxTime; time>=1; time --) {
            while(index < n && lectures[index].time >= time) {
                pq.offer(lectures[index].money);
                index ++;
            }
            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }
        return sum;
    }
```
- 강의들을 시간기준 내림차순 정렬한다
- 마지막 날짜-> 첫날 순으로 로직을 수행
  - 강의의 기한이 그 날짜 또는 이후에 해당하면 pq에 강의료를 삽입한다
  - pq가 비어있지 않으면 pq에서 가장 강의료가 비싼 강의를 꺼내서, sum에 합산한다
  - 비어있으면 그 날 강의는 없다

---
