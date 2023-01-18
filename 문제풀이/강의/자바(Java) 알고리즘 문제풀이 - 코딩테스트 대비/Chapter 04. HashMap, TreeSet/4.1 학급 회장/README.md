# 4.1 학급 회장

- 분류 : 해시 테이블
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 4.1)

---

### 풀이
```java
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 학생수
        String line = br.readLine();
        br.close();

        HashMap<Character, Integer> counter = new HashMap<>();
        for (char ch : line.toCharArray()) {
            counter.put(ch, counter.getOrDefault(ch, 0) + 1);
        }
        
        char maxChar = ' ';
        int maxCount = 0;
        int count;
        char ch;
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            ch = entry.getKey();
            count = entry.getValue();

            if (count > maxCount) {
                maxChar = ch;
                maxCount = count;
            }
        }
        System.out.print(maxChar);
    }
```
- 입력받은 단어의 각 문자를 만날 때마다 HashMap에 카운팅을 갱신한다.
- 맵에서 문자, 갯수를 꺼낼 때 entrySet을 활용한다.

---