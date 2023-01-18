# 9.2 회의실 배정
- 분류 : 그리디 알고리즘
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 9.2)

---

## 그리디 알고리즘
- 매 순간의 최적해가 전체의 최적해

---

## 풀이

### 시간
```java
class Time implements Comparable<Time> {

    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o) {
        if (this.end == o.end) {
            return this.start - o.start;
        }
        return this.end - o.end;
    }
}
```
- 빨리 끝나는 회의일 수록 다른 회의들이 더 회의를 차지하기 좋다.
- 같은 시간에 끝나더라도 빨리 시작하는 회의가 더 우선순위가 높다.


### 정적변수
```java
    private static int n; // 사용하고자 하는 회의 수
    private static Time[] times; // 시간들
```

### main
```java
    public static void main(String[] args) throws IOException {
        input();
        int answer = solution();
        System.out.print(answer);
    }
```

### 입력
```java

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        times = new Time[n];

        StringTokenizer st;
        int start, end;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            times[i] = new Time(start, end);
        }
        br.close();
    }
```

### solution
```java
    private static int solution() {
        Arrays.sort(times);
        int beforeEnd = 0;
        int answer = 0;
        for (Time time : times) {
            if (beforeEnd <= time.start) {
                beforeEnd = time.end;
                answer++;
            }
        }
        return answer;
    }
```
- 종료시간 기준(같다면 시작시간 오름차순) 오름차순으로 정렬
- 우선순위 순서대로, 회의시간 목록을 읽어서, 시작할 수 있는 회의이면 시작시킨다.
  - 진행한 회의 갯수를 증가시킨다.

---
