
# \[BOJ 02754\] 학점계산

- 난이도 : Bronze5
- 등급 입력 받고 대응되는 점수 반환하기
- 문제: <a href="https://www.acmicpc.net/problem/2754" target="_blank"> [링크]</a>

---

## 풀이
```java
public static void main(String[] args) throws IOException {
    HashMap<String, String> map = new HashMap<>();
    map.put("A+", "4.3");
    map.put("A0", "4.0");
    map.put("A-", "3.7");
    map.put("B+", "3.3");
    map.put("B0", "3.0");
    map.put("B-", "2.7");
    map.put("C+", "2.3");
    map.put("C0", "2.0");
    map.put("C-", "1.7");
    map.put("D+", "1.3");
    map.put("D0", "1.0");
    map.put("D-", "0.7");
    map.put("F", "0.0");

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    br.close();

    String answer = map.get(line);
    System.out.print(answer);
}
```
- 시간 복잡도 : 해시테이블을 사용하므로 O(1)

---

## 그 외의 풀이법
- 조건문 (if, switch-case문)

---