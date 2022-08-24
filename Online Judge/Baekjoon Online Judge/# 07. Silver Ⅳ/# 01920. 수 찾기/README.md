# \[BOJ 01920\] 수 찾기

- 난이도 : Silver 4
- 이분 탐색
- 문제 : <a href="https://www.acmicpc.net/problem/1920" target="_blank"> [링크]</a>

---  

## 풀이
### 전체 로직 개요
```java

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = readInt(); // 배열 입력
        }
        Arrays.sort(numbers); // 정렬!!!!

        StringBuilder sb = new StringBuilder();
        int m = readInt();
        int input;
        for (int i = 0; i < m; i++) {
            input = readInt();
            binarySearch(numbers, n, input, sb); // 이분 탐색
        }
        System.out.print(sb);
    }
```
- 우선 숫자 배열을 입력 받는다.
- 이분탐색을 위해 배열을 정렬한다.
- 숫자를 입력받을 때마다, 이진탐색을 하여 sb에 결과를 append한다.

### 이분탐색
```java
    private static void binarySearch(int[] numbers, int n, int search, StringBuilder sb) {
        int lt;
        int rt;
        int mid;
        lt = 0;
        rt = n - 1;

        while (lt <= rt) {
            mid = (lt + rt) /2;
            if (numbers[mid] == search) {
                sb.append('1').append('\n');
                return;
            } else if (numbers[mid] > search) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        sb.append('0').append('\n');
    }
```
- 배열의 인덱스 양끝값을 lt, rt로 둔다.
- 이들을 기준으로 가운데 값을 mid로 잡고 mid를 조절해가면서 이분탐색한다.

---
