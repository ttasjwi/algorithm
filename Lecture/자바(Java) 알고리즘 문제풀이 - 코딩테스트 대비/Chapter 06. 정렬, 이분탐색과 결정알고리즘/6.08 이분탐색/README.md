# 6.08 이분탐색

- 분류 : 이분탐색
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 6.08)

---

## 풀이
### 입출력
```java
    private static int solution(int[] numbers, int n, int m) {
        Arrays.sort(numbers);
        int lt = 0;
        int rt = n-1;
        int mid = -1;
        while (lt<=rt) {
            mid = (lt+rt)/2;
            if (numbers[mid] == m) {
                break;
            } else if (numbers[mid] < m) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return mid + 1;
    }
```
- 이분탐색을 하기 위해서 정렬
- lt : 탐색 시작
- rt : 탐색의 끝
- mid : lt, rt의 평균값(가운데값). 찾고자하는 값으로 추정하는 값
- while문 돌림(lt가 rt보다 커질 때까지)
  - mid를 lt, rt의 평균값으로 갱신한다
  - 숫자의 mid 인덱스에 위치한 값이 m과 같으면 break한다.
  - 숫자의 mid 인덱스에 위치한 값이 m보다 작으면 lt를 mid + 1로 하여 더 뒷범위에서 탐색한다.
  - 숫자의 mid 인덱스에 위치한 값이 m보다 크면 rt를 mid-1로 하여 더 앞 범위에서 탐색한다.

---
