# \[BOJ 10951] A+B - 4

- 난이도 : Bronze3
- 각 라인별로 숫자들의 합을 구하여 모두 출력하기 + EOF 처리
- 문제 : <a href="https://www.acmicpc.net/problem/10951" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>

---  

## Main.java : 백준 제출 답안
- 사용자로부터 값이 입력되지 않을 때까지 무한 반복
  - EOF처리가 필요한데, BufferedReader의 `readLine()` 메서드는 개행문자만 입력하면 null이 반환되므로 이를 이용하여 EOF처리를 함.
- 라인별로 숫자값들 합을 구하고 `StringBuilder`로 수집

---

# Review
- EOF 처리에서 애를 먹었던 부분

---
