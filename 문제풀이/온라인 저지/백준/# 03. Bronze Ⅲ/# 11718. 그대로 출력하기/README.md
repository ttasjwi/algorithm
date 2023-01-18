# \[BOJ 11718] 그대로 출력하기

- 난이도 : Bronze3
- 값 입력받고 그대로 출력하기 + EOF 처리
- 문제 : <a href="https://www.acmicpc.net/problem/11718" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>

---  

## Main.java : 백준 제출 답안
- EOF 처리 : 입력값이 없을 때(null이 될때까지) 반복
- 라인별로 문자열을 `StringBuilder`로 수집

---

# Review
- EOF처리에 주의하면 됨.
  - `BufferedReader`는 개행문자만 입력시 null을 읽어오는 것에 착안

---
