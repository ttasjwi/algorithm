
# 3.3 최대 매출

- 분류 : 슬라이딩 윈도우(Sliding Window)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 3.3)

---

## 시간복잡도
- 한번씩 밀고 진행되기 떄문에 `o(n)`

## 풀이 : 슬라이딩 윈도우 사용
```java
    private static int solution(int[] arr, int n, int k) {
        int maxSum;
        int sum = 0;
        for (int i=0; i<k; i++) { // 맨 처음 윈도우의 크기인 k만큼 합을 구해놓는다.
            sum += arr[i];
        }
        maxSum = sum;

        for (int i=k; i<n; i++) {// 윈도우를 한칸씩 민다.
            sum += arr[i]; // 영역에 들어온 값을 더한다.
            sum -= arr[i-k]; // 영역 밖으로 벗어난 값을 뺀다.
            maxSum = Math.max(maxSum, sum); // 최댓값을 갱신한다.
        }
        return maxSum;
    }
```
- 우선 윈도우의 크기만큼의 합을 구해놓는다.
  - 초기 윈도우의 합만큼을 최댓값으로 초기화
- 윈도우를 한칸 밀면, 새로 영역에 속하는 값이 있고, 영역에서 벗어난 값이 존재한다.
  - 새로 영역에 들어온 값을 더 함
  - 영역에서 벗어난 값을 뺌
- 최댓값과 현재 합을 비교하여 최댓값을 갱신한다.


---

## 삽질
- 매번 윈도우를 밀 때마다 합을 새로 구해줬었다.
- 중복적인 부분만큼을 또 계속 계산하므로 시간 손실이 발생한다.
- 이 경우, 시간복잡도가 O(nk)가 되버린다.

---
