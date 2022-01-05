# \[BOJ 01076] 저항

- 난이도 : Bronze2
- 
- 문제 : <a href="https://www.acmicpc.net/problem/1076" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>

---  

## Main.java : 백준 제출 답안
- `getResistanceValue(String color)` : 저항값
  - switch-case문 활용
- `getResistanceMultiple(String color)` : 저항곱
  - 저항값을 위의 메서드로 받아온 뒤 대응하는 10의 거듭제곱값 반환
- (첫번째 저항값 * 10 + 두번째 저항값) * (세번째 저항곱)

---

# Review
- enum으로 푸는 사람도 있고, Map으로 푸는 사람도 있고, switch-case문으로 푸는 사람도 있고 다양한 풀이가 존재하더라.

---
