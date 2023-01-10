
# 1.11 문자열 압축

- 분류 : 문자열(String)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 1.11)

---

## 풀이1 : 내 풀이 (방문배열 활용)
```java
    private static String solution(String word) {
        char[] chars = word.toCharArray(); // 문자열 배열
        boolean[] isVisited = new boolean[chars.length]; // 방문배열

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<chars.length; i++) {
            if (!isVisited[i]) { // 방문하지 않은 문자(계산되지 않은 연속문자 시작점)
                isVisited[i] = true; // 방문상태로 만든다.
                char current = chars[i]; // 현재 문자를 가져온다.
                int count = 1; // 현재 문자의 갯수는 1개인다.

                int j = i; // 인덱스 저장용으로 j 변수에 현재 인덱스를 저장한다.

                while(++j < chars.length && current == chars[j]) { 
                    isVisited[j] = true; // 연속하는 같은 문자들만큼을 방문처리
                    count ++; // 하고 카운팅한다
                }
                sb.append(current); // 현재 문자를 덧붙인다.
                if (count >= 2) {
                    sb.append(count); // 카운트만큼 갯수를 덧붙인다.
                }
            }
        }
        return sb.toString(); // 스트링빌더 문자열로 변환 후 반환
    }
```
- for문을 돌되, 방문하지 않은 인덱스를 기준으로 연속된 문자의 갯수를 센다.
  - 연속된 문자가 나오는 부분은 방문처리한다.
- 반복 문자, 문자의 갯수를 StringBuilder에 append 한다.

---

## 풀이2 : 강사님 풀이
```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String answer = solution(word);
        System.out.print(answer);
    }

    private static String solution(String word) {
        word = new StringBuilder(word).append(' ').toString(); // 계산의 편의를 위해 마지막 한칸을 공백을 추가

        StringBuilder sb = new StringBuilder();

        int count = 1; // 문자 카운팅은 1로 초기화

        for (int i=0; i<word.length()-1; i++) {
            char current = word.charAt(i); // 현재 문자
            char next = word.charAt(i+1); // 다음 문자

            if (current == next) {
                count ++; // 다음 문자가 같으면 카운트 증가
            } else { // 다음이 다른 문자면 여태 누적해온걸 StringBuilder에 반영한다.
                sb.append(current);
                if (count >= 2) {
                    sb.append(count);
                }
                count = 1; //카운트를 초기화한다.
            }
        }
        return sb.toString();
    }
}
```
- 계산의 편의를 위해 마지막에 공백문자 하나를 더한 문자를 기준으로 반복
- 각 인덱스마다 현재 문자, 다음 문자를 비교하여 
  - 다음 문자가 같으면 카운트를 증가
  - 다음 문자가 다르면 StringBuilder에 현재 문자를 기입하고, 여태 누적해온 카운트를 반영
    - 이후 카운트는 다시 초기화한다.

---
