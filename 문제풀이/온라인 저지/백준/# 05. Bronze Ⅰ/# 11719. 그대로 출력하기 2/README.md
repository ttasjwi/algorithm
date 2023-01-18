# \[BOJ 11719] 그대로 출력하기

- 난이도 : Bronze1
- 값 입력받고 그대로 출력하기 + EOF 처리
- 문제 : <a href="https://www.acmicpc.net/problem/11719" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>

---  

## Main.java : 백준 제출 답안
- EOF 처리 : 입력값이 없을 때(null이 될때까지) 반복
- 라인별로 문자열을 `StringBuilder`로 수집

---

# Review
- EOF처리에 주의하면 됨.
    - `BufferedReader`는 입력값이 없을시 null을 읽어오는 것에 착안
- 11718과 소스코드 똑같은걸 입력했음

---
