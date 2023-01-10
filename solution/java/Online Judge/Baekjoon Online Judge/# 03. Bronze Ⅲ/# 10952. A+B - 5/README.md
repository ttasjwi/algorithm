# \[BOJ 10952] A+B - 5

- 난이도 : Bronze3
- 각 라인별로 숫자들의 합을 구하여 모두 출력하기 + EOF 처리(특정 값 입력)
- 문제 : <a href="https://www.acmicpc.net/problem/10952" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>

---  

## Main.java : 백준 제출 답안
- 사용자로부터 값이 입력되지 않을 때까지 무한 반복
    - EOF처리가 필요한데, 여기서는 두 숫자값이 모두 0일 때 반복을 종료하도록 함.
- 라인별로 숫자값들 합을 구하고 `StringBuilder`로 수집

---

# Review
- EOF 처리에서 무한반복문 안에 조건문을 넣어 처리함.
- 한자리 숫자 파싱에 있어서는 문자에서 '0'을 제하는 방식이 제일 빠른 것 같다.

---
