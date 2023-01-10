# \[BOJ 02386] 도비의 영어공부

- 난이도 : Bronze2
- 알파벳 하나와, 영어문장이 주어졌을 때 문장에 나타난 알파벳의 갯수 세기
- 문제 : <a href="https://www.acmicpc.net/problem/2386" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>

---  

## Main.java : 백준 제출 답안
- `while(true)`문 (무한반복)
  - 입력받은 라인을 전부 소문자화 하고(`toLowerCase()`), 배열에 저장한다. (`toCharArray()`)
  - 첫번째 문자를 `search` 변수에 저장하고, `search`가 '#'이면 반복문을 탈출한다.
  - 그 외의 경우, search로 1번 인덱스의 문자부터 문자열의 끝까지 순회하며, search와 일치하면 count를 증가시킨다.
  - 반복을 마무리지으면 `StringBuilder`에 `search`와 `count`를 append한다.
- `StringBuilder`를 출력한다.

---

# Review
- 소문자화를 `toLowerCase`로 처리함
- `Bronzer2`라 하기엔 너무 쉬운 문제 같다. `Bronze4`, `Brornze3` 보니까 이거보다 어려운 문제도 많았어.

---
