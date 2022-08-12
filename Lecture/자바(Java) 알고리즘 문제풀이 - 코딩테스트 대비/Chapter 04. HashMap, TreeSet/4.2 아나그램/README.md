# 4.2 아나그램

- 분류 : 해시 테이블
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 4.2)

---

## 풀이 1 : 내 풀이(equals 사용)
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        HashMap<Character, Integer> counter1 = new HashMap<>();
        for (char ch : line.toCharArray()) {
            counter1.put(ch, counter1.getOrDefault(ch, 0) + 1);
        }

        line = br.readLine();
        HashMap<Character, Integer> counter2 = new HashMap<>();
        for (char ch : line.toCharArray()) {
            counter2.put(ch, counter2.getOrDefault(ch, 0) + 1);
        }
        br.close();

        String answer = (counter1.equals(counter2)) ? "YES" : "NO";
        System.out.print(answer);
    }
```
- 둘다 카운팅하고 맵을 equals로 비교했다.

## 풀이 2 : 같은 맵에서 카운트를 줄여가며 비교
```java
    private static String solution(String word1, String word2) {
        HashMap<Character, Integer> counter = new HashMap<>();
        for (char ch1 : word1.toCharArray()) {
            counter.put(ch1, counter.getOrDefault(ch1, 0) + 1);
        }

        for (char ch2 : word2.toCharArray()) {
            if (!counter.containsKey(ch2) || counter.get(ch2) == 0) {
                return "NO";
            }
            counter.put(ch2, counter.get(ch2) - 1);
        }
        return "YES";
    }
```
- 첫 단어는 카운팅한다.
- 두번째 단어 카운팅을 할 떄, 각 문자의 존재여부를 확인한다.
  - 문자가 존재하지 않거나, 갖고온 문자 카운트가 0이면 "NO"
  - 존재하면 카운트 감소
- 끝까지 정상적으로 순회되면 YES

---
