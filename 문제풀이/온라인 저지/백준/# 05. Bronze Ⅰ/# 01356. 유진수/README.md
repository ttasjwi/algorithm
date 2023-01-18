# \[BOJ 01356] 유진수

- 난이도 : Bronze1
- 입력값을 둘로 쪼갰을 때, 각 자리별 숫자 곱이 같은 경우가 존재하는지(유진수) 여부 판단하여 결과 출력
- 문제 : <a href="https://www.acmicpc.net/problem/1356" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>

---  

## Main.java : 백준 제출 답안
- 길이가 1이면 유진수일 수 없으므로 "NO" 출력
- 그 이외의 경우 각 자릿값을 배열에 저장
- 반복문을 돌려서 모든 케이스에 대하여 곱이 같은지 판단하고, 유진수인 경우가 나오면 `isYuzinu`를 true로 하고 반복문 탈출
- `isYuzinsu`가 true 이면 "YES", false이면 "NO" 출력

---

# Review
- 파싱에 '0'을 제하는 기법을 사용

---
