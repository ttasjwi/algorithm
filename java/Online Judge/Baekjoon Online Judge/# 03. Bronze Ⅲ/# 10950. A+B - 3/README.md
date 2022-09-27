# \[BOJ 10950] A+B - 3

- 난이도 : Bronze3
- 각 라인별로 숫자들의 합을 구하여 모두 출력하기
- 문제 : <a href="https://www.acmicpc.net/problem/10950" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>

---  

## Main.java : 백준 제출 답안
- 테스트케이스의 갯수만큼 반복문 돌림
- 라인별로 숫자값들 합을 구하고 `StringBuilder`로 수집

---

# Review
- BufferedWriter 같은 것도 써봤는데, 출력 문자열 수집은 `StringBuilder`로 하는게 제일 빠른 것 같다.
  - StringBuilder는 "thread not safe"하지만 어차피 싱글스레드 처리하므로 StringBuilder로 씀

---
