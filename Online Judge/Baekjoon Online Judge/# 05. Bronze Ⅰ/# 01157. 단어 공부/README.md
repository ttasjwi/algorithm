# \[BOJ 01157\] 단어 공부

- 난이도 : Bronze 1
- 문자열 처리, 카운팅
- 문제 : https://www.acmicpc.net/problem/1157

---  

## 외워둘 아스키코드
- 48 : '0'
- 65 : 'A'
- 97 : 'a'

---

## 풀이
```java
    public static void main(String[] args) throws IOException {
        int[] counter = new int[26];
        int input;

        while((input= System.in.read()) >= 65) {
            if (input>=97) {
                input = input - 32;
            }
            counter[input-65] ++;
        }

        char answer = ' ';
        int maxCount = Integer.MIN_VALUE;
        for (int i=0; i<26; i++) {
            if (counter[i] > maxCount) {
                maxCount = counter[i];
                answer = (char) (i+65);
            } else if (counter[i] == maxCount) {
                answer = '?';
            }
        }
        System.out.print(answer);
    }
```
- 단어마다 입력을 받고 배열로 카운팅을 함.

---
