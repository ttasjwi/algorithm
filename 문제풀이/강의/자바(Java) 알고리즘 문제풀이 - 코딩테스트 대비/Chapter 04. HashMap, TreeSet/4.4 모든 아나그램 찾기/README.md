# 4.4 모든 아나그램 찾기

- 분류 : 해시 테이블, 슬라이딩 윈도우
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 4.4)

---

## 풀이
```java
    private static int solution(String s, String t) {
        int count = 0;
        int sl = s.length();
        int tl = t.length();

        // t 카운팅
        HashMap<Character, Integer> tCounter = new HashMap<>();
        for (int i=0; i<tl; i++) {
            tCounter.put(t.charAt(i), tCounter.getOrDefault(t.charAt(i), 0) + 1);
        }

        // s의 앞부분 카운팅
        HashMap<Character, Integer> sCounter = new HashMap<>();
        for (int i=0; i<tl; i++) {
            sCounter.put(s.charAt(i), sCounter.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (tCounter.equals(sCounter)) {
            count ++;
        }

        // 슬라이딩
        for (int i=tl; i<sl; i++) {
            if (sCounter.get(s.charAt(i-tl)) == 1) {
                sCounter.remove(s.charAt(i-tl));
            } else {
                sCounter.put(s.charAt(i-tl), sCounter.get(s.charAt(i-tl)) - 1);
            }
            sCounter.put(s.charAt(i), sCounter.getOrDefault(s.charAt(i), 0) + 1);

            if (tCounter.equals(sCounter)) {
                count ++;
            }
        }
        return count;
    }
```
- 문자 s,t에 대해
  - t를 먼저 카운팅해둔다.
- s는 슬라이딩 윈도우를 적용해가면서 카운팅을 변화한다.
- 변화시킬 때마다 t카운터와 s카운터를 `equals`로 비교한다.

---
