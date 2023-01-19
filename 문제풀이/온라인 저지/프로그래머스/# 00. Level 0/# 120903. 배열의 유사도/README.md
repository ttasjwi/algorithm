# 문제
- 플랫폼 : 프로그래머스
- 번호 : 120903
- 제목 : 배열의 유사도
- 난이도 : Level 0
- 문자열 배열 s1과 s2가 주어질 때 같은 원소의 개수를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120903)

---

# 필요 알고리즘
- 해시
- Set

---

# Python
## 풀이1
```python
def solution(s1, s2):
    return sum(1 for word in s1 if word in s2)
```
- 리스트 컴프리헨션 활용
- s1의 각 요소들이 s2에 포함되어 있는지 판단한 후 sum으로 합산


## 풀이2
```python
def solution(s1, s2):
    return len(set(s1)&set(s2))
```
- s1, set2를 set으로 변환한후, 이들의 교집합(집합 교집합 연산자 `&` 사용)을 구한뒤 len을 반환

---

## Java
```java
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(String[] s1, String[] s2) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        for (String s : s1) {
            set1.add(s);
        }

        for (String s : s2) {
            set2.add(s);
        }

        set1.retainAll(set2);
        return set1.size();
    }

    static class Solution2 {
        public int solution(String[] s1, String[] s2) {
    
        }
    }
}
```
- Python 2번째 풀이와 유사
- retainAll을 통해 교집합을 구하고 이 집합의 원소의 갯수를 반환하면 된다.

---
