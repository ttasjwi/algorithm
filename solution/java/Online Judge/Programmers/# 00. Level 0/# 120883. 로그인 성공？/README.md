# 문제
- 번호 : 120883
- 제목 : 로그인 성공?
- 난이도 : Level 0
- 2차원 배열 db가 주어질 때, 다음과 같이 로그인 성공, 실패에 따른 메시지를 return
- 문제 : [링크](https://school.programmers.co.kr/learn/courses/30/lessons/120883)

---

# 필요 알고리즘
- 해시

---

# 풀이
```java
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String solution(String[] id_pw, String[][] db) {
        Map<String, String> map = new HashMap<>();

        for (String[] accounts : db) {
            map.put(accounts[0], accounts[1]);
        }

        String loginId = id_pw[0];
        String password = id_pw[1];

        if (!map.containsKey(loginId)) {
            return "fail";
        } else if (!map.get(loginId).equals(password)) {
            return "wrong pw";
        } else {
            return "login";
        }
    }
}
```
- HashMap에 `db[][]`의 id, pw 쌍을 모두 저장한다.
  - 이제 id를 통해 O(1)로 pw에 접근할 수 있다.
- 사용자 id로 map에 접근하여
  - key가 없으면 "fail" 반환
  - key가 있는데, value가 일치하지 않으면 "wrong pw" 반환
  - 그 외의 경우 :key를 통해 접근한 value가 일치하면 "login" 반환

---
