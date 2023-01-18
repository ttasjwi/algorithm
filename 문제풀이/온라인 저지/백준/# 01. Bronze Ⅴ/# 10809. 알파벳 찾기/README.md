# \[BOJ 10809\] 알파벳 찾기

- 난이도 : Bronze 5
- 처음 등장하는 인덱스 찾기
- 문제 : https://www.acmicpc.net/problem/10809

---

## 풀이
```java
    public static void main(String[] args) throws IOException {
        int[] firstIndexes = new int[26];
        for (int i=0; i<26; i++) firstIndexes[i] = -1;

        int index = 0;
        int input;
        while((input = System.in.read()) != '\n') {
            if (firstIndexes[input - 97] == -1) {
                firstIndexes[input-97] = index;
            }
            index ++;
        }

        StringBuilder sb = new StringBuilder();
        for (int firstIndex : firstIndexes) {
            sb.append(firstIndex).append(' ');
        }
        System.out.print(sb);
    }
```
- 알파벳 종류만큼 배열을 만들어둔다.
- 문자를 읽자마자 97 차감한 위치의 값을 갱신한다. (저장값이 -1일 때만)
- 저장된 인덱스를 순차적으로 출력한다.
- indexOf 메서드를 사용해도 된다.

---
