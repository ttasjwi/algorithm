# 4.3 매출액의 종류

- 분류 : 해시 테이블, 슬라이딩 윈도우
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 4.3)

---

## 풀이
```java
    private static String solution(int[] numbers, int n, int k) {
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> counter = new HashMap<>();

        for (int i=0; i<k; i++) {
            int number = numbers[i];
            counter.put(number, counter.getOrDefault(number, 0) + 1);
        }
        sb.append(counter.size()).append(' ');

        for (int rt=k; rt<n; rt++) {
            int ltNumber = numbers[rt-k];
            int rtNumber = numbers[rt];

            if (counter.get(ltNumber) == 1) { // 하나 남아 있으면 제거
                counter.remove(ltNumber);
            } else {
                counter.put(ltNumber, counter.get(ltNumber) - 1);
            }

            counter.put(rtNumber, counter.getOrDefault(rtNumber, 0) + 1);
            sb.append(counter.size()).append(' ');
        }

        return sb.toString();
    }
```
- k개까지 매출액들을 HashMap으로 카운팅한다.
- size를 계산해서 이 값을 sb에 append 한다.
- 윈도우를 밀면서 카운터의 저장 데이터를 조정한다.
- size를 계산 후 매번 append 한다.

---
