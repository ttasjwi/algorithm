# 4.5 K번째 큰 수

- 분류 : TreeSet(정렬된 Set)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 4.5)

---

## 풀이
```java
    private static int solution(int[] numbers, int n, int k) {
        TreeSet<Integer> sums = new TreeSet<>(Comparator.reverseOrder());

        for (int t=0; t<n; t++) {
            for (int u=t+1; u<n; u++) {
                for (int v=u+1; v<n; v++) {
                    sums.add(numbers[t] + numbers[u] + numbers[v]);
                }
            }
        }

        if (sums.size() < k) {
            return -1;
        }

        return (Integer) sums.toArray()[k-1];
    }
```
- TreeSet을 생성(정렬 기준은 내림차순으로 한다.)
- 3중 for문 돌면서 합을 입력받고 TreeSet에 저장한다.
- size가 k보다 작으면, -1 반환
- size가 k이상이면 배열의 k-1번쨰 값을 반환 

---
