# \[BOJ 10953] A+B - 6

- 난이도 : Bronze2
- 각 라인별로 숫자들의 합을 구하여 모두 출력하기
- 문제 : <a href="https://www.acmicpc.net/problem/10953" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>

---  

## Main.java : 백준 제출 답안
- 테스트케이스의 갯수만큼 반복문 돌림
- ','를 구분자로 하는데, 어차피 전부 한자리 숫자이므로 0번째 자리 문자, 2번째 자리 문자를 각각 파싱해서 처리함
- 라인별로 숫자값들 합을 구하고 `StringBuilder`로 수집

---

# Review
- 한자리 숫자 파싱에 있어서는 문자에서 '0'을 제하는 방식이 제일 빠른 것 같다.

---
