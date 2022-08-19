# 6.05 중복확인

- 분류 : 정렬 / HashSet / DP
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 6.05)

---

## 풀이1 : 정렬 활용
```java
    private static String solution(int[] numbers, int n) {
        Arrays.sort(numbers);
        for (int i=0; i<n-1; i++) {
            if (numbers[i] == numbers[i+1]) {
                return "D";
            }
        }
        return "U";
    }
```
- 숫자를 오름차순 정렬한다. : O(nlogn)
- 배열을 순차적으로 탐색했을 때 앞의 값과 같은 값이 하나라도 나오면 중복값이 있다는 뜻이다.

## 풀이2 : HashSet 활용
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 캐시의 크기
        HashSet<Integer> numbers = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        String answer = "U";
        int input;
        for (int i=0; i<n; i++) {
           input = Integer.parseInt(st.nextToken());
           if (numbers.contains(input)) {
               answer = "D";
               break;
           }
           numbers.add(input);
        }
        System.out.print(answer);
    }
}
```
- HashsSet에 순서대로 입력값을 저장한다.
- 컬렉션에 입력값이 이미 존재하면 중복값이 있다는 뜻이다.

## 풀이3 : 배열에 입력값을 저장하여 재사용(DP)
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 캐시의 크기
        int[] numbers = new int[10_000_001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int input;
        String answer = "U";
        for (int i=0; i<n; i++) {
           input = Integer.parseInt(st.nextToken());
           if (numbers[input] == input) {
               answer = "D";
               break;
           }
           numbers[input] = input;
        }
        System.out.print(answer);
    }
```
- 숫자 범위가 1~1_000_000이므로, 크기가 1_000_001 인 배열을 만든다.
- 같은 인덱스에 이미 값이 저장되어 있으면 중복값이 존재한다는 뜻이다.

---
