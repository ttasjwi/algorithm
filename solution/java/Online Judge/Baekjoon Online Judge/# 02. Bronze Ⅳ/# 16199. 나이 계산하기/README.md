# \[BOJ 16199] 나이 계산하기

- 난이도 : Bronze4
- 생년월일, 기준년월일이 입력됐을 때 나이 계산하기(만 나이, 세는 나이, 연 나이)
- 문제 : <a href="https://www.acmicpc.net/problem/16199" target="_blank">링크</a>
- 풀이 소스코드 :  <a href="src/Main.java" target="_blank">gitHub</a>

---  

## Main.java : 백준 제출 답안
- 사용자로부터 라인으로 다음 값들을 순서대로 입력받는다.
  - 생년월일
  - 기준년월일 (생년월일보다 더 빠를 수 없다.)
- StringTokenizer로 순서대로 쪼개고 이들의 차인 `yearGap`, `monthGap`, `dateGap`을 산출한다.
- 연 나이 : 기준 년도 - 태어난 연도
- 세는 나이 : 연나이 + 1
- 만 나이
  - 기준월일이 생월일 이전일 때`(montGap < 0 || (monthGap == 0 && dateGap < 0))` : 연 나이 - 1 
  - 기준월일이 생월일이거나 그 이후일 때 : 연 나이
- StringBuilder로 append한 뒤 출력
---

# Review
- 날짜 전후관계 따지는데 정말 헷갈렸다. 계속 틀렸음.

---
