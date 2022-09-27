# \[BOJ 01297\] TV 크기 

난이도 : Bronze4

TV 대각선 길이, 높이비율, 너비 비율을 입력받아 실제 높이, 너비 출력  
문제 : <a href="https://www.acmicpc.net/problem/1297" target="_blank"> [링크]</a>

---  

## Main.java : 백준 제출 답안

- 소스 코드 : <a href="src/Main.java" target="_blank">gitHub</a>
- `BufferedReader`로 문자열을 입력받고, StringTokenizer로 분리
  - dValue, hRatio, wRatio
- 피타고라스의 정리를 이용해 대각선 비율 dRatio를 구한다.
- dValue에 코사인값(hRatio/dRatio)을 곱하여 높이값을 구함
- dValue에 사인값(wRatio/dRatio)을 곱하여 너비값를 구함
- `StringBuilder`를 이용해 문자열 결합을 하고, 결과를 `System.out.println`문으로 출력

---

## Review
- 문자열 결합을 할 때는 StringBuilder가 빠르다.
- 구현에 있어서는 가독성을 고려시 그냥 + 기호로 결합하는게 좋다.

---
