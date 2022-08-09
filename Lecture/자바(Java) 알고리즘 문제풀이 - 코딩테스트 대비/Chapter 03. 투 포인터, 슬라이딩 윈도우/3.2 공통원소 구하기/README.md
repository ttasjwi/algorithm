
# 3.2 공통원소 구하기

- 분류 : 투 포인터(Two Pointers)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 3.2)

---

## 풀이 : 투 포인터 사용
```java
    private static String solution(int[] numbers1, int[] numbers2, int n, int m) {
        int p1 = 0;
        int p2 = 0;

        Arrays.sort(numbers1);
        Arrays.sort(numbers2);

        StringBuilder sb = new StringBuilder();

        while (p1<n && p2 <m) {
            if (numbers1[p1] == numbers2[p2]) {
                sb.append(numbers1[p1]).append(' ');
                p1 ++;
                p2 ++;
            } else if (numbers1[p1] < numbers2[p2]) {
                p1 ++;
            } else {
                p2 ++;
            }
        }
        return sb.toString();
    }
```
- 오름차순으로 공통원소를 찾기 위해 우선 배열을 오름차순으로 정렬
  - `Arrays.sort(...)`
- 투 포인터로 각 배열의 원소를 순차적으로 비교하여
  - 같으면 StringBuilder에 담음. p1, p2 증가
  - 한쪽이 작으면 작은 쪽의 포인터 증가
- 둘 중 어느 하나가 배열 범위를 벗어나면 더 이상 공통 원소가 없다.

---
