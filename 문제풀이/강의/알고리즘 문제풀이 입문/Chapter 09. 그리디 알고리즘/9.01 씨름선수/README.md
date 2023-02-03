# 9.1 씨름선수
- 분류 : 그리디 알고리즘
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 9.1)

---

## 그리디 알고리즘
- 매 순간의 최적해가 전체의 최적해

---

## 풀이
### Body
```java
class Body implements Comparable<Body> {

    int height;
    int weight;

    public Body(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Body other) {
        return other.height - this.height; // 키 기준 내림차순 정렬
    }
}
```
- 키와 몸무게
- 키 기준 내림차순 정렬하도록 Comparable 구현
- 
### 정적 변수
```java
    private static int n;
    private static Body[] bodies;
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
        bodies = new Body[n];

        StringTokenizer st;
        int height, weight;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            height = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());
            bodies[i] = new Body(height, weight);
        }
        br.close();
    }
```

### solution
```java

    private static int solution() {
        Arrays.sort(bodies); //키를 기준으로 내림차순 정렬
        int answer = 0;
        int maxWeight = Integer.MIN_VALUE;
        for (Body body : bodies) {
            if (body.weight > maxWeight) { // 키는 앞의 사람이 무조건 크고, 몸무게가 더 커야 살아남음
                answer ++;
                maxWeight = body.weight;
            }
        }
        return answer;
    }
```
- 키를 기준으로 내림차순 정렬한다.
- 앞의 사람이 키는 무조전 크다.
- 이전 사람들의 몸무게 중 최대 몸무게를 확인하여
  - 더 작다면 탈락
  - 더 크면 통과, 최대 몸무게 갱신
- 이렇게 하면 시간 복잡도는 O(n)이 된다.

---
