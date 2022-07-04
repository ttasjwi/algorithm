

# 1-3. 문장속 단어

- 분류 : 문자열(String)
- 문제 : (자바(Java) 알고리즘 문제풀이 : 코딩테스트 대비 - 1-3 문제)

---

## 시간복잡도
- 문자열의 단어의 갯수만큼 반복해야하므로, 단어의 갯수를 N이라 하면 O(N)

---


## 풀이 1
```java
public class Main1  {

    private static String solution(String[] words) {
        String maxLengthString = "";
        for (String word : words) {
            if (word.length() > maxLengthString.length()) {
                maxLengthString = word;
            }
        }
        return maxLengthString;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] words = line.split(" +");

        String answer = solution(words);
        System.out.print(answer);
    }
}

```
- split으로 분리 후 length가 가장 긴 단어를 반환하도록 함

---

## 풀이2
```java
public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String answer = solution(line);
        System.out.print(answer);
    }

    private static String solution(String line) {
        String maxLengthWord = "";
        
        String word;
        int spaceIndex;

        while ((spaceIndex= line.indexOf(' '))!= -1) {
            word = line.substring(0, spaceIndex);
            if (word.length() > maxLengthWord.length()) {
                maxLengthWord = word;
            }
            line = line.substring(spaceIndex + 1);
        }

        // 마지막 남은 단어
        if (line.length() > maxLengthWord.length()) {
            maxLengthWord = line;
        }
        return maxLengthWord;
    }
}

```
- 라인채로 입력받아서 처리
- subString으로 분리해서 while문 돌려서 반복 처리
- 주요 기본 자바 API
  - subString : start, end 기준 단어 분리 (end 미포함)
  - indexOf : 해당 문자의 인덱스 반환 (없으면 -1)

---
