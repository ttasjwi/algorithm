# \[BOJ 11721] 열 개씩 끊어 출력하기

- 난이도 : Bronze2
- 문자열 입력받고 10개단위로 라인을 나눠서 출력
- 문제 : <a href="https://www.acmicpc.net/problem/11721" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>

---  

## Main.java : 백준 제출 답안
- 문자열을 입력받고, 문자열의 길이를 LENGTH로 저장
  - LENGTH를 10으로 나눈 값은 10개짜리 문자열의 갯수이다.
  - LENGTH를 10으로 나누고 10을 곱하면 그 값은 마지막 라인의 첫번째 인덱스이다.
- 10개짜리 문자열들은 Stringbuilder에 추가 후, 개행문자도 추가한다.
- 마지막 문자열은 StringBuilder에 추가한다.
- StringBilder 출력

---

# Review
- 똑같은 코드를 계속 해봐도 124ms ~ 136ms 왔다갔다 한다.
- 심지어 120ms짜리 코드를 그대로 넣어봐도 이것보다 더 나온다.
- 정말 백준의 시간 계산은 납득 안 되는 구석도 너무 많고... 적당히 신경써야겠다.

---
